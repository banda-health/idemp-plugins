import { menuApi, referenceListApi } from '../api';
import { documentAction, documentBaseType, documentStatus } from '../models';

const windowUuid = {
	clinicalDetails: '2e37e97b-aeb5-47d7-add3-0d602233c2aa',
	dashboard: 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b',
	debtPayments: '4497b5f7-758d-4e82-8e2b-01c4364ce609',
	diagnoses: '1f29f7ab-bc9a-427c-b35b-87589e4612b5',
	expenseCategories: '5731bc45-3b78-475a-a347-4ca899f19e32',
	facilityInformation: '66df8b28-5a44-40a0-b63e-d51695bdfc92',
	incomeCategories: '20639eca-bd84-4ae3-b890-7b32987fcb5e',
	manageInventory: '8f744d1c-427a-4b85-ab98-38e50258e86d',
	manageUsers: '6b934ec2-7f45-4104-ba10-08e3ce54de7e',
	nonPatientPayments: 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d',
	patients: 'ba697729-5ec8-44f7-b534-446310bb5782',
	products: 'c63b9972-1b23-4140-8bbb-0ea2b0b81024',
	receiveProducts: '78dd6f39-84f9-4e19-b08e-7a3441af15e5',
	suppliers: '565af89e-8f10-4469-84f5-6cca8d7fae27',
	services: 'fd93da00-871d-4996-a3f7-4528bed8b758',
	trackExpenses: '37df7931-7d07-4812-b9d4-dec7a53bb70f',
	trackIncome: '44c02ddc-ef83-4020-8e4c-709d8cbeadc2',
	transferInventory: 'd3c84cad-7306-464d-85da-7e629846f8c0',
	visitsBills: 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77',
	vitals: '53b4d743-c311-40e5-aa8e-c0880c42c1b1',
	otcPharmacySales: '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f',
} as const;

test('admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toMatchObject({ canWrite: true, canDeactivate: true });

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: true });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: true });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toMatchObject({ canWrite: true, canDeactivate: true });
});

test('clinic admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic Admin');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toMatchObject({ canWrite: false, canDeactivate: false });

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: true });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: true });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toMatchObject({ canWrite: true, canDeactivate: true });
});

test('cashier/registration basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Basic');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: false });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: false });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('cashier/registration advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Advanced');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: false });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: false });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('inventory/pharmacy role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Inventory/Pharmacy');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: false });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('clinician/nurse basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Basic');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('clinician/nurse advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Advanced');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('triage role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Triage');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('lab/radiology role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Lab/Radiology');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toBeUndefined();

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: false });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('accounting role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Accounting');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: false, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: false, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: false, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: false, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toMatchObject({ canWrite: true, canDeactivate: false });

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: true });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ canWrite: true, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});

test('clinic user role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic User');
	const windowAccess = globalThis.__VALUE_OBJECT__.windowAccess;
	const menus = (await menuApi.get(globalThis.__VALUE_OBJECT__)).results.flatMap((menu) => [menu, ...menu.subMenus]);
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ canWrite: true, canDeactivate: true });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ canWrite: false, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.debtPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ canWrite: true, canDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.incomeCategories)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.incomeCategories]).toMatchObject({ canWrite: false, canDeactivate: false });

	// expect(menus.find((menu) => menu.window?.uuid === windowUuid.trackIncome)).not.toBeUndefined();
	// expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ canWrite: true, canDeactivate: true });
	// expect(
	// 	documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
	// 		(availableDocumentAction) =>
	// 			availableDocumentAction === documentAction.ReverseAccrual ||
	// 			availableDocumentAction === documentAction.ReverseCorrect,
	// 	),
	// ).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ canWrite: true, canDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ canWrite: false, canDeactivate: false });

	expect(menus.find((menu) => menu.window?.uuid === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ canWrite: true, canDeactivate: false });
	
	expect(menus.find((menu) => menu.window?.uuid === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();
});
