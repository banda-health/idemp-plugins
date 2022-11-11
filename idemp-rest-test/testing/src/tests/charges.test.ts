import { accountApi, chargeApi, chargeTypeApi, expenseCategoryApi } from '../api';
import { Account, Charge, ExpenseCategory } from '../types/org.bandahealth.idempiere.rest';
import { createCharge } from '../utils';

test('charge creation', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	expect(valueObject.charge).toBeTruthy();
});

test('account mapping can be set up through a charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const defaultIncomeCategoryChargeType = (
		await chargeTypeApi.get(
			valueObject,
			0,
			100,
			undefined,
			JSON.stringify({ isactive: true, name: 'Default Income Category - DO NOT CHANGE' }),
		)
	).results[0];
	expect(defaultIncomeCategoryChargeType).toBeTruthy();
	const doNotChangeAccount = (
		await accountApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ value: '99999' }))
	).results[0];
	expect(doNotChangeAccount).toBeTruthy();

	const charge: Partial<Charge> = {
		orgId: 0,
		chargeType: defaultIncomeCategoryChargeType,
		description: valueObject.getStepMessageLong(),
		name: `${valueObject.random}_${valueObject.scenarioName}`,
		account: { uuid: doNotChangeAccount.uuid } as Account,
	};
	const savedCharge = await chargeApi.save(valueObject, charge as Charge);

	expect(savedCharge.chargeType.uuid).toBe(charge.chargeType?.uuid);
	expect(savedCharge.account.uuid).toBe(charge.account?.uuid);
});

test('save expense category', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const doNotChangeAccount = (
		await accountApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ value: '99999' }))
	).results[0];
	expect(doNotChangeAccount).toBeTruthy();

	const expenseCategory: Partial<ExpenseCategory> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: `${valueObject.random}_${valueObject.scenarioName}`,
		accountUuid: doNotChangeAccount.uuid,
	};
	
	const savedExpenseCategory = await expenseCategoryApi.save(valueObject, expenseCategory as ExpenseCategory);

	expect(savedExpenseCategory.name).toBe(expenseCategory.name);
	expect(savedExpenseCategory.accountUuid).toBe(expenseCategory.accountUuid);
});
