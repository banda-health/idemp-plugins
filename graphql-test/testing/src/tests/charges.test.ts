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
				Size: 1,
				Filter: JSON.stringify({ isactive: true, name: 'Default Expense Category - DO NOT CHANGE' }),
			},
		})
	).data.C_ChargeTypeGet.Results[0];
	expect(defaultExpenseCategoryChargeType).toBeTruthy();
	const doNotChangeAccount = (
		await query(valueObject)({
			query: C_ElementValueGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ value: '99999' }) },
		})
	).data.C_ElementValueGet.Results[0];
	expect(doNotChangeAccount).toBeTruthy();

	valueObject.stepName = 'Create charge';
	const chargeUuid = v4();
	const savedCharge = (
		await mutate(valueObject)({
			mutation: C_ChargeSaveDocument,
			variables: {
				Entity: {
					UU: chargeUuid,
					AD_Org: { UU: valueObject.organization!.UU },
					C_ChargeType: { UU: defaultExpenseCategoryChargeType.UU },
					Description: valueObject.getStepMessageLong(),
					Name: `${valueObject.random}_${valueObject.scenarioName}`,
				},
			},
		})
	).data?.C_ChargeSave;
	await mutate(valueObject)({
		mutation: C_Charge_AcctSaveDocument,
		variables: {
			Entity: {
				UU: savedCharge?.C_Charge_AcctList?.[0]?.UU,
				Ch_Expense_A: {
					UU: (
						await mutate(valueObject)({
							mutation: C_ValidCombinationGetOrCreateDocument,
							variables: {
								Account_UU: doNotChangeAccount.UU,
								C_AcctSchema_UU: savedCharge?.C_Charge_AcctList?.[0]?.C_AcctSchema.UU,
							},
						})
					).data!.C_ValidCombinationGetOrCreate.UU,
				},
			},
		},
	});
	const charge = (
		await query(valueObject)({
			query: C_ChargeGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ c_charge_uu: chargeUuid }) },
		})
	).data.C_ChargeGet.Results[0];

	expect(charge.C_ChargeType?.UU).toBe(defaultExpenseCategoryChargeType.UU);
	expect(charge.C_Charge_AcctList?.[0]?.Ch_Expense_A.Account.UU).toBe(doNotChangeAccount.UU);
});

test('save charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const doNotChangeAccount = (
		await query(valueObject)({
			query: C_ElementValueGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ value: '99999' }) },
		})
	).data.C_ElementValueGet.Results[0];
	expect(doNotChangeAccount).toBeTruthy();
	expect(doNotChangeAccount).toBeTruthy();

	const chargeToSave: C_ChargeSaveMutationVariables['Entity'] = {
		AD_Org: { UU: valueObject.organization!.UU },
		Description: valueObject.getStepMessageLong(),
		Name: `${valueObject.random}_${valueObject.scenarioName}`,
	};
	const savedCharge = (
		await mutate(valueObject)({
			mutation: C_ChargeSaveDocument,
			variables: {
				Entity: chargeToSave,
			},
		})
	).data?.C_ChargeSave;
	await mutate(valueObject)({
		mutation: C_Charge_AcctSaveDocument,
		variables: {
			Entity: {
				UU: savedCharge?.C_Charge_AcctList?.[0]?.UU,
				Ch_Expense_A: {
					UU: (
						await mutate(valueObject)({
							mutation: C_ValidCombinationGetOrCreateDocument,
							variables: {
								Account_UU: doNotChangeAccount.UU,
								C_AcctSchema_UU: savedCharge?.C_Charge_AcctList?.[0]?.C_AcctSchema.UU,
							},
						})
					).data!.C_ValidCombinationGetOrCreate.UU,
				},
			},
		},
	});

	expect(savedCharge?.Name).toBeTruthy();
	expect(savedCharge?.Name).toBe(chargeToSave.Name);
	const charge = (
		await query(valueObject)({
			query: C_ChargeGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ c_charge_uu: savedCharge?.UU }) },
		})
	).data.C_ChargeGet.Results[0];
	expect(charge.C_Charge_AcctList?.[0]?.Ch_Expense_A.Account.UU).toBe(doNotChangeAccount.UU);
});
