import { query } from '../../api';
import { RoleName } from '../../types/roleName';
import { Ad_MenuGetDocument, Ad_ProcessGetDocument } from '../../__generated__/graphql';

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

	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();

	expect(reportMenuList.find((menu) => menu.Name === 'Expired Products List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Daily Cashier Collections')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Inventory Quantity Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Voided Transactions List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Open Balance List')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Cashier Transaction Differences')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Cashier Patient Transactions')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Services Charged Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Diagnosis Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Changes to Inventory')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Inventory Sold Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'MoH705B Out Patient Over 5yr Summary')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'MoH717 New and Revisit Patient Count')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'MoH705A Out Patient Under 5yr Summary')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Patient Visits and Referrals')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Patient Transactions')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Value of Opening and Closing Stock ')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Donor Fund Report')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Products and Prices')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Income & Expenses')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Stock to be Ordered')).toBeTruthy();
	expect(reportMenuList.find((menu) => menu.Name === 'Non Patient Payment Report')).toBeTruthy();
});

test('certain reports are not returned as part of the menus', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuLists).toBeTruthy();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.visitReceipt),
	).toBeUndefined();
	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.paymentReceipt),
	).toBeUndefined();
	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.paymentTrail),
	).toBeUndefined();
});

test(`admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuLists).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuLists.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuLists.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`clinic admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicAdmin);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`cashier/registration basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`cashier/registration advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`inventory/pharmacy role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`clinician/nurse basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`clinician/nurse advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`triage role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Triage);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`lab/radiology role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiology);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});

test(`accounting role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Accounting);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).not.toBeUndefined();
});

test(`clinic user role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicUser);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.results[0].ChildrenTree_NodeMMList!.map((mainMenuTreeNode) => mainMenuTreeNode.Node!);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { filter: isActiveFilter },
		})
	).data.AD_ProcessGet.results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find(
			(reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705AOutpatientUnder5YearsSummary,
		),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UUID === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UUID === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UUID === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UUID === processUuid.nonPatientPayments)).toBeUndefined();
});
