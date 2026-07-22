import {
	Bh_Payroll_SettingsDeleteDocument,
	Bh_Payroll_SettingsGetDocument,
	Bh_Payroll_SettingsSaveDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';

test('payroll settings round-trip the current period fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// UNIQUE (AD_Client_ID): reuse the client's existing row if a prior run left one behind.
	const existing = (
		await query(valueObject)({ query: Bh_Payroll_SettingsGetDocument, variables: {} })
	).data.BH_Payroll_SettingsGet.Results[0];

	const saved = (
		await mutate(valueObject)({
			mutation: Bh_Payroll_SettingsSaveDocument,
			variables: {
				Entity: {
					...(existing ? { UU: existing.UU } : {}),
					BH_PayDay: 25,
					BH_PayrollMonth: 6,
					BH_PayrollYear: 2026,
				},
			},
		})
	).data!.BH_Payroll_SettingsSave;
	expect(saved.BH_PayrollMonth).toBe(6);
	expect(saved.BH_PayrollYear).toBe(2026);

	const readBack = (
		await query(valueObject)({ query: Bh_Payroll_SettingsGetDocument, variables: {} })
	).data.BH_Payroll_SettingsGet.Results.find((row) => row.UU === saved.UU);
	expect(readBack?.BH_PayrollMonth).toBe(6);
	expect(readBack?.BH_PayrollYear).toBe(2026);

	await mutate(valueObject)({
		mutation: Bh_Payroll_SettingsDeleteDocument,
		variables: { UUs: [saved.UU] },
	});
});
