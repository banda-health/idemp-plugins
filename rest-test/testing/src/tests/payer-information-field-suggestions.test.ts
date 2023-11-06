import { payerInformationFieldSuggestionApi } from '../api';

test('all payer information field suggestion sub types and data types to have a value type', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const payerInformationFieldSuggestions = (await payerInformationFieldSuggestionApi.get(valueObject)).results;
	payerInformationFieldSuggestions.forEach((payerInformationFieldSuggestion) => {
		expect(payerInformationFieldSuggestion.subType.value).toBeTruthy();
		expect(payerInformationFieldSuggestion.dataType.value).toBeTruthy();
	});
});
