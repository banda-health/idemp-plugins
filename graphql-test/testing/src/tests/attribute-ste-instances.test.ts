import { mutate, query } from '../api';
import { getDateOffset } from '../utils';
import {
	M_AttributeSetGetDocument,
	M_AttributeSetInstanceGetDocument,
	M_AttributeSetInstanceSaveDocument,
} from '../__generated__/graphql';

test('guarantee dates can be updated', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const expiringAttributeSet = (
		await query(valueObject)({
			query: M_AttributeSetGetDocument,
			variables: { Filter: JSON.stringify({ isguaranteedate: true }) },
		})
	).data.M_AttributeSetGet.Results[0];

	valueObject.stepName = 'Create expiring attribute set instance';
	const expiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: { GuaranteeDate: new Date().getTime(), M_AttributeSet: { UU: expiringAttributeSet.UU } },
			},
		})
	).data!.M_AttributeSetInstanceSave!;
	expect(expiringAttributeSetInstance).toBeTruthy();

	valueObject.stepName = 'Update the guarantee date';
	valueObject.date = new Date(
		(
			await query(valueObject)({
				query: M_AttributeSetInstanceGetDocument,
				variables: { Filter: JSON.stringify({ m_attributesetinstance_uu: expiringAttributeSetInstance.UU }) },
			})
		).data.M_AttributeSetInstanceGet.Results[0].GuaranteeDate!,
	);
	const newDate = getDateOffset(valueObject.date, 30).getTime();
	await mutate(valueObject)({
		mutation: M_AttributeSetInstanceSaveDocument,
		variables: {
			Entity: { UU: expiringAttributeSetInstance.UU, GuaranteeDate: newDate },
		},
	});
	expect(
		(
			await query(valueObject)({
				query: M_AttributeSetInstanceGetDocument,
				variables: { Filter: JSON.stringify({ m_attributesetinstance_uu: expiringAttributeSetInstance.UU }) },
			})
		).data.M_AttributeSetInstanceGet.Results[0].GuaranteeDate,
	).toBe(newDate);
});
