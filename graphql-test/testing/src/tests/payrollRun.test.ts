import {
	Bh_PayrollPreviewDocument,
	Bh_Payroll_RunDraftDocument,
	Bh_Payroll_RunProcessDocument,
	Hr_DepartmentSaveDocument,
	Hr_EmployeeSaveDocument,
	Hr_JobSaveDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { RoleName } from '../types/roleName';
import { createBusinessPartner, formatApiDate } from '../utils';

/**
 * A payroll period that's completed can only be unlocked while it's the client's latest completed
 * period (see MBHPayrollRun#reActivateIt), so the tests below that complete-and-lock a run each need
 * a period strictly ahead of any other. Use an implausible base year (no real client will ever reach
 * it) plus an in-process counter, incremented per reservation, so periods here are always distinct
 * and increasing in the order the tests run — no query round-trip required.
 *
 * Caveat: the counter restarts at the same base every fresh test run, so re-running this file
 * against a DB that wasn't reset since the last run can hit "Period is locked" on the base period
 * (a leftover from that prior run, not a bug). CI/the standard verification cycle always resets the
 * DB before running the suite, so this only affects manual repeat invocations without a restart.
 */
let payrollPeriodCounter = 0;

function nextPayrollPeriod() {
	const offset = payrollPeriodCounter++;
	return { year: 9000 + Math.floor(offset / 12), month: (offset % 12) + 1 };
}

/**
 * Create an HR employee in the current client (C_BPartner -> HR_Department -> HR_Job -> HR_Employee,
 * the same order the frontend DynamicMutation uses). Returns the employee UUID.
 */
async function createEmployee(
	valueObject: typeof globalThis.__VALUE_OBJECT__,
	salary: { basic: number; house: number; transport: number },
) {
	valueObject.stepName = 'Create employee business partner';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);
	const businessPartnerUuid = valueObject.businessPartner!.UU;

	const departmentUuid = (
		await mutate(valueObject)({
			mutation: Hr_DepartmentSaveDocument,
			variables: { Entity: { Name: 'Payroll Dept ' + valueObject.random, Value: 'DEPT' + valueObject.random } },
		})
	).data!.HR_DepartmentSave.UU;

	const jobUuid = (
		await mutate(valueObject)({
			mutation: Hr_JobSaveDocument,
			variables: {
				Entity: {
					Name: 'Payroll Job ' + valueObject.random,
					Value: 'JOB' + valueObject.random,
					HR_Department: { UU: departmentUuid },
				},
			},
		})
	).data!.HR_JobSave.UU;

	return (
		await mutate(valueObject)({
			mutation: Hr_EmployeeSaveDocument,
			variables: {
				Entity: {
					Name: 'Payroll Employee ' + valueObject.random,
					C_BPartner: { UU: businessPartnerUuid },
					HR_Department: { UU: departmentUuid },
					HR_Job: { UU: jobUuid },
					StartDate: formatApiDate(new Date('2020-01-01')),
					BH_BasicSalary: salary.basic,
					BH_HouseAllowance: salary.house,
					BH_TransportAllowance: salary.transport,
				},
			},
		})
	).data!.HR_EmployeeSave.UU;
}

test('payroll run drafts, previews net pay, then locks and unlocks', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// This test locks (and re-locks) the month it drafts, so it needs a period ahead of anything
	// else used in this file (see nextPayrollPeriod).
	const { year: payrollYear, month: payrollMonth } = nextPayrollPeriod();

	await createEmployee(valueObject, { basic: 45000, house: 12000, transport: 6000 });

	// Draft the month — creates the run and generates one line per active employee.
	const draft = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: payrollMonth, BH_PayrollYear: payrollYear },
		})
	).data!.BH_Payroll_RunDraft;
	const runUuid = draft!.UU;
	expect(runUuid).toBeTruthy();
	expect(draft!.DocStatus.Value).toBe('DR');
	expect(draft!.BH_Payroll_Run_Lines!.length).toBeGreaterThanOrEqual(1);

	// Stateless preview from the resolved catalogue — verified against a real 2026 payslip.
	const preview = (
		await query(valueObject)({
			query: Bh_PayrollPreviewDocument,
			variables: { BH_BasicSalary: 45000, BH_HouseAllowance: 12000, BH_TransportAllowance: 6000 },
		})
	).data.BH_PayrollPreview;
	expect(preview!.BH_NetPay).toBe(47196.25);

	// Complete (Finalize & Lock) — aggregates one filing per statutory component.
	const completed = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: runUuid, DocumentAction: 'CO' },
		})
	).data!.BH_Payroll_RunProcess;
	expect(completed!.DocStatus.Value).toBe('CO');
	expect(completed!.BH_Payroll_Filings!.length).toBe(5);

	// Re-Activate (Unlock) — drops back to Drafted and deletes the filings.
	const reactivated = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: runUuid, DocumentAction: 'RE' },
		})
	).data!.BH_Payroll_RunProcess;
	expect(reactivated!.DocStatus.Value).toBe('DR');

	// Complete a second time, then a draft for the same locked month must error.
	await mutate(valueObject)({
		mutation: Bh_Payroll_RunProcessDocument,
		variables: { UU: runUuid, DocumentAction: 'CO' },
	});
	await expect(
		mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: payrollMonth, BH_PayrollYear: payrollYear },
		}),
	).rejects.toThrow(/locked/);
});

test('re-activating a fresh draft errors instead of writing an audit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const draft = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: 8, BH_PayrollYear: 2026 },
		})
	).data!.BH_Payroll_RunDraft;
	expect(draft!.DocStatus.Value).toBe('DR');

	await expect(
		mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: draft!.UU, DocumentAction: 'RE' },
		}),
	).rejects.toBeTruthy();
});

test('drafting a payroll run with zero active employees errors', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// 1900-01 predates every employee StartDate this file (or any prior run against a reused DB)
	// creates, so the period resolves zero active employees regardless of test order.
	await expect(
		mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: 1, BH_PayrollYear: 1900 },
		}),
	).rejects.toThrow(/No active employees/);
});

test('drafting a payroll run rejects a role without payroll access', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	// Cashier/Registration Basic has no CO access on the BPR doc type (see Task 6 role-denial smoke);
	// drafting is gated on the same CO access RunProcess uses, so it must reject too.
	await valueObject.login(RoleName.CashierRegistrationBasic);

	await expect(
		mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: 1, BH_PayrollYear: 1900 },
		}),
	).rejects.toThrow(/Unauthorized/);
});

test('completing an already-completed payroll run rejects and leaves lines intact', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const { year: payrollYear, month: payrollMonth } = nextPayrollPeriod();

	await createEmployee(valueObject, { basic: 50000, house: 10000, transport: 5000 });

	const draft = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunDraftDocument,
			variables: { BH_PayrollMonth: payrollMonth, BH_PayrollYear: payrollYear },
		})
	).data!.BH_Payroll_RunDraft;
	const runUuid = draft!.UU;

	const completed = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: runUuid, DocumentAction: 'CO' },
		})
	).data!.BH_Payroll_RunProcess;
	expect(completed!.DocStatus.Value).toBe('CO');
	const linesAfterFirstComplete = completed!.BH_Payroll_Run_Lines!.map((line) => ({
		UU: line.UU,
		BH_NetPay: line.BH_NetPay,
	}));
	expect(linesAfterFirstComplete.length).toBeGreaterThanOrEqual(1);

	// A second Complete must reject with the already-completed message instead of deleting and
	// re-generating the lines (see MBHPayrollRun#completeIt's double-CO guard).
	await expect(
		mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: runUuid, DocumentAction: 'CO' },
		}),
	).rejects.toThrow(/already completed/);

	// Unlock to read the lines back — untouched by the rejected double-complete attempt.
	const reactivated = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_RunProcessDocument,
			variables: { UU: runUuid, DocumentAction: 'RE' },
		})
	).data!.BH_Payroll_RunProcess;
	expect(reactivated!.DocStatus.Value).toBe('DR');
	const linesAfterReactivate = reactivated!.BH_Payroll_Run_Lines!.map((line) => ({
		UU: line.UU,
		BH_NetPay: line.BH_NetPay,
	}));
	expect(linesAfterReactivate).toEqual(linesAfterFirstComplete);
});
