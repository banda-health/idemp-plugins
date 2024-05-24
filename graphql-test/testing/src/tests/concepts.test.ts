import { query } from '../api';
import { Bh_ConceptGetDocument } from '../__generated__/graphql';

test('get concepts fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await query(valueObject)({
            query: Bh_ConceptGetDocument,
            variables: { Filter: JSON.stringify({ BH_Source: { $in: ['BHGO', 'BHLabs']}}) }
        })
	).data.BH_ConceptGet.Results;

	expect(concepts.length).not.toBe(0);

	const concept = concepts[0];
	expect(concept.BH_Display_Name).toBeTruthy();
	expect(concept.BH_Concept_Type).toBeTruthy();
	expect(concept.bh_concept_class).toBeTruthy();
});

test('the correct lab diagnositic concepts are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await query(valueObject)({
            query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ BH_Display_Name: { $text: 'urine' }, BH_Source: { $text: 'BHLabs' } }) }
        })
	).data.BH_ConceptGet.Results;

	expect(concepts.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHLabs-concepts.json file
	expect(concepts.find((concept) => concept.BH_Display_Name === 'Urine microscopy panel')).toBeTruthy();
});

test('get coded diagnosis fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const codedDiagnoses = (
		await query(valueObject)({
			query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ BH_Source: { $text: 'BHGO' } }) }
		})
	).data.BH_ConceptGet.Results;

	expect(codedDiagnoses.length).not.toBe(0);

	const codedDiagnosis = codedDiagnoses[0];
	expect(codedDiagnosis.BH_Display_Name).toBeTruthy();

	const conceptExtras = codedDiagnosis.BH_Concept_Extras;

	expect(conceptExtras.filter((extra) => extra.BH_Key === 'index_terms')).toBeTruthy();
	expect(conceptExtras.filter((extra) => extra.BH_Key === 'MOH-705A-LESSTHAN5')).toBeTruthy();
	expect(conceptExtras.filter((extra) => extra.BH_Key === 'MOH-705B-GREATERTHAN5')).toBeTruthy();
});

test('the correct diagnoses are returned', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	
	const codedDiagnoses = (
		await query(valueObject)({
			query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ BH_Display_Name: { $text: 'anemia' }, BH_Source: { $text: 'BHGO' } }) }
		})
	).data.BH_ConceptGet.Results;

	expect(codedDiagnoses.length).not.toBe(0);
	// This comes from the external-mocks/files/ocl/BHGO-concepts.json file
	expect(codedDiagnoses.filter((codedDiagnosis) => codedDiagnosis.BH_Display_Name === 'Anemia, iron deficiency')).toBeTruthy();
});

