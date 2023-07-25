import { menuApi } from '../api';
import { Menu } from '../types/org.bandahealth.idempiere.rest';

test('correct menu names are returned', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results;

	let menu: Menu | undefined;

	menu = menus.find((menu) => menu.name === 'Dashboard');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = menus.find((menu) => menu.name === 'Visits/Bills');
	expect(menu).not.toBeUndefined();
	menu = menus.find((menu) => menu.name === 'Patients');
	expect(menu).not.toBeUndefined();
	menu = menus.find((menu) => menu.name === 'Pharmacy Sales (OTC)');
	expect(menu).not.toBeUndefined();
	menu = menus.find((menu) => menu.name === 'Reports');
	expect(menu).not.toBeUndefined();

	const inventoryMenu = menus.find((menu) => menu.name === 'Inventory');
	expect(inventoryMenu).not.toBeUndefined();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Products & Prices');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Services & Prices');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Receive Products');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Manage Inventory');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Transfer Inventory');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = inventoryMenu?.subMenus.find((menu) => menu.name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();

	const accountingMenu = menus.find((menu) => menu.name === 'Accounting');
	expect(accountingMenu).not.toBeUndefined();
	menu = accountingMenu?.subMenus.find((menu) => menu.name === 'Debt Payments');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = accountingMenu?.subMenus.find((menu) => menu.name === 'Track Expenses');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = accountingMenu?.subMenus.find((menu) => menu.name === 'Non-Patient Payments');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = accountingMenu?.subMenus.find((menu) => menu.name === 'Expense Categories');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = accountingMenu?.subMenus.find((menu) => menu.name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	// expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Track Income')).not.toBeUndefined();
	// expect(accountingMenu?.subMenus.find((menu) => menu.name === 'Income Categories')).not.toBeUndefined();

	const backEndMenu = menus.find((menu) => menu.name === 'Back-End');
	expect(backEndMenu).not.toBeUndefined();
	menu = backEndMenu?.subMenus.find((menu) => menu.name === 'Diagnoses');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = backEndMenu?.subMenus.find((menu) => menu.name === 'Suppliers');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = backEndMenu?.subMenus.find((menu) => menu.name === 'Manage Users');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
	menu = backEndMenu?.subMenus.find((menu) => menu.name === 'Facility Information');
	expect(menu).not.toBeUndefined();
	expect(menu?.window?.uuid).toBeTruthy();
});
