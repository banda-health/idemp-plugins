import axios, { AxiosError } from 'axios';
import { PdfData } from 'pdfdataextract';
import { languageApi, patientApi, referenceListApi, visitApi } from '../api';
import { documentAction, documentStatus, referenceUuid, tenderTypeName } from '../models';
import {
	BusinessPartner,
	Patient,
	Payment,
	PaymentType,
	ProcessInfoParameter,
	Visit,
} from '../types/org.bandahealth.idempiere.rest';
import {
	createPatient,
	createProduct,
	createPurchaseOrder,
	createVendor,
	createVisit,
	formatDate,
	runReport,
} from '../utils';

xtest(`information saved correctly after completing a visit`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

test(`patient open balance is 0 after visit if complete payment was made`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.orderLine!.lineNetAmount,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`patient open balance updated after visit if complete payment wasn't made`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: 50,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order! as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);
});

test(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: 50,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);

	valueObject.stepName = 'Reverse visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.order.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(60);
});

test(`patient open balance correct with multiple payments`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	const totalCharge = 100;
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	valueObject.order!.payments = [
		{
			payAmount: 50,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
		} as Payment,
		{
			payAmount: 30,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
		} as Payment,
	];
	let paymentTotal = valueObject.order!.payments.reduce(
		(runningTotal, payment) => (runningTotal += payment.payAmount),
		0,
	);

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		totalCharge - paymentTotal,
	);

	valueObject.stepName = 'Reverse visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.order.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	paymentTotal = valueObject
		.order!.payments.filter((payment) => !['RE', 'VO'].includes(payment.docStatus))
		.reduce((runningTotal, payment) => (runningTotal += payment.payAmount), 0);
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		totalCharge - paymentTotal,
	);
});

test('payments can be removed and added to re-opened visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	valueObject.order.payments = valueObject.order.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.order.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY,
		) as PaymentType,
	} as Payment);
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit again';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit again';
	valueObject.order.payments = valueObject.order.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.order.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.CHEQUE,
		) as PaymentType,
	} as Payment);
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test('re-opened visit returns voided/reversed payments', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect(
		valueObject.order.payments.some(
			(payment) => payment.docStatus === documentStatus.Reversed || payment.docStatus === documentStatus.Voided,
		),
	).toBeTruthy();
});

test('tender amount set correctly for payments', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			tenderAmount: valueObject.salesStandardPrice! + 500,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect(valueObject.order.payments[0].payAmount).toBe(valueObject.salesStandardPrice);
	expect(valueObject.order.payments[0].tenderAmount).toBe(valueObject.salesStandardPrice! + 500);
});

test('voiding visit returns voided/reversed payments', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Void visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.Void);

	expect(valueObject.order.payments.every((payment) => payment.docStatus === documentStatus.Reversed)).toBeTruthy();
	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`completing a "future" visit doesn't cause problems with the payment`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(5);
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test('correct patient shown when patient changed after initial switch', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create first patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);
	const firstPatientName = valueObject.businessPartner!.name;

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create second patient';
	valueObject.businessPartner = undefined;
	valueObject.setRandom();
	await createPatient(valueObject);
	(valueObject.order! as Visit).patient = { uuid: valueObject.businessPartner!.uuid } as Patient;
	const secondPatientName = valueObject.businessPartner!.name;

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	valueObject.stepName = 'Print the receipt';
	valueObject.processUuid = '30dd7243-11c1-4584-af26-5d977d117c84';
	valueObject.processInformationParameters = [
		{ parameterName: 'billId', parameter: valueObject.order.uuid } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	const pdfReceiptContent = (await PdfData.extract(valueObject.report!)).text?.join('');
	expect(pdfReceiptContent).toContain(secondPatientName.substring(0, 18));
	expect(pdfReceiptContent).not.toContain(firstPatientName.substring(0, 18));
});

test('create and complete pharmacy sales visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	const pharmacySalesPatients = (
		await patientApi.get(valueObject, 0, 10, undefined, JSON.stringify({ c_bp_group: { name: 'OTC Patient' } }))
	).results;
	expect(pharmacySalesPatients.length).toBe(1);
	const pharmacySalesPatient = pharmacySalesPatients[0];

	valueObject.businessPartner = pharmacySalesPatient;

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);
	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const patient: Partial<Patient> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
	};
	const savedPatient = await patientApi.save(valueObject, patient as Patient);
	valueObject.businessPartner = savedPatient as BusinessPartner;

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	const twoDaysAgo = new Date();
	twoDaysAgo.setDate(twoDaysAgo.getDate() - 2);
	twoDaysAgo.setUTCHours(12);
	valueObject.date = twoDaysAgo;
	await createVisit(valueObject);

	const fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.order!.uuid);
	expect(fetchedVisit.patient).toBeTruthy();
	expect(fetchedVisit.patient.lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(fetchedVisit.patient.totalVisits).toBe(1);
	expect(fetchedVisit.patient.nationalId).toBe(patient.nationalId);
	expect(fetchedVisit.patient.occupation).toBe(patient.occupation);
	expect(fetchedVisit.patient.nextOfKinName).toBe(patient.nextOfKinName);
	expect(fetchedVisit.patient.nextOfKinContact).toBe(patient.nextOfKinContact);
});

test('can remove a payment from a re-opened visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reactivate visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	valueObject.stepName = 'Remove the payments';
	valueObject.order.payments.length = 0;

	valueObject.stepName = 'Re-complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		valueObject.salesStandardPrice,
	);
});

test('can delete a drafted visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);
	valueObject.order!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];
	valueObject.order = await visitApi.save(valueObject, valueObject.order as Visit);

	valueObject.stepName = 'Delete visit';
	expect(await visitApi.delete(valueObject, valueObject.order.uuid)).toBe(true);
	expect(await visitApi.getByUuid(valueObject, valueObject.order.uuid)).toBeFalsy();
});

test(`product created and sold with more than received quantity throws an error`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create Patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 100;
	await expect(createVisit(valueObject)).rejects.toBeTruthy();
});

test(`selling more than in inventory error message is correct and is the same in every language`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create Patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 100;
	let negativeInventoryError: AxiosError;
	try {
		await createVisit(valueObject);
		expect(false).toBe(true);
		return;
	} catch (error) {
		expect(axios.isAxiosError(error)).toBe(true);
		negativeInventoryError = error as AxiosError;
	}
	// Since we'll be using this message in the front-end, it needs to be this exact value
	const disallowNegativeInventoryMessage =
		/The .+ warehouse does not allow negative inventory for Product = (.+), ASI = .+, Locator = .+ \(Shortage of (\d+)\)/;
	expect(negativeInventoryError.response?.data).toMatch(disallowNegativeInventoryMessage);

	const french = (await languageApi.get(valueObject)).results.find((language) => language.printName === 'Français');
	expect(french).toBeTruthy();
	valueObject.language = french?.locale;
	await valueObject.login();
	await expect(createVisit(valueObject)).rejects.toThrowError(negativeInventoryError);
});
