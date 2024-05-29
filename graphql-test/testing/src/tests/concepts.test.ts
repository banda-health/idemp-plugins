import { query } from '../api';
import { Bh_ConceptGetDocument } from '../__generated__/graphql';

test('get concepts fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await query(valueObject)({
            query: Bh_ConceptGetDocument
        })
	).data.BH_ConceptGet.Results;

	expect(concepts.length).not.toBe(0);

	const concept = concepts[0];
	expect(concept.BH_Display_Name).toBeTruthy();
	expect(concept.BH_Concept_Type).toBeTruthy();
	expect(concept.bh_concept_class).toBeTruthy();
});

test('the correct concepts are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await query(valueObject)({
            query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ BH_Display_Name: { $text: 'urine' } }) }
        })
	).data.BH_ConceptGet.Results;

	expect(concepts.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHLabs-concepts.json file
	expect(concepts.find((concept) => concept.BH_Display_Name === 'Urine microscopy panel')).toBeTruthy();
});
