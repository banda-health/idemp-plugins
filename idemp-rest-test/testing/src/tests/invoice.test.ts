import { invoiceApi } from '../api';
import { createChargeType, createCharge, createInvoice } from '../utils';

test('Track income works', async () => {
	const INCOME_CATEGORY_CHARGE_TYPE_NAME = 'Default Income Category - DO NOT CHANGE';

	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// create charge type
	valueObject.stepName = INCOME_CATEGORY_CHARGE_TYPE_NAME;
	await createChargeType(valueObject);

	// create a charge
	valueObject.stepName = 'Create Charge';
	valueObject.chargeType = valueObject.chargeType;
	valueObject.account = valueObject.account;
	await createCharge(valueObject);

	// create invoice
	valueObject.stepName = 'Create Invoice';
	//valueObject.businessPartner =
	await createInvoice(valueObject);
});


