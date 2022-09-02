import { invoiceApi } from '../api';
import { documentBaseType } from '../models';
import { createBusinessPartner, createCharge, createStandaloneInvoice } from '../utils';

test('creating an invoice with a charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create Business Partner';
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
