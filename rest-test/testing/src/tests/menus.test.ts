import { menuApi } from '../api';

test('correct menu names are returned', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results;

	expect(menus.find((menu) => menu.name === 'Dashboard')).not.toBeUndefined();
	expect(menus.find((menu) => menu.name === 'Visits/Bills')).not.toBeUndefined();
	expect(menus.find((menu) => menu.name === 'Patients')).not.toBeUndefined();
	expect(menus.find((menu) => menu.name === 'Pharmacy Sales (OTC)')).not.toBeUndefined();
	expect(menus.find((menu) => menu.name === 'Reports')).not.toBeUndefined();

	const inventoryMenu = menus.find((menu) => menu.name === 'Inventory');
	expect(inventoryMenu).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Products & Prices')).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Services & Prices')).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Receive Products')).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Manage Inventory')).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Transfer Inventory')).not.toBeUndefined();
	expect(inventoryMenu?.subMenus.find((menu) => menu.name === 'Suppliers')).not.toBeUndefined();

	const accountingMenu = menus.find((menu) => menu.name === 'Accounting');
	expect(accountingMenu).not.toBeUndefined();
	expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Debt Payments')).not.toBeUndefined();
	expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Track Expenses')).not.toBeUndefined();
	expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Non-Patient Payments')).not.toBeUndefined();
	expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Expense Categories')).not.toBeUndefined();
	expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Suppliers')).not.toBeUndefined();
	// expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Track Income')).not.toBeUndefined();
	// expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Income Categories')).not.toBeUndefined();

	const backEndMenu = menus.find((menu) => menu.name === 'Back-End');
	expect(backEndMenu).not.toBeUndefined();
	expect(backEndMenu?.subMenus.find((menu) => menu.name === 'Diagnoses')).not.toBeUndefined();
	expect(backEndMenu?.subMenus.find((menu) => menu.name === 'Suppliers')).not.toBeUndefined();
	expect(backEndMenu?.subMenus.find((menu) => menu.name === 'Manage Users')).not.toBeUndefined();
	expect(backEndMenu?.subMenus.find((menu) => menu.name === 'Facility Information')).not.toBeUndefined();
});
