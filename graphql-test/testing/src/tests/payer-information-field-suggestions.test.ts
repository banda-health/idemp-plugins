import { query } from '../api';
import { Bh_Payer_Info_Fld_SugGetDocument } from '../__generated__/graphql';

test('all payer information field suggestion sub types and data types to have a value type', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const payerInformationFieldSuggestions = (await query(valueObject)({ query: Bh_Payer_Info_Fld_SugGetDocument })).data
		.BH_Payer_Info_Fld_SugGet.Results;
	payerInformationFieldSuggestions.forEach((payerInformationFieldSuggestion) => {
		expect(payerInformationFieldSuggestion.BH_SubType.Value).toBeTruthy();
		expect(payerInformationFieldSuggestion.BH_PayerInfoFieldDataType.Value).toBeTruthy();
	});
});
