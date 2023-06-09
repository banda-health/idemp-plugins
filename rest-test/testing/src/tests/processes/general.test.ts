import { menuApi, processApi } from '../../api';
import { RoleName } from '../../types/roleName';

const reportsMenuRootUuid = '35ce7d6a-cf7d-4962-a748-75e27d0121bf';

const processUuid = {
	cashierPatientTransactions: 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1',
	cashierTransactionDifferences: '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2',
	diagnosisReport: '7c29028a-8dd3-4025-a5af-87701748d81f',
	donorFundReport: '3478d341-c6d9-4f52-a865-5bf0ba8a7607',
	incomeAndExpense: 'f777f042-3907-4293-94c4-49fe6eb58780',
	inventorySoldReport: '1211e173-6f12-4e2f-bfcc-d43d48af51c3',
	moh705AOutpatientUnder5YearsSummary: 'c9f91d23-48ea-4990-af5d-f3e7f0db77de',
	moh705BOutpatientOver5YearsSummary: '432eeb61-1a87-4880-bded-91927139341c',
	moh717NewAndRevisitPatientCount: '742f515a-81c7-4690-8d35-2c6f1252ad5b',
	nonPatientPayments: '19464274-e2bc-4dbe-ad69-ae48b9f7778c',
	openBalanceList: 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773',
	openBalanceInvoice: '199f56a6-8e1f-47b4-8f22-e2bdb8da7505',
	patientTransactions: '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269',
	paymentTrail: 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a',
	paymentReceipt: '173a691b-ba89-4987-9216-9b3f0a60c864',
	productsAndPrices: '3edf67b9-ee3d-4b73-a02e-deb1c1811db5',
	servicesChargedReport: '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2',
	stockDiscrepancyReport: '58ae2bdf-0e80-46f2-860f-2ae070fc82d2',
	stockToBeOrdered: '03ba009a-68bb-4b12-a5bc-e58a9bce1545',
	valueOfOpeningAndClosingStock: '630fc1ab-0b64-459b-b10f-68549d21f507',
	visitReceipt: '30dd7243-11c1-4584-af26-5d977d117c84',
} as const;

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
	expect(reportMenuList.find((menu) => menu.name === 'Non Patient Payment Report')).toBeTruthy();
});

test('certain reports are not returned as part of the menus', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;

	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.visitReceipt)).toBeUndefined();
	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.paymentReceipt)).toBeUndefined();
	expect(reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.paymentTrail)).toBeUndefined();
});

test(`admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`clinic admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicAdmin);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`cashier/registration basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasic);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`cashier/registration advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationAdvanced);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`inventory/pharmacy role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacy);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`clinician/nurse basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseBasic);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`clinician/nurse advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseAdvanced);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`triage role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Triage);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`lab/radiology role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiology);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`accounting role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Accounting);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`clinic user role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicUser);
	const reportMenuList = (await menuApi.getByRootId(globalThis.__VALUE_OBJECT__, reportsMenuRootUuid)).results;
	const processes = (await processApi.get(globalThis.__VALUE_OBJECT__, undefined, undefined, undefined, isActiveFilter))
		.results;

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.uuid === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.donorFundReport)).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.uuid === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.process?.uuid === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.uuid === processUuid.nonPatientPayments)).toBeUndefined();
});
