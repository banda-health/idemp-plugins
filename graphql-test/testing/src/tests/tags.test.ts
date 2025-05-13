import { Bh_TagDocument, Bh_TagSaveDocument } from '../__generated__/graphql';
import { mutate, query } from '../api';

test('colour codes are saved', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create tag 1';
	const tagUU = (
		await mutate(valueObject)({
			mutation: Bh_TagSaveDocument,
			variables: {
				Entity: {
					BH_ColourCode: '#aaaaa',
					Description: valueObject.getStepMessageLong(),
					IsActive: true,
					Name: valueObject.random + valueObject.getStepMessageLong(),
				},
			},
		})
	).data!.BH_TagSave.UU;
	expect(tagUU).toBeTruthy();

	const tag = (await query(valueObject)({ query: Bh_TagDocument, variables: { UU: tagUU } })).data.BH_Tag!;
	expect(tag).toBeTruthy();
	expect(tag.BH_ColourCode).toBe('#aaaaa');
});
