import { createChargeType, createCharge } from '../utils';
import { chargeApi } from '../api/charges';

test('income category is saved and returned', async () => {
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

	// retrieve charges via rest
	const filterJson = '{ "$and": [{"isactive" : {"$eq": true}}, {"c_chargetype": {"$eq" : "' + INCOME_CATEGORY_CHARGE_TYPE_NAME + '" }}]}';

	const charges = (await chargeApi.get(globalThis.__VALUE_OBJECT__, 1, 100, undefined, filterJson)).results;

	expect(charges.length).toBe(1);

	expect(charges[0].chargeType.name).toBe(INCOME_CATEGORY_CHARGE_TYPE_NAME);
});


