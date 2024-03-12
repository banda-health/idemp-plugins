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
			JSON.stringify({ displayName: { $text: 'anemia' } }),
		)
	).results;

	expect(concepts.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHGO-concepts.json file
	expect(concepts.find((concept) => concept.displayName === 'Anemia, iron deficiency')).toBeTruthy();
});
