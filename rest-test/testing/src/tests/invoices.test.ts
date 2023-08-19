import { invoiceApi } from '../api';
import { documentAction, documentBaseType, documentStatus } from '../models';
import { createBusinessPartner, createCharge, createInvoice } from '../utils';

test('creating an invoice with a charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

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
	await createInvoice(valueObject);

	valueObject.stepName = 'Create second charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const secondCharge = valueObject.charge!;

	valueObject.stepName = 'Create second invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create third charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const thirdCharge = valueObject.charge!;

	valueObject.stepName = 'Create second business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create third invoice';
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

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

test(`vendor invoices can be deleted when they haven't been completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create vendor invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	expect(await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid)).toBeTruthy();
	expect(await invoiceApi.delete(valueObject, valueObject.invoice!.uuid)).toBe(true);
	expect(await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid)).toBeFalsy();
});

test(`vendor invoices are voided when they've been completed and you try to delete them`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create vendor invoice';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);
	expect(valueObject.invoice).toBeTruthy();
	expect(valueObject.invoice!.docStatus).toBe(documentStatus.Completed);

	expect(await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid)).toBeTruthy();
	expect(await invoiceApi.delete(valueObject, valueObject.invoice!.uuid)).toBe(true);
	const invoice = await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid);
	expect(invoice).toBeTruthy();
	expect(invoice.docStatus).toBe(documentStatus.Reversed);
});

test('can complete an invoice', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Complete invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	valueObject.documentAction = documentAction.Complete;
	await createInvoice(valueObject);

	expect(valueObject.invoice).toBeTruthy();
	expect(valueObject.invoice?.docStatus).toBe(documentStatus.Completed);
});
