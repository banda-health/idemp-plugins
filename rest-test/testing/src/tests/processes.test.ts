import { PdfData } from 'pdfdataextract';
import { menuApi, processApi } from '../api';
import { ProcessInfoParameter } from '../types/org.bandahealth.idempiere.rest';
import { runReport, tomorrow, yesterday } from '../utils';

const reportsMenuRootUuid = '35ce7d6a-cf7d-4962-a748-75e27d0121bf';

const reportUuid = {
	cashierPatientTransactions: 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1',
	cashierTransactionDifferences: '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2',
	dailyCashierCollections: 'fb90406f-1ba4-43df-9cec-6844e10c13d9',
	diagnosisReport: '7c29028a-8dd3-4025-a5af-87701748d81f',
	donorFundReport: '3478d341-c6d9-4f52-a865-5bf0ba8a7607',
	expiredProductsList: '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6',
	incomeAndExpense: 'f777f042-3907-4293-94c4-49fe6eb58780',
	inventoryQuantityReport: '93d7c1bc-2885-43f4-985f-90f57a414e5f',
	inventorySoldReport: '1211e173-6f12-4e2f-bfcc-d43d48af51c3',
	moh705AOutpatientUnder5YearsSummary: 'c9f91d23-48ea-4990-af5d-f3e7f0db77de',
	moh705BOutpatientOver5YearsSummary: '432eeb61-1a87-4880-bded-91927139341c',
	moh717NewAndRevisitPatientCount: '742f515a-81c7-4690-8d35-2c6f1252ad5b',
	openBalanceList: 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773',
	patientTransactions: '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269',
	patientVisitsAndReferrals: '061ed4a0-5670-4764-909e-fb4592f51aaa',
	paymentTrail: 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a',
	paymentReceipt: '173a691b-ba89-4987-9216-9b3f0a60c864',
	productsAndPrices: '3edf67b9-ee3d-4b73-a02e-deb1c1811db5',
	servicesChargedReport: '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2',
	stockDiscrepancyReport: '58ae2bdf-0e80-46f2-860f-2ae070fc82d2',
	stockToBeOrdered: '03ba009a-68bb-4b12-a5bc-e58a9bce1545',
	valueOfOpeningAndClosingStock: '630fc1ab-0b64-459b-b10f-68549d21f507',
	visitReceipt: '30dd7243-11c1-4584-af26-5d977d117c84',
	voidedTransactionsList: '20a623fb-e127-4c26-98d5-3604a6d100b2',
} as const;

const processUuid = { cleanInventory: 'e79541fb-9b70-4a10-bfef-7401401b8c56' } as const;

const isActiveFilter = JSON.stringify({ isActive: 'Y' });

test('report names are correct', async () => {
	await globalThis.__VALUE_OBJECT__.login();

	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;

	expect(reportMenuList.find((menu) => menu.name === 'Expired Products List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Daily Cashier Collections')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Inventory Quantity Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Voided Transactions List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Open Balance List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Cashier Transaction Differences')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Cashier Patient Transactions')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Services Charged Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Diagnosis Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Changes to Inventory')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Inventory Sold Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'MoH705B Out Patient Over 5yr Summary')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'MoH717 New and Revisit Patient Count')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'MoH705A Out Patient Under 5yr Summary')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Patient Visits and Referrals')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Patient Transactions')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Value of Opening and Closing Stock ')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Donor Fund Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Products and Prices')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Income & Expenses')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.name === 'Stock to be Ordered')).toBeTruthy();
});

test('certain reports are not returned as part of the menus', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;

	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.visitReceipt)).toBeUndefined();
	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.paymentReceipt)).toBeUndefined();
	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.paymentTrail)).toBeUndefined();
});

test(`admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test(`clinic admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic Admin');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test(`cashier/registration basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Basic');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test(`cashier/registration advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Advanced');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test(`inventory/pharmacy role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Inventory/Pharmacy');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).toBeUndefined();
});

test(`clinician/nurse basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Basic');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).toBeUndefined();
});

test(`clinician/nurse advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Advanced');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).toBeUndefined();
});

test(`triage role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Triage');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).toBeUndefined();
});

test(`lab/radiology role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Lab/Radiology');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).toBeUndefined();
});

test(`accounting role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Accounting');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test(`clinic user role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic User');
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const reports = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.patientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.patientTransactions)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.productsAndPrices)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.incomeAndExpense)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705AOutpatientUnder5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh705BOutpatientOver5YearsSummary)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.donorFundReport)).toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.diagnosisReport)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentReceipt)).not.toBeUndefined();

	expect(reports.find((report) => report.uuid === reportUuid.paymentTrail)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.openBalanceList),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === reportUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(reports.find((report) => report.uuid === reportUuid.cashierPatientTransactions)).not.toBeUndefined();
});

test('processes can be run without any parameters', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Run process';
	valueObject.processUuid = processUuid.cleanInventory;
	valueObject.processInformationParameters = undefined;
	await expect(processApi.run(valueObject)).resolves.toBe('');
});

test('donor fund report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await processApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ ad_process_uu: reportUuid.donorFundReport }),
		)
	).results[0];
	const beginDateParameter = process.parameters.find((parameter) => parameter.name === 'Begin Date');
	const endDateParameter = process.parameters.find((parameter) => parameter.name === 'End Date');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = reportUuid.donorFundReport;
	valueObject.processInformationParameters = [
		{ processParameterUuid: beginDateParameter!.uuid, parameter: yesterday().toISOString() } as ProcessInfoParameter,
		{ processParameterUuid: endDateParameter!.uuid, parameter: tomorrow().toISOString() } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
