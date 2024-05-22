import { query } from '../api';
import { Ad_MenuGetDocument, Bh_Voided_ReasonGetDocument } from '../__generated__/graphql';

test('correct voiding reasons are returned for visits', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'get visit window';
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: 'bb0670c5-0dc1-468a-8b85-a91b15407368' }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!;
	let visitMenu = menus.find((menu) => menu.Node?.Name === 'Visits/Bills');
	expect(visitMenu?.Node?.AD_Window?.UU).toBeTruthy();

	const voidingReasons = (
		await query(valueObject)({
			query: Bh_Voided_ReasonGetDocument,
			variables: {
				Filter: JSON.stringify({
					'ad_window::bh_window_id->ad_window_id.ad_window_uu': visitMenu?.Node?.AD_Window?.UU,
				}),
				Sort: JSON.stringify([['lineno', 'ASC']]),
			},
		})
	).data.BH_Voided_ReasonGet.Results;
	expect(voidingReasons).toHaveLength(7);
	expect(voidingReasons[0].Name).toBe('Wrong payment type or amount paid entered');
	expect(voidingReasons[1].Name).toBe('Prescribed drug is sold out');
	expect(voidingReasons[2].Name).toBe('Patient could not pay for the bill');
	expect(voidingReasons[3].Name).toBe('Duplicated transaction');
	expect(voidingReasons[4].Name).toBe('Add or Edit clinical information');
	expect(voidingReasons[5].Name).toBe('Service not offered');
	expect(voidingReasons[6].Name).toBe('Sample not produced');
});
