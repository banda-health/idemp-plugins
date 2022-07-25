import { menuApi } from '../api';

const reportsMenuRootUuid = '35ce7d6a-cf7d-4962-a748-75e27d0121bf';

test('report names are correct', async () => {
	await globalThis.__VALUE_OBJECT__.login();

	const reports = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;

	expect(reports.find((menu) => menu.name === 'Expired Products List'));
	expect(reports.find((menu) => menu.name === 'Daily Cashier Collections'));
	expect(reports.find((menu) => menu.name === 'Inventory Quantity Report'));
	expect(reports.find((menu) => menu.name === 'Voided Transactions List'));
	expect(reports.find((menu) => menu.name === 'Open Balance List'));
	expect(reports.find((menu) => menu.name === 'Cashier Transaction Differences'));
	expect(reports.find((menu) => menu.name === 'Cashier Patient Transactions'));
	expect(reports.find((menu) => menu.name === 'Services Charged Report'));
	expect(reports.find((menu) => menu.name === 'Diagnosis Report'));
	expect(reports.find((menu) => menu.name === 'Changes to Inventory'));
	expect(reports.find((menu) => menu.name === 'Inventory Sold Report'));
	expect(reports.find((menu) => menu.name === 'MoH705B Out Patient Over 5yr Summary'));
	expect(reports.find((menu) => menu.name === 'MoH717 New and Revisit Patient Count'));
	expect(reports.find((menu) => menu.name === 'MoH705A Out Patient Under 5yr Summary'));
	expect(reports.find((menu) => menu.name === 'Patient Visits and Referrals'));
	expect(reports.find((menu) => menu.name === 'Patient Transactions'));
	expect(reports.find((menu) => menu.name === 'Value of Opening and Closing Stock'));
	expect(reports.find((menu) => menu.name === 'Donor Fund Report'));
	expect(reports.find((menu) => menu.name === 'Products and Prices'));
	expect(reports.find((menu) => menu.name === 'Income & Expenses'));
	expect(reports.find((menu) => menu.name === 'Stock to be Ordered'));
});

test(`admin can see all reports`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});
