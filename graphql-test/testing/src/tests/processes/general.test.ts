import { sortBy } from 'lodash';
import { Ad_MenuGetDocument, Ad_ProcessGetDocument } from '../../__generated__/graphql';
import { query } from '../../api';
import { RoleName } from '../../types/roleName';

const reportsMenuRootUuid = '35ce7d6a-cf7d-4962-a748-75e27d0121bf';

const processUuid = {
	cashierPatientTransactions: 'b09d9a23-ad0f-4eff-a7c6-4c1e2309c3d1',
	cashierTransactionDifferences: '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2',
	createPriceList: '6008a4c3-6329-4aeb-bfbb-3316a42690c9',
	dailyCashierCollections: 'fb90406f-1ba4-43df-9cec-6844e10c13d9',
	deletedDraftedVisits: '592179c8-1974-4205-aeca-005233fdacd0',
	diagnosisReport: '7c29028a-8dd3-4025-a5af-87701748d81f',
	donorFundReport: '3478d341-c6d9-4f52-a865-5bf0ba8a7607',
	expenses: 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d',
	expiredProductsList: '808a1aaa-f38a-4a90-87dc-5ab2ebe2f7e6',
	incomeAndExpense: 'f777f042-3907-4293-94c4-49fe6eb58780',
	incomeStatement: '8ea6c947-4450-48dd-8bd0-76b0f307dcb0',
	inPatientReport: 'a1b2c3d4-e5f6-7890-abcd-ef1234567890',
	inventoryQuantityReport: '93d7c1bc-2885-43f4-985f-90f57a414e5f',
	inventorySoldReport: '1211e173-6f12-4e2f-bfcc-d43d48af51c3',
	moh705AOutpatientUnder5YearsSummary: 'c9f91d23-48ea-4990-af5d-f3e7f0db77de',
	moh705BOutpatientOver5YearsSummary: '432eeb61-1a87-4880-bded-91927139341c',
	moh706LaboratoryTestSummary: '83378587-d80f-4c79-874b-5cdc64893b77',
	moh717NewAndRevisitPatientCount: '742f515a-81c7-4690-8d35-2c6f1252ad5b',
	moh747FamilyPlanning: 'd5d7582e-8364-429c-a7e8-a11f2fcd3401',
	nonPatientPayments: '19464274-e2bc-4dbe-ad69-ae48b9f7778c',
	openBalanceList: 'b4f11e14-b9d8-4f6c-aa46-adfd77c4f773',
	openBalanceInvoice: '199f56a6-8e1f-47b4-8f22-e2bdb8da7505',
	otcSales: 'b8508f0a-c66f-4030-a88c-3ae383322ceb',
	patients: 'feaa97fb-b424-4dce-8790-035ba80ca023',
	patientTransactions: '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269',
	paymentTrail: 'a7ac9f65-45d7-4ae0-80f3-72019de35a4a',
	paymentReceipt: '173a691b-ba89-4987-9216-9b3f0a60c864',
	productsAndPrices: '3edf67b9-ee3d-4b73-a02e-deb1c1811db5',
	resetStock: '25239635-591f-4940-bfb4-46533068af7d',
	servicesChargedReport: '9e2e2707-7b3e-4b0b-aa93-3a1a64d523b2',
	servicesList: 'fd5b6538-760c-4c8f-b943-115c1f3d2287',
	stockDiscrepancyReport: '58ae2bdf-0e80-46f2-860f-2ae070fc82d2',
	stockToBeOrdered: '03ba009a-68bb-4b12-a5bc-e58a9bce1545',
	stockTransfers: '5a666f24-469a-43dc-865f-4053e0dd4fd6',
	valueOfOpeningAndClosingStock: '630fc1ab-0b64-459b-b10f-68549d21f507',
	visitInvoice: '477cdda4-82ff-4bac-834f-08de384df412',
	visitReceipt: '30dd7243-11c1-4584-af26-5d977d117c84',
	voidedTransactionsList: '20a623fb-e127-4c26-98d5-3604a6d100b2',
} as const;

const isActiveFilter = JSON.stringify({ isActive: 'Y' });

test('report names are correct', async () => {
	await globalThis.__VALUE_OBJECT__.login();

	const reportMenuList = sortBy(
		(
			await query(globalThis.__VALUE_OBJECT__)({
				query: Ad_MenuGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
			})
		).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList || [],
		'SeqNo',
	).flatMap((mainMenuTreeNode) => (mainMenuTreeNode.Node ? [mainMenuTreeNode.Node] : []));
	expect(reportMenuList).toBeTruthy();

	expect(reportMenuList[0].Name).toBe('Financial');
	expect(reportMenuList[0].Description).toBe(
		`Understand the clinic's financial position, revenue streams, and liabilities`,
	);
	expect(reportMenuList[1].Name).toBe('Clinical');
	expect(reportMenuList[1].Description).toBe('Monitor patient trends, clinical workload, and service delivery');
	expect(reportMenuList[2].Name).toBe(`Inventory`);
	expect(reportMenuList[2].Description).toBe(`Track stock, purchases, and resources`);

	const financialReports = sortBy(reportMenuList[0].ChildrenTree_NodeMMList || [], 'SeqNo').flatMap((node) =>
		node.Node ? [node.Node] : [],
	);
	expect(financialReports).toBeTruthy();
	expect(financialReports![0].Name).toBe('Patient Transactions');
	expect(financialReports![0].AD_Process?.UU).toBe(processUuid.patientTransactions);
	expect(financialReports![1].Name).toBe('Daily Cashier Collections');
	expect(financialReports![1].AD_Process?.UU).toBe(processUuid.dailyCashierCollections);
	expect(financialReports![2].Name).toBe('Cashier Patient Transactions');
	expect(financialReports![2].AD_Process?.UU).toBe(processUuid.cashierPatientTransactions);
	expect(financialReports![3].Name).toBe('Income/Expense Overview');
	expect(financialReports![3].AD_Process?.UU).toBe(processUuid.incomeAndExpense);
	expect(financialReports![4].Name).toBe('Services Charged Report');
	expect(financialReports![4].AD_Process?.UU).toBe(processUuid.servicesChargedReport);
	expect(financialReports![5].Name).toBe('Cashier Transaction Differences');
	expect(financialReports![5].AD_Process?.UU).toBe(processUuid.cashierTransactionDifferences);
	expect(financialReports![6].Name).toBe('Open Balance List');
	expect(financialReports![6].AD_Process?.UU).toBe(processUuid.openBalanceList);
	expect(financialReports![7].Name).toBe('Non Patient Payment Report');
	expect(financialReports![7].AD_Process?.UU).toBe(processUuid.nonPatientPayments);
	expect(financialReports![8].Name).toBe('Voided Transactions List');
	expect(financialReports![8].AD_Process?.UU).toBe(processUuid.voidedTransactionsList);
	expect(financialReports![9].Name).toBe('Donor Fund Report');
	expect(financialReports![9].AD_Process?.UU).toBe(processUuid.donorFundReport);
	expect(financialReports![10].Name).toBe('Over-the-Counter (OTC) Sales');
	expect(financialReports![10].AD_Process?.UU).toBe(processUuid.otcSales);
	expect(financialReports![11].Name).toBe('Expenses');
	expect(financialReports![11].AD_Process?.UU).toBe(processUuid.expenses);
	expect(financialReports![12].Name).toBe('Income Statement (Profit & Loss)');
	expect(financialReports![12].AD_Process?.UU).toBe(processUuid.incomeStatement);
	expect(financialReports![13].Name).toBe('Services List');
	expect(financialReports![13].AD_Process?.UU).toBe(processUuid.servicesList);
	expect(financialReports![14].Name).toBe('Deleted Drafted Bills Report');
	expect(financialReports![14].AD_Process?.UU).toBe(processUuid.deletedDraftedVisits);

	const clinicalReports = sortBy(reportMenuList[1].ChildrenTree_NodeMMList || [], 'SeqNo').flatMap((node) =>
		node.Node ? [node.Node] : [],
	);
	expect(clinicalReports).toBeTruthy();
	expect(clinicalReports![0].Name).toBe('MoH705A Out Patient Under 5yr Summary');
	expect(clinicalReports![0].AD_Process?.UU).toBe(processUuid.moh705AOutpatientUnder5YearsSummary);
	expect(clinicalReports![1].Name).toBe('MoH705B Out Patient Over 5yr Summary');
	expect(clinicalReports![1].AD_Process?.UU).toBe(processUuid.moh705BOutpatientOver5YearsSummary);
	expect(clinicalReports![2].Name).toBe('MoH717 New and Revisit Patient Count');
	expect(clinicalReports![2].AD_Process?.UU).toBe(processUuid.moh717NewAndRevisitPatientCount);
	expect(clinicalReports![3].Name).toBe('Diagnosis Report');
	expect(clinicalReports![3].AD_Process?.UU).toBe(processUuid.diagnosisReport);
	expect(clinicalReports![4].Name).toBe('MoH706 Laboratory Test Summary');
	expect(clinicalReports![4].AD_Process?.UU).toBe(processUuid.moh706LaboratoryTestSummary);
	expect(clinicalReports![5].Name).toBe('Patients Report');
	expect(clinicalReports![5].AD_Process?.UU).toBe(processUuid.patients);
	expect(clinicalReports![6].Name).toBe('MoH747A Facility Contraceptives Consumption Data Report');
	expect(clinicalReports![6].AD_Process?.UU).toBe(processUuid.moh747FamilyPlanning);
	expect(clinicalReports![7].Name).toBe('In-Patient Report');
	expect(clinicalReports![7].AD_Process?.UU).toBe(processUuid.inPatientReport);

	const inventoryReports = sortBy(reportMenuList[2].ChildrenTree_NodeMMList || [], 'SeqNo').flatMap((node) =>
		node.Node ? [node.Node] : [],
	);
	expect(inventoryReports).toBeTruthy();
	expect(inventoryReports![0].Name).toBe('Inventory Sold Report');
	expect(inventoryReports![0].AD_Process?.UU).toBe(processUuid.inventorySoldReport);
	expect(inventoryReports![1].Name).toBe('Inventory Quantity Report');
	expect(inventoryReports![1].AD_Process?.UU).toBe(processUuid.inventoryQuantityReport);
	expect(inventoryReports![2].Name).toBe('Changes to Inventory');
	expect(inventoryReports![2].AD_Process?.UU).toBe(processUuid.stockDiscrepancyReport);
	expect(inventoryReports![3].Name).toBe('Stock to be Ordered');
	expect(inventoryReports![3].AD_Process?.UU).toBe(processUuid.stockToBeOrdered);
	expect(inventoryReports![4].Name).toBe('Products and Prices');
	expect(inventoryReports![4].AD_Process?.UU).toBe(processUuid.productsAndPrices);
	expect(inventoryReports![5].Name).toBe('Value of Opening and Closing Stock');
	expect(inventoryReports![5].AD_Process?.UU).toBe(processUuid.valueOfOpeningAndClosingStock);
	expect(inventoryReports![6].Name).toBe('Expired Products List');
	expect(inventoryReports![6].AD_Process?.UU).toBe(processUuid.expiredProductsList);
	expect(inventoryReports![7].Name).toBe('Stock Transfers');
	expect(inventoryReports![7].AD_Process?.UU).toBe(processUuid.stockTransfers);

	expect(reportMenuList.find((menu) => menu.Name === 'Patient Visits and Referrals')).toBeUndefined();
});

test('certain reports are not returned as part of the menus', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuLists = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node!.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuLists).toBeTruthy();

	expect(reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitReceipt)).toBeUndefined();
	expect(
		reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.paymentReceipt),
	).toBeUndefined();
	expect(reportMenuLists.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.paymentTrail)).toBeUndefined();
});

test(`admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeDefined();
});

test(`clinic admin role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicAdmin);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeDefined();
});

test(`cashier/registration basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`cashier/registration basic plus role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasicPlus);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`cashier/registration advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeDefined();
});

test(`inventory/pharmacy advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`inventory/pharmacy basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`clinician/nurse basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`clinician/nurse advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`triage role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Triage);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`lab/radiology basic role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyBasic);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`lab/radiology advanced role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyAdvanced);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`accounting role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Accounting);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).not.toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`OTC only role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.OtcOnly);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});

test(`clinic user role has correct access`, async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicUser);
	const reportMenuList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: reportsMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0].ChildrenTree_NodeMMList!.flatMap((mainMenuTreeNode) =>
		mainMenuTreeNode.Node?.ChildrenTree_NodeMMList
			? mainMenuTreeNode.Node.ChildrenTree_NodeMMList.flatMap((node) => (node.Node ? [node.Node] : []))
			: [],
	);
	expect(reportMenuList).toBeTruthy();
	const processes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_ProcessGetDocument,
			variables: { Filter: isActiveFilter, Size: 1000 },
		})
	).data.AD_ProcessGet.Results;
	expect(processes).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patientTransactions)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.visitReceipt)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventorySoldReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventorySoldReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesChargedReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesChargedReport)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.productsAndPrices),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.productsAndPrices)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeAndExpense),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeAndExpense)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705AOutpatientUnder5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();
	expect(
		processes.find((process) => process.UU === processUuid.moh705BOutpatientOver5YearsSummary),
	).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh717NewAndRevisitPatientCount),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.moh717NewAndRevisitPatientCount)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.valueOfOpeningAndClosingStock),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.valueOfOpeningAndClosingStock)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockToBeOrdered),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockToBeOrdered)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockDiscrepancyReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockDiscrepancyReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.donorFundReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.donorFundReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.diagnosisReport),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.diagnosisReport)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentReceipt)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.paymentTrail)).not.toBeUndefined();

	expect(processes.find((process) => process.UU === processUuid.openBalanceInvoice)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.openBalanceList),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.openBalanceList)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierTransactionDifferences),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierTransactionDifferences)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.cashierPatientTransactions),
	).not.toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.cashierPatientTransactions)).not.toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.nonPatientPayments),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.nonPatientPayments)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.visitInvoice)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.visitInvoice)).toBeTruthy();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.createPriceList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.createPriceList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh706LaboratoryTestSummary),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh706LaboratoryTestSummary)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.patients)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.patients)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.otcSales)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.otcSales)).toBeDefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expenses)).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.expenses)).toBeDefined();

	expect(processes.find((process) => process.UU === processUuid.resetStock)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.dailyCashierCollections),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.dailyCashierCollections)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.expiredProductsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.expiredProductsList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inventoryQuantityReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inventoryQuantityReport)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.voidedTransactionsList),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.voidedTransactionsList)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.servicesList)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.servicesList)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.incomeStatement),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.incomeStatement)).toBeUndefined();

	expect(reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.stockTransfers)).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.stockTransfers)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.moh747FamilyPlanning),
	).toBeDefined();
	expect(processes.find((process) => process.UU === processUuid.moh747FamilyPlanning)).toBeDefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.deletedDraftedVisits),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.deletedDraftedVisits)).toBeUndefined();

	expect(
		reportMenuList.find((reportMenu) => reportMenu.AD_Process?.UU === processUuid.inPatientReport),
	).toBeUndefined();
	expect(processes.find((process) => process.UU === processUuid.inPatientReport)).toBeUndefined();
});
