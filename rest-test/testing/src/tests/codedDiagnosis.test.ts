import { codedDiagnosisApi } from '../api';
import { Service } from '../types/org.bandahealth.idempiere.rest';

test('get coded diagnosis fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
		await codedDiagnosisApi.get(valueObject, undefined, undefined, undefined, 
			JSON.stringify({ 'bh_searchterms': { '$nnull': true } }))
	).results;
	
	expect(codedDiagnoses.length).not.toBe(0);
	
	const codedDiagnosis = codedDiagnoses[0];
	expect(codedDiagnosis.cielName).toBeTruthy();
	expect(codedDiagnosis.searchTerms).toBeTruthy();
	expect(codedDiagnosis.icd10).toBeTruthy();
});
