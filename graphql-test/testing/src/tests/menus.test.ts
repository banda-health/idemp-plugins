import { query } from '../api';
import { Ad_MenuGetDocument } from '../__generated__/graphql';

const mainMenuRootUuid = 'bb0670c5-0dc1-468a-8b85-a91b15407368';

test('correct menu names are returned', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!;
	expect(menus).toBeTruthy();

	let menu:
		| NonNullable<typeof menus>[0]
		| NonNullable<NonNullable<NonNullable<typeof menus>[0]['Node']>['ChildrenTree_NodeMMList']>[0]
		| undefined;

	menu = menus.find((menu) => menu.Node?.Name === 'Dashboard');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(1);
	menu = menus.find((menu) => menu.Node?.Name === 'Visits/Bills');
	expect(menu).not.toBeUndefined();
	expect(menu?.SeqNo).toBe(2);
	menu = menus.find((menu) => menu.Node?.Name === 'Patients');
	expect(menu).not.toBeUndefined();
	expect(menu?.SeqNo).toBe(4);
	menu = menus.find((menu) => menu.Node?.Name === 'Pharmacy Sales (OTC)');
	expect(menu).not.toBeUndefined();
	expect(menu?.SeqNo).toBe(3);
	menu = menus.find((menu) => menu.Node?.Name === 'Reports');
	expect(menu).not.toBeUndefined();
	expect(menu?.SeqNo).toBe(8);

	const inventoryMenu = menus.find((menu) => menu.Node?.Name === 'Inventory');
	expect(inventoryMenu).not.toBeUndefined();
	expect(inventoryMenu?.SeqNo).toBe(5);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Products & Prices');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(0);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Services & Prices');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(1);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Receive Products');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(2);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Manage Inventory');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(3);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Transfer Inventory');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(4);
	menu = inventoryMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(5);

	const accountingMenu = menus.find((menu) => menu.Node?.Name === 'Accounting');
	expect(accountingMenu).not.toBeUndefined();
	expect(accountingMenu?.SeqNo).toBe(6);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Debt Payments');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(0);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Track Expenses');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(1);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Track Income');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(3);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Donors & Insurers');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(2);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Expense Categories');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(4);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(5);
	menu = accountingMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Price Lists');
	expect(menu).toBeDefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(6);

	const backEndMenu = menus.find((menu) => menu.Node?.Name === 'Back-End');
	expect(backEndMenu).not.toBeUndefined();
	expect(backEndMenu?.SeqNo).toBe(7);
	menu = backEndMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Diagnoses');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(0);
	menu = backEndMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(1);
	menu = backEndMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Manage Users');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(3);
	menu = backEndMenu?.Node?.ChildrenTree_NodeMMList?.find((menu) => menu.Node?.Name === 'Facility Information');
	expect(menu).not.toBeUndefined();
	expect(menu?.Node?.AD_Window?.UU).toBeTruthy();
	expect(menu?.SeqNo).toBe(2);
});
