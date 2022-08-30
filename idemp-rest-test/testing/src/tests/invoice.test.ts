import { invoiceApi } from '../api';
import { createChargeType, createCharge, createInvoice, createBusinessPartner } from '../utils';

test('Track income works', async () => {
	const INCOME_CATEGORY_CHARGE_TYPE_NAME = 'Default Income Category - DO NOT CHANGE';

	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// get default charge type..
	const filterJson = '{ "$and": [{"isactive" : {"$eq": true}}, {"c_chargetype": {"$eq" : "' + INCOME_CATEGORY_CHARGE_TYPE_NAME + '" }}]}';
	const chargeTypes = (await chargeTypeApi.get(valueObject, 0, 1, undefined, filterJson)).results;
	expect(chargeTypes.length).toBe(1);
	valueObject.chargeType = chargeTypes[0];

	// create a charge
	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);
	
	// create supplier
	valueObject.stepName = 'Create Supplier';
	await createBusinessPartner(valueObject);

	// create invoice
	valueObject.stepName = 'Create Invoice';
	await createInvoice(valueObject);
	
	expect(( await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid))).toBe(valueObject.invoice!.uuid);
});

test('Search track income fields', async() => {
	const INCOME_CATEGORY_CHARGE_TYPE_NAME = 'Default Income Category - DO NOT CHANGE';

	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// get default charge type..
	let filterJson = '{ "$and": [{"isactive" : {"$eq": true}}, {"c_chargetype": {"$eq" : "' + INCOME_CATEGORY_CHARGE_TYPE_NAME + '" }}]}';
	const chargeTypes = (await chargeTypeApi.get(valueObject, 0, 1, undefined, filterJson)).results;
	expect(chargeTypes.length).toBe(1);
	valueObject.chargeType = chargeTypes[0];

	// create a charge
	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	// create supplier
	valueObject.stepName = 'Create Supplier';
	await createBusinessPartner(valueObject);

	// create invoice
	valueObject.stepName = 'Create Invoice';
	await createInvoice(valueObject);

	expect(( await invoiceApi.getByUuid(valueObject, valueObject.invoice!.uuid))).toBe(valueObject.invoice!.uuid);

	// search invoice
	filterJson = '{ "$and": [{"isactive" : {"$eq": true}]}';
	const invoices = (await invoiceApi.get(valueObject, 0, 10, undefined, filterJson)).results;

	const invoice = invoices[0];
	expect(invoice.businessPartner).not.toBe(null);
	expect(invoice.dateInvoiced).not.toBe(null);
	expect(invoice.grandTotal).not.toBe(null);
	expect(invoice.docStatus).not.toBe(null);
});
