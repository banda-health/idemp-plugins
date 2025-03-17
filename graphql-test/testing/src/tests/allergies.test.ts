import { v4 } from 'uuid';
import {
	Bh_Allergy_ReactionSaveDocument,
	Bh_AllergyDocument,
	Bh_AllergyGetDocument,
	Bh_AllergySaveDocument,
	Bh_ConceptGetDocument,
	C_BPartnerDocument,
} from '../../src/__generated__/graphql';
import { mutate, query } from '../../src/api';
import { createBusinessPartner } from '../../src/utils';

test('save and search allergies', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	const concept = (await query(valueObject)({ query: Bh_ConceptGetDocument, variables: { Size: 1 } })).data
		.BH_ConceptGet.Results[0];
	expect(concept).toBeTruthy();

	valueObject.stepName = 'Create allergy';
	const allergyUU = v4();
	await mutate(valueObject)({
		mutation: Bh_AllergySaveDocument,
		variables: {
			BH_Allergy: {
				BH_Allergy_Note: 'there was some sneezing',
				BH_Concept: { UU: concept.UU },
				BH_Uncoded_Allergen: 'achooing',
				C_BPartner: { UU: valueObject.businessPartner!.UU },
				Severity_Concept: { UU: concept.UU },
				UU: allergyUU,
			},
		},
	});
	await mutate(valueObject)({
		mutation: Bh_Allergy_ReactionSaveDocument,
		variables: {
			BH_Allergy_Reaction: {
				BH_Allergy: { UU: allergyUU },
				BH_Concept: { UU: concept.UU },
				BH_Uncoded_Allergy_Reaction: 'high fever',
			},
		},
	});

	const allergy = (await query(valueObject)({ query: Bh_AllergyDocument, variables: { UU: allergyUU } })).data
		.BH_Allergy!;
	expect(allergy).toBeTruthy();
	expect(allergy.BH_Allergy_Note).toBe('there was some sneezing');
	expect(allergy.BH_Concept?.UU).toBe(concept.UU);
	expect(allergy.BH_Uncoded_Allergen).toBe('achooing');
	expect(allergy.C_BPartner.UU).toBe(valueObject.businessPartner!.UU);
	expect(allergy.Severity_Concept?.UU).toBe(concept.UU);
	expect(allergy.BH_Allergy_Reactions?.[0].BH_Concept?.UU).toBe(concept.UU);
	expect(allergy.BH_Allergy_Reactions?.[0].BH_Uncoded_Allergy_Reaction).toBe('high fever');

	const searchedAllergy = (
		await query(valueObject)({
			query: Bh_AllergyGetDocument,
			variables: { Filter: JSON.stringify({ bh_allergy_uu: allergyUU }) },
		})
	).data.BH_AllergyGet.Results[0];
	expect(searchedAllergy.UU).toBe(allergyUU);

	const businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })
	).data.C_BPartner;
	expect(businessPartner?.BH_Allergies?.[0].UU).toBe(allergyUU);
});
