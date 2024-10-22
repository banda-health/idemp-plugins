import { query } from '../api';
import {
	DocumentAction,
	documentAction,
	DocumentBaseType,
	documentBaseType,
	DocumentStatus,
	referenceUuid,
	tenderTypeName,
} from '../models';
import { RoleName } from '../types/roleName';
import { Ad_Ref_ListGetDocument, DocumentStatusActionMapDocument } from '../__generated__/graphql';

test('tender type names to be correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const tenderTypes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES }, isactive: true }),
			},
		})
	).data.AD_Ref_ListGet.Results;

	// Ensure these exist
	expect(tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CASH)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CHEQUE)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.CREDIT_OR_DEBIT_CARD)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY)).not.toBeUndefined();

	// Ensure these don't exist
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Account')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Bill Waiver')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'CCC')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Check')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Credit Card')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Debit Card2')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Jubilee insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Liason insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Linda Mama')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'M-Pesa')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'M-TIBA')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'MCH')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'NHIF')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'Outreach')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.Name === 'PesaPal')).toBeUndefined();

	// Not sure about 'Direct Debit' & 'Debit Card' - should those show up?
});

test('document action access is correct for admins', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeTruthy();
});

test('clinic admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicAdmin);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeTruthy();
});

test('cashier/registration basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasic);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('cashier/registration basic plus role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationBasicPlus);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('cashier/registration advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierRegistrationAdvanced);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('inventory/pharmacy role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.InventoryPharmacyAdvanced);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeTruthy();
});

test('clinician/nurse basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseBasic);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('clinician/nurse advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicianNurseAdvanced);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('triage role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Triage);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('lab/radiology role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiology);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('accounting role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.Accounting);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('clinic user role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.ClinicUser);
	const documentStatusActionMap = JSON.parse(
		(await query(globalThis.__VALUE_OBJECT__)({ query: DocumentStatusActionMapDocument })).data.DocumentStatusActionMap,
	) as {
		[documentType in DocumentBaseType]: { [documentStatus in DocumentStatus]: DocumentAction[] };
	};

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
	});

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeFalsy();
});

test('process stage list is correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const processStageList = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.PROCESS_STAGE }, isactive: true }),
			},
		})
	).data.AD_Ref_ListGet.Results;

	// Ensure these exist
	expect(processStageList.find((processStage) => processStage.Name === 'Cashier / Registration')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Clinician / Dentist')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Lab')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Pharmacy')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Triage / Vitals')).toBeTruthy();
});
