// import { codedDiagnosisApi } from '../api';

// test('get coded diagnosis fields', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	const codedDiagnoses = (
// 		await codedDiagnosisApi.get(
// 			valueObject,
// 			undefined,
// 			undefined,
// 			undefined,
// 			JSON.stringify({ bh_searchterms: { $nnull: true } }),
// 		)
// 	).results;

// 	expect(codedDiagnoses.length).not.toBe(0);

// 	const codedDiagnosis = codedDiagnoses[0];
// 	expect(codedDiagnosis.cielName).toBeTruthy();
// 	expect(codedDiagnosis.searchTerms).toBeTruthy();
// 	expect(codedDiagnosis.icd10).toBeTruthy();
// });

// test('the correct diagnoses are returned', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	const codedDiagnoses = (
// 		await codedDiagnosisApi.get(
// 			valueObject,
// 			undefined,
// 			undefined,
// 			undefined,
// 			JSON.stringify({ name: { $text: 'anemia' } }),
// 		)
// 	).results;

// 	expect(codedDiagnoses.length).not.toBe(0);
// 	// This comes from the external-mocks/files/ocl/BHGO-concepts.json file
// 	expect(codedDiagnoses.find((codedDiagnosis) => codedDiagnosis.cielName === 'Anemia, iron deficiency')).toBeTruthy();
// });

export {};
