import { query } from '../api';
import { Bh_Coded_DiagnosisGetDocument } from '../__generated__/graphql';

test('get coded diagnosis fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
		await query(valueObject)({
			query: Bh_Coded_DiagnosisGetDocument,
			variables: { Filter: JSON.stringify({ bh_searchterms: { $nnull: true } }) },
		})
	).data.BH_Coded_DiagnosisGet.Results;

	expect(codedDiagnoses.length).not.toBe(0);

	const codedDiagnosis = codedDiagnoses[0];
	expect(codedDiagnosis.bh_cielname).toBeTruthy();
	expect(codedDiagnosis.bh_searchterms).toBeTruthy();
	expect(codedDiagnosis.bh_icd10who).toBeTruthy();
});

test('the correct diagnoses are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
		await query(valueObject)({
			query: Bh_Coded_DiagnosisGetDocument,
			variables: { Filter: JSON.stringify({ name: { $text: 'anemia' } }) },
		})
	).data.BH_Coded_DiagnosisGet.Results;

	expect(codedDiagnoses.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHGO-concepts.json file
	expect(
		codedDiagnoses.find((codedDiagnosis) => codedDiagnosis.bh_cielname === 'Anemia, iron deficiency'),
	).toBeTruthy();
});
