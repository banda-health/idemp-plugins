import { conceptApi } from '../api';

test('get concepts fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await conceptApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			undefined,
		)
	).results;

	expect(concepts.length).not.toBe(0);

	const concept = concepts[0];
	expect(concept.displayName).toBeTruthy();
	expect(concept.conceptType).toBeTruthy();
	expect(concept.conceptClass).toBeTruthy();
});

test('the correct concepts are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await conceptApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ bh_display_name: { $text: 'urine' } }),
		)
	).results;

	expect(concepts.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHLabs-concepts.json file
	expect(concepts.find((concept) => concept.displayName === 'Urine microscopy panel')).toBeTruthy();
});

test('get coded diagnosis fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
			await conceptApi.get(
					valueObject,
					undefined,
					undefined,
					undefined,
					JSON.stringify({ bh_searchterms: { $nnull: true } }),
			)
	).results;

	expect(codedDiagnoses.length).not.toBe(0);

	const codedDiagnosis = codedDiagnoses[0];
	expect(codedDiagnosis.displayName).toBeTruthy();

	const conceptExtras = codedDiagnosis.conceptExtras;

	expect(conceptExtras.filter((extra) => extra.key === 'index_terms')).toBeTruthy();
	expect(conceptExtras.filter((extra) => extra.key === 'MOH-705A-LESSTHAN5')).toBeTruthy();
	expect(conceptExtras.filter((extra) => extra.key === 'MOH-705B-GREATERTHAN5')).toBeTruthy();
});

test('the correct diagnoses are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
			await conceptApi.get(
					valueObject,
					undefined,
					undefined,
					undefined,
					JSON.stringify({ name: { $text: 'anemia' } }),
			)
	).results;

	expect(codedDiagnoses.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHGO-concepts.json file
	expect(codedDiagnoses.filter((codedDiagnosis) => codedDiagnosis.displayName === 'Anemia, iron deficiency')).toBeTruthy();
});

