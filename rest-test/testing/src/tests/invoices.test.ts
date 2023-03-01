import { accountApi, chargeApi, expenseCategoryApi, invoiceApi } from '../api';
import { expenseApi } from '../api/expenses';
import { documentAction, documentBaseType, documentStatus } from '../models';
import {
	BusinessPartner,
	Expense,
	ExpenseCategory,
	Invoice,
	InvoiceLine,
	Vendor,
} from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createCharge, createStandaloneInvoice } from '../utils';

test('creating an invoice with a charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createStandaloneInvoice(valueObject);

	expect((await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid)).uuid).toBe(valueObject.invoice!.uuid);
});

test('invoice searching', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create first charge';
	await createCharge(valueObject);
	const firstCharge = valueObject.charge!;

	valueObject.stepName = 'Create first business partner';
	await createBusinessPartner(valueObject);
	const firstBusinessPartner = valueObject.businessPartner!;

	valueObject.stepName = 'Create first invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createStandaloneInvoice(valueObject);

	valueObject.stepName = 'Create second charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const secondCharge = valueObject.charge!;

	valueObject.stepName = 'Create second invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createStandaloneInvoice(valueObject);

	valueObject.stepName = 'Create third charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const thirdCharge = valueObject.charge!;

	valueObject.stepName = 'Create second business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create third invoice';
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createStandaloneInvoice(valueObject);

	let invoices = (
		await invoiceApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({
				$or: [
					{ c_invoiceline: { c_charge: { name: firstCharge.name } } },
					{ c_invoiceline: { c_charge: { name: secondCharge.name } } },
					{ c_invoiceline: { c_charge: { name: thirdCharge.name } } },
				],
			}),
		)
	).results;
	expect(invoices).toHaveLength(3);

	invoices = (
		await invoiceApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { name: firstBusinessPartner.name } }),
		)
	).results;
	expect(invoices).toHaveLength(2);
});

test(`expenses can be deleted when they haven't been completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	let expenseCategory: Partial<ExpenseCategory> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: `${valueObject.random}_${valueObject.scenarioName}`,
		accountUuid: (
			await accountApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ issummary: false, name: 'Utilities' }),
			)
		).results[0].uuid,
	};
	expenseCategory = await expenseCategoryApi.save(valueObject, expenseCategory as ExpenseCategory);

	valueObject.stepName = 'Create expense';
	const supplier = {
		...valueObject.businessPartner,
		patientNumber: undefined,
		dateOfBirth: undefined,
		gender: undefined,
		nhifRelationship: undefined,
		totalVisits: undefined,
		isApproximateDateOfBirth: undefined,
		phoneNumber: '123-123-123',
		emailAddress: 'valiantForTruth@celestialKingdom.com',
	} as Vendor;
	let expense: Partial<Expense> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		supplier,
		businessPartner: { ...supplier, phoneNumber: undefined, emailAddress: undefined } as BusinessPartner,
		dateInvoiced: valueObject.date?.toISOString(),
		invoiceLines: [],
	};
	const invoiceLine: Partial<InvoiceLine> = {
		description: valueObject.getStepMessageLong(),
		quantity: valueObject.quantity || 1,
		expenseCategory: expenseCategory as ExpenseCategory,
	};
	expense.invoiceLines?.push(invoiceLine as InvoiceLine);

	expense = await expenseApi.save(valueObject, expense as Expense);
	if (!expense) {
		throw new Error('Expense not created');
	}

	expect(await expenseApi.getByUuid(valueObject, expense.uuid!)).toBeTruthy();
	expect(await expenseApi.delete(valueObject, expense.uuid!)).toBe(true);
	expect(await expenseApi.getByUuid(valueObject, expense.uuid!)).toBeFalsy();
});

test(`expenses are voided when they've been completed and you try to delete them`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	let expenseCategory: Partial<ExpenseCategory> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: `${valueObject.random}_${valueObject.scenarioName}`,
		accountUuid: (
			await accountApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ issummary: false, name: 'Utilities' }),
			)
		).results[0].uuid,
	};
	expenseCategory = await expenseCategoryApi.save(valueObject, expenseCategory as ExpenseCategory);

	valueObject.stepName = 'Create expense';
	const supplier = {
		...valueObject.businessPartner,
		patientNumber: undefined,
		dateOfBirth: undefined,
		gender: undefined,
		nhifRelationship: undefined,
		totalVisits: undefined,
		isApproximateDateOfBirth: undefined,
		phoneNumber: '123-123-123',
		emailAddress: 'valiantForTruth@celestialKingdom.com',
	} as Vendor;
	let expense: Partial<Expense> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		supplier,
		businessPartner: { ...supplier, phoneNumber: undefined, emailAddress: undefined } as BusinessPartner,
		dateInvoiced: valueObject.date?.toISOString(),
		invoiceLines: [],
	};
	const invoiceLine: Partial<InvoiceLine> = {
		description: valueObject.getStepMessageLong(),
		quantity: valueObject.quantity || 1,
		expenseCategory: expenseCategory as ExpenseCategory,
	};
	invoiceLine.price = (invoiceLine.quantity || 0) * (invoiceLine.product?.sellPrice || 0);
	expense.invoiceLines?.push(invoiceLine as InvoiceLine);

	expense = await expenseApi.saveAndProcess(valueObject, expense as Expense, documentAction.Complete);
	expect(expense).toBeTruthy();
	expect(expense.docStatus).toBe(documentStatus.Completed);

	expect(await expenseApi.getByUuid(valueObject, expense.uuid!)).toBeTruthy();
	expect(await expenseApi.delete(valueObject, expense.uuid!)).toBe(true);
	expense = await expenseApi.getByUuid(valueObject, expense.uuid!);
	expect(expense).toBeTruthy();
	expect(expense.docStatus).toBe(documentStatus.Reversed);
});
