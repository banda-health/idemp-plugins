import { mutate, query } from '../api';
import {
	Bh_Client_Concept_ExtraDeleteDocument,
	Bh_Client_Concept_ExtraSaveDocument,
	Bh_Concept_ExtraSaveDocument,
	Bh_ConceptGetDocument,
	Bh_ConceptSaveDocument,
} from '../__generated__/graphql';
import { v4 } from 'uuid';

test('can save and delete client concept extras', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create concept';
	const conceptUU = v4();
	await mutate(valueObject)({
		mutation: Bh_ConceptSaveDocument,
		variables: { BH_Concept: { BH_Display_Name: valueObject.getDynamicStepMessage(), UU: conceptUU } },
	});

	valueObject.stepName = 'Create concept extra';
	const conceptExtraUU = v4();
	await mutate(valueObject)({
		mutation: Bh_Concept_ExtraSaveDocument,
		variables: {
			BH_Concept_Extra: {
				BH_Concept: { UU: conceptUU },
				BH_Key: 'local_name',
				BH_Value: 'kersplam',
				UU: conceptExtraUU,
			},
		},
	});

	valueObject.stepName = 'Create client concept extra';
	await mutate(valueObject)({
		mutation: Bh_Client_Concept_ExtraSaveDocument,
		variables: {
			BH_Client_Concept_Extra: {
				BH_Concept_Extra: { UU: conceptExtraUU },
				BH_Value: 'kersplam 2',
			},
		},
	});

	let concept = (
		await query(valueObject)({
			query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ bh_concept_uu: conceptUU }) },
		})
	).data.BH_ConceptGet.Results[0]!;

	expect(concept).toBeTruthy();
	expect(concept.BH_Concept_Extras?.length).toBe(1);
	expect(concept.BH_Concept_Extras![0].BH_Client_Concept_Extras?.length).toBe(1);
	expect(concept.BH_Concept_Extras![0].BH_Client_Concept_Extras![0].BH_Value).toBe('kersplam 2');

	await mutate(valueObject)({
		mutation: Bh_Client_Concept_ExtraDeleteDocument,
		variables: { UUs: [concept.BH_Concept_Extras![0].BH_Client_Concept_Extras![0].UU] },
	});
	concept = (
		await query(valueObject)({
			query: Bh_ConceptGetDocument,
			variables: { Filter: JSON.stringify({ bh_concept_uu: conceptUU }) },
		})
	).data.BH_ConceptGet.Results[0]!;

	expect(concept).toBeTruthy();
	expect(concept.BH_Concept_Extras?.length).toBe(1);
	expect(concept.BH_Concept_Extras![0].BH_Client_Concept_Extras).toBeNull();
});
