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

test('payroll audit action vocabulary is dictionary-owned', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const auditActions = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({
					ad_reference: { ad_reference_uu: referenceUuid.PAYROLL_AUDIT_ACTIONS },
					isactive: true,
				}),
			},
		})
	).data.AD_Ref_ListGet.Results;

	const values = auditActions.map((action) => action.Value);
	for (const value of [
		'PERIOD_LOCK',
		'PERIOD_UNLOCK',
		'COMPONENT_CHANGE',
		'EMPLOYEE_ADD',
		'EMPLOYEE_EDIT',
		'EMPLOYEE_DEACTIVATE',
		'EMPLOYEE_REACTIVATE',
		'FILING_PAID',
		'FILING_REVERSED',
		'SETTINGS_CHANGE',
	]) {
		expect(values).toContain(value);
	}
});

test('payroll component vocabularies are dictionary-owned', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const listValues = async (referenceUu: string) =>
		(
			await query(globalThis.__VALUE_OBJECT__)({
				query: Ad_Ref_ListGetDocument,
				variables: {
					Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUu }, isactive: true }),
				},
			})
		).data.AD_Ref_ListGet.Results.map((entry) => entry.Value);

	const categories = await listValues(referenceUuid.PAYROLL_COMPONENT_CATEGORIES);
	for (const value of ['EARNING', 'EMPLOYER_CONTRIB', 'RELIEF', 'STAT_DED', 'VOL_DED']) {
		expect(categories).toContain(value);
	}

	const calcMethods = await listValues(referenceUuid.PAYROLL_CALC_METHODS);
	for (const value of ['BANDS', 'EMPLOYEE_AMOUNT', 'FIXED', 'PERCENT_OF_GROSS', 'TIERED']) {
		expect(calcMethods).toContain(value);
	}

	const filingTypes = await listValues(referenceUuid.PAYROLL_FILING_TYPES);
	for (const value of ['PAYE', 'NSSF', 'SHIF', 'HLEVY', 'NITA']) {
		expect(filingTypes).toContain(value);
	}
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

	Object.entries(documentStatusActionMap).forEach(
		([documentBaseTypeValue, statusActionMapForASpecificDocumentBaseType]) => {
			// BH_Payroll_Run (BPR, GO-3624) is a deliberate two-state document: DR --CO--> CO --RE--> DR.
			// MBHPayrollRun#voidIt() always returns false and no Void access was granted for it, so it
			// can't follow the Void-must-be-present expectations every DocumentEngine-native base type
			// follows below. Its real, narrower access is asserted separately after this loop.
			if (documentBaseTypeValue === documentBaseType.PayrollRun) {
				return;
			}

			expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
			expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Void);

			expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
			expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Void);

			expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		},
	);

	expect(
		documentStatusActionMap[documentBaseType.PurchaseOrder].CO.some(
			(action) =>
				action === documentAction.ReActivate ||
				action === documentAction.ReverseAccrual ||
				action === documentAction.ReverseCorrect,
		),
	).toBeTruthy();

	// BH_Payroll_Run (BPR): Clinic Admin is granted only Complete (from Drafted) — no Void, ever.
	expect(documentStatusActionMap[documentBaseType.PayrollRun].DR).toEqual([documentAction.Complete]);
	expect(documentStatusActionMap[documentBaseType.PayrollRun].DR).not.toContain(documentAction.Void);
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

test('cashier lite role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.CashierLite);
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

test('lab/radiology advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyAdvanced);
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

test('lab/radiology basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login(RoleName.LabRadiologyBasic);
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
	expect(processStageList.find((processStage) => processStage.Name === 'Lab / Imaging')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Pharmacy')).toBeTruthy();
	expect(processStageList.find((processStage) => processStage.Name === 'Triage / Vitals')).toBeTruthy();
});

test('inventory update reason list is correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const updateReasons = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.BH_UPDATE_REASON }, isactive: true }),
			},
		})
	).data.AD_Ref_ListGet.Results;

	// Ensure these exist
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Damaged products')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Product expired')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Products used but not charged')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Lost or stolen products')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'System unavailable at sale')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Wrong quantity received')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Wrong expiration received')).toBeDefined();
	expect(updateReasons.find((updateReason) => updateReason.Name === 'Stock Reconciliation')).toBeDefined();
});

test('visit type list is correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const visitTypes = (
		await query(globalThis.__VALUE_OBJECT__)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.VISIT_TYPE }, isactive: true }),
			},
		})
	).data.AD_Ref_ListGet.Results;

	// Ensure these exist
	expect(visitTypes.find((processStage) => processStage.Name === 'Outpatient (OPD)')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Inpatient (IPD)')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Antenatal (ANC)')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Immunizations & Well Child')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Maternity')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Dental')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Eye Clinic')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Surgery')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Over The Counter (OTC)')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Home Visit')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'PT/OT')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Follow-up')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Family Planning')).toBeTruthy();
	expect(visitTypes.find((processStage) => processStage.Name === 'Mental Health')).toBeTruthy();
});
