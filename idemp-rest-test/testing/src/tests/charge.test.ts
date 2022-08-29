import { createChargeType, createCharge } from '../utils';
import { chargeApi } from '../api/charges';
import { chargeTypeApi } from '../api/chargeTypes';

test('income category is saved and returned', async () => {
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

	// retrieve charge via rest
	const charge = (await chargeApi.getByUuid(globalThis.__VALUE_OBJECT__, valueObject.charge!.uuid));

	expect(charge.name).toBe(valueObject.charge!.name);
});