import { referenceListApi } from '../api';
import { documentAction, referenceUuid, tenderTypeName, ValueObject } from '../models';

test('tender type names to be correct', async () => {
	globalThis.__VALUE_OBJECT__.login();

	const tenderTypes = await referenceListApi.getByReference(
		globalThis.__VALUE_OBJECT__,
		referenceUuid.TENDER_TYPES,
		false,
	);

	// Ensure these exist
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CHEQUE)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CREDIT_OR_DEBIT_CARD)).not.toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY)).not.toBeUndefined();

	// Ensure these don't exist
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Account')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Bill Waiver')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'CCC')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Check')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Credit Card')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Debit Card2')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Jubilee insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Liason insurance')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Linda Mama')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'M-Pesa')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'M-TIBA')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'MCH')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'NHIF')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'Outreach')).toBeUndefined();
	expect(tenderTypes.find((tenderType) => tenderType.name === 'PesaPal')).toBeUndefined();

	// Not sure about 'Direct Debit' & 'Debit Card' - should those show up?
});

test('document action access is correct for admins', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('clinic admin role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic Admin');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('cashier/registration basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Basic');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('cashier/registration advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Cashier/Registration Advanced');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('inventory/pharmacy role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Inventory/Pharmacy');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('clinician/nurse basic role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Basic');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('clinician/nurse advanced role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinician/Nurse Advanced');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('triage role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Triage');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('lab/radiology role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Lab/Radiology');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('accounting role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Accounting');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});

test('clinic user role has correct access', async () => {
	await globalThis.__VALUE_OBJECT__.login('Clinic User');
	const documentStatusActionMap = await referenceListApi.getDocumentStatusActionMap(globalThis.__VALUE_OBJECT__);

	Object.values(documentStatusActionMap).forEach((statusActionMapForASpecificDocumentBaseType) => {
		expect(statusActionMapForASpecificDocumentBaseType.DR).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.DR).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.IP).toContain(documentAction.Complete);
		expect(statusActionMapForASpecificDocumentBaseType.IP).not.toContain(documentAction.Void);

		expect(statusActionMapForASpecificDocumentBaseType.CO).not.toContain(documentAction.Close);
		expect(
			statusActionMapForASpecificDocumentBaseType.CO.some(
				(action) =>
					action === documentAction.ReActivate ||
					action === documentAction.Void ||
					action === documentAction.ReverseAccrual ||
					action === documentAction.ReverseCorrect,
			),
		);
	});
});
