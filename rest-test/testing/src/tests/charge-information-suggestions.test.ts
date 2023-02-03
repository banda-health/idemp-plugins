import { chargeInformationSuggestionApi } from '../api';

test('all charge information suggestion sub types and data types to have a value type', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const chargeInformationSuggestions = (await chargeInformationSuggestionApi.get(valueObject)).results;
	chargeInformationSuggestions.forEach((chargeInformationSuggestion) => {
		expect(chargeInformationSuggestion.subType.value).toBeTruthy();
		expect(chargeInformationSuggestion.dataType.value).toBeTruthy();
	});
});
