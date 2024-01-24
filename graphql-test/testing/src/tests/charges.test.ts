import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { createCharge } from '../utils';
import {
	C_ChargeGetDocument,
	C_ChargeSaveDocument,
	C_ChargeSaveMutationVariables,
	C_ChargeTypeGetDocument,
	C_Charge_AcctSaveDocument,
	C_ElementValueGetDocument,
	C_ValidCombinationGetOrCreateDocument,
} from '../__generated__/graphql';

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

	valueObject.stepName = 'Get default expense category';
	const defaultExpenseCategoryChargeType = (
		await query(valueObject)({
			query: C_ChargeTypeGetDocument,
			variables: {
				size: 1,
				filter: JSON.stringify({ isactive: true, name: 'Default Expense Category - DO NOT CHANGE' }),
			},
		})
	).data.C_ChargeTypeGet.results[0];
	expect(defaultExpenseCategoryChargeType).toBeTruthy();
	const doNotChangeAccount = (
		await query(valueObject)({
			query: C_ElementValueGetDocument,
			variables: { size: 1, filter: JSON.stringify({ value: '99999' }) },
		})
	).data.C_ElementValueGet.results[0];
	expect(doNotChangeAccount).toBeTruthy();

	valueObject.stepName = 'Create charge';
	const chargeUuid = v4();
	const savedCharge = (
		await mutate(valueObject)({
			mutation: C_ChargeSaveDocument,
			variables: {
				entity: {
					UUID: chargeUuid,
					AD_Org: { UUID: valueObject.organization!.UUID },
					C_ChargeType: { UUID: defaultExpenseCategoryChargeType.UUID },
					Description: valueObject.getStepMessageLong(),
					Name: `${valueObject.random}_${valueObject.scenarioName}`,
				},
			},
		})
	).data?.C_ChargeSave;
	await mutate(valueObject)({
		mutation: C_Charge_AcctSaveDocument,
		variables: {
			entity: {
				UUID: savedCharge?.C_Charge_AcctList?.[0]?.UUID,
				Ch_Expense_A: {
					UUID: (
						await mutate(valueObject)({
							mutation: C_ValidCombinationGetOrCreateDocument,
							variables: {
								Account_UU: doNotChangeAccount.UUID,
								C_AcctSchema_UU: savedCharge?.C_Charge_AcctList?.[0]?.C_AcctSchema.UUID,
							},
						})
					).data!.C_ValidCombinationGetOrCreate.UUID,
				},
			},
		},
	});
	const charge = (
		await query(valueObject)({
			query: C_ChargeGetDocument,
			variables: { size: 1, filter: JSON.stringify({ c_charge_uu: chargeUuid }) },
		})
	).data.C_ChargeGet.results[0];

	expect(charge.C_ChargeType?.UUID).toBe(defaultExpenseCategoryChargeType.UUID);
	expect(charge.C_Charge_AcctList?.[0]?.Ch_Expense_A.Account.UUID).toBe(doNotChangeAccount.UUID);
});

test('save charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const doNotChangeAccount = (
		await query(valueObject)({
			query: C_ElementValueGetDocument,
			variables: { size: 1, filter: JSON.stringify({ value: '99999' }) },
		})
	).data.C_ElementValueGet.results[0];
	expect(doNotChangeAccount).toBeTruthy();
	expect(doNotChangeAccount).toBeTruthy();

	const chargeToSave: C_ChargeSaveMutationVariables['entity'] = {
		AD_Org: { UUID: valueObject.organization!.UUID },
		Description: valueObject.getStepMessageLong(),
		Name: `${valueObject.random}_${valueObject.scenarioName}`,
	};
	const savedCharge = (
		await mutate(valueObject)({
			mutation: C_ChargeSaveDocument,
			variables: {
				entity: chargeToSave,
			},
		})
	).data?.C_ChargeSave;
	await mutate(valueObject)({
		mutation: C_Charge_AcctSaveDocument,
		variables: {
			entity: {
				UUID: savedCharge?.C_Charge_AcctList?.[0]?.UUID,
				Ch_Expense_A: {
					UUID: (
						await mutate(valueObject)({
							mutation: C_ValidCombinationGetOrCreateDocument,
							variables: {
								Account_UU: doNotChangeAccount.UUID,
								C_AcctSchema_UU: savedCharge?.C_Charge_AcctList?.[0]?.C_AcctSchema.UUID,
							},
						})
					).data!.C_ValidCombinationGetOrCreate.UUID,
				},
			},
		},
	});

	expect(savedCharge?.Name).toBeTruthy();
	expect(savedCharge?.Name).toBe(chargeToSave.Name);
	const charge = (
		await query(valueObject)({
			query: C_ChargeGetDocument,
			variables: { size: 1, filter: JSON.stringify({ c_charge_uu: savedCharge?.UUID }) },
		})
	).data.C_ChargeGet.results[0];
	expect(charge.C_Charge_AcctList?.[0]?.Ch_Expense_A.Account.UUID).toBe(doNotChangeAccount.UUID);
});
