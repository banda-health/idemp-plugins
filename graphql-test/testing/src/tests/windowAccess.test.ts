import { query } from '../api';
import {
	DocumentAction,
	documentAction,
	DocumentBaseType,
	documentBaseType,
	DocumentStatus,
	documentStatus,
} from '../models';
import { RoleName } from '../types/roleName';
import { Ad_MenuGetDocument, DocumentStatusActionMapDocument } from '../__generated__/graphql';

const mainMenuRootUuid = 'bb0670c5-0dc1-468a-8b85-a91b15407368';

const windowUuid = {
	allergies: '45f693e1-d33a-43cf-81dc-1f75262f3bd0',
	clinicalDetails: '2e37e97b-aeb5-47d7-add3-0d602233c2aa',
	chiefComplaint: 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed',
	dashboard: 'd91768c8-5c5b-4d7c-9a6f-15b06d45908b',
	debtPayments: '4497b5f7-758d-4e82-8e2b-01c4364ce609',
	diagnoses: '1f29f7ab-bc9a-427c-b35b-87589e4612b5',
	expenseCategories: '5731bc45-3b78-475a-a347-4ca899f19e32',
	facilityInformation: '66df8b28-5a44-40a0-b63e-d51695bdfc92',
	manageInventory: '8f744d1c-427a-4b85-ab98-38e50258e86d',
	manageUsers: '6b934ec2-7f45-4104-ba10-08e3ce54de7e',
	nonPatientPayments: 'ab23d5c5-19ce-4c46-a17a-5ae2c37dd89d',
	otcPharmacySales: '3a4ac3cd-9e1b-4a2c-82d3-78f698ec9e1f',
	patients: 'ba697729-5ec8-44f7-b534-446310bb5782',
	patientTags: '3c865615-4f7e-4b19-a64b-740485d99e83',
	priceLists: 'e1ba0b91-cb26-4ab0-bcc6-2ee762ad1a84',
	products: 'c63b9972-1b23-4140-8bbb-0ea2b0b81024',
	productsAndServicesCatalogue: 'd4d1767a-1a6f-45ef-8b72-48ff004f1b4e',
	receiveProducts: '78dd6f39-84f9-4e19-b08e-7a3441af15e5',
	suppliers: '565af89e-8f10-4469-84f5-6cca8d7fae27',
	services: 'fd93da00-871d-4996-a3f7-4528bed8b758',
	trackExpenses: '37df7931-7d07-4812-b9d4-dec7a53bb70f',
	trackIncome: '44c02ddc-ef83-4020-8e4c-709d8cbeadc2',
	transferInventory: 'd3c84cad-7306-464d-85da-7e629846f8c0',
	visitsBills: 'a1f3e45c-4a6f-4c05-af26-517b8e9cbb77',
	vitals: '53b4d743-c311-40e5-aa8e-c0880c42c1b1',
} as const;

test('admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeDefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({
		IsReadWrite: true,
		BH_CanDeactivate: true,
	});
});

test('clinic admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicAdmin);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(true);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeDefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeDefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});

test('cashier/registration basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasic);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
});

test('cashier/registration basic plus role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasicPlus);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
});

test('cashier/registration advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationAdvanced);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});

test('inventory/pharmacy advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyAdvanced);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });;
});

test('inventory/pharmacy basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyBasic);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });;
});

test('clinician/nurse basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseBasic);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
});

test('clinician/nurse advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseAdvanced);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});

test('triage role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Triage);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patientTags]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toBeUndefined();
});

test('lab/radiology advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyAdvanced);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});

test('lab/radiology basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyBasic);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.debtPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.debtPayments]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});

test('accounting role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Accounting);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toBeUndefined();

	expect(windowAccess?.[windowUuid.chiefComplaint]).toBeUndefined();

	expect(windowAccess?.[windowUuid.clinicalDetails]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toBeUndefined();
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).toBeDefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeDefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeDefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeUndefined();
	expect(windowAccess?.[windowUuid.allergies]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeUndefined();
	expect(windowAccess?.[windowUuid.patientTags]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
});

test('clinic user role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicUser);
	const windowAccess = globalThis.__VALUE_OBJECT__.AD_Window_AccessMap;
	const menus = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_MenuGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_menu_uu: mainMenuRootUuid }) },
		})
	).data.AD_MenuGet.Results[0]
		.ChildrenTree_NodeMMList!.flatMap((menuNode) => [
			menuNode.Node,
			...(menuNode.Node?.ChildrenTree_NodeMMList?.map((childNode) => childNode.Node) || []),
		])
		.filter((item) => !!item);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patients)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.patients]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.suppliers)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.suppliers]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.products)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.products]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.services)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.services]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.visitsBills)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.visitsBills]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.SalesOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(windowAccess?.[windowUuid.vitals]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.chiefComplaint]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(windowAccess?.[windowUuid.clinicalDetails]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.diagnoses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.diagnoses]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.receiveProducts)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.receiveProducts]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder]?.[documentStatus.Completed]?.includes(documentAction.Void),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.manageInventory]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialPhysicalInventory]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(windowAccess?.[windowUuid.debtPayments]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARReceipt]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.expenseCategories)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.expenseCategories]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackExpenses)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackExpenses]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.APInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.trackIncome)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.trackIncome]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
	expect(
		documentStatusActionMap[documentBaseType.ARInvoice]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.nonPatientPayments)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.nonPatientPayments]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.manageUsers)).toBeUndefined();
	expect(windowAccess?.[windowUuid.manageUsers]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.transferInventory)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.transferInventory]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });
	expect(
		documentStatusActionMap[documentBaseType.MaterialMovement]?.[documentStatus.Completed]?.some(
			(availableDocumentAction) =>
				availableDocumentAction === documentAction.ReverseAccrual ||
				availableDocumentAction === documentAction.ReverseCorrect,
		),
	).toBe(false);

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.dashboard)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.dashboard]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.otcPharmacySales)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.otcPharmacySales]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.facilityInformation)).toBeUndefined();
	expect(windowAccess?.[windowUuid.facilityInformation]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.priceLists)).toBeUndefined();
	expect(windowAccess?.[windowUuid.priceLists]).toBeUndefined();

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.allergies)).toBeDefined();
	expect(windowAccess?.[windowUuid.allergies]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.patientTags)).toBeDefined();
	expect(windowAccess?.[windowUuid.patientTags]).toMatchObject({ IsReadWrite: false, BH_CanDeactivate: false });

	expect(menus.find((menu) => menu?.AD_Window?.UU === windowUuid.productsAndServicesCatalogue)).not.toBeUndefined();
	expect(windowAccess?.[windowUuid.productsAndServicesCatalogue]).toMatchObject({ IsReadWrite: true, BH_CanDeactivate: true });
});
