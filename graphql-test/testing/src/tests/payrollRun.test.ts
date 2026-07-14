import {
	Bh_PayrollPreviewDocument,
	Bh_Payroll_RunDocument,
	Bh_Payroll_RunDraftDocument,
	Bh_Payroll_RunProcessDocument,
	Hr_DepartmentSaveDocument,
	Hr_EmployeeSaveDocument,
	Hr_JobSaveDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { createBusinessPartner, formatApiDate } from '../utils';

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

	// This test locks (and re-locks) the month it drafts, so a fixed month/year would collide with a
	// prior run on a DB that isn't reset between runs (e.g. re-running this spec without restarting the
	// stack). Derive a month/year that's effectively unique per run instead.
	const payrollYear = 2200 + (Date.now() % 700);
	const payrollMonth = (Date.now() % 12) + 1;

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
