import axios, { AxiosError } from 'axios';
import isEqual from 'lodash/isEqual';
import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import {
	chargeApi,
	codedDiagnosisApi,
	encounterTypeWindowApi,
	languageApi,
	patientApi,
	referenceListApi,
	visitApi,
	voidedReasonApi,
} from '../api';
import {
	documentAction,
	documentBaseType,
	documentStatus,
	documentSubTypeSalesOrder,
	referenceUuid,
	tenderTypeName,
} from '../models';
import {
	BusinessPartner,
	Encounter,
	EncounterDiagnosis,
	Field,
	Observation,
	Order,
	OrderLine,
	Patient,
	Payment,
	PaymentType,
	ProcessInfoParameter,
	Visit,
} from '../types/org.bandahealth.idempiere.rest';
import {
	createOrder,
	createPatient,
	createPayment,
	createProduct,
	createPurchaseOrder,
	createVendor,
	createVisit,
	formatDate,
	runReport,
	tomorrow,
	yesterday,
} from '../utils';

const CLINICAL_VITALS_WINDOW_UUID = '53b4d743-c311-40e5-aa8e-c0880c42c1b1';
const CHIEF_COMPLAINT_FIELD_UUID = 'e1d01fe4-16b6-4125-a385-34cf4531c06f';
const HEIGHT_FIELD_UUID = '2842fb94-b841-4973-903e-89c7f24455b2';
const WEIGHT_FIELD_UUID = 'e0f68d60-0610-4caa-9dc3-b0143101ccd3';

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`visit saved from scratch is correct`, async () => {
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

	valueObject.stepName = 'Create and complete visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner as Patient | undefined,
		visitDate: valueObject.date,
		orders: [
			{
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
			} as Partial<Order>,
		],
		payments: [
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 60,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
			},
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, visitToSave, documentAction.Complete);

	expect(valueObject.visit.orders.every((order) => order.docStatus === documentStatus.Completed));
	expect(valueObject.visit.payments.every((order) => order.docStatus === documentStatus.Completed));

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	const fetchedVisit = (
		await visitApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ bh_visit_uu: valueObject.visit.uuid }),
		)
	).results[0];
	expect(fetchedVisit.orders).toHaveLength(1);
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.visit.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	valueObject.visit!.payments = [
		{
			payAmount: 50,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
		} as Payment,
		{
			payAmount: 30,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
		} as Payment,
	];
	let paymentTotal = valueObject.visit!.payments.reduce(
		(runningTotal, payment) => (runningTotal += payment.payAmount),
		0,
	);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		totalCharge - paymentTotal,
	);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.visit.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	paymentTotal = valueObject
		.visit!.payments.filter((payment) => !['RE', 'VO'].includes(payment.docStatus))
		.reduce((runningTotal, payment) => (runningTotal += payment.payAmount), 0);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = valueObject.salesStandardPrice;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	valueObject.visit.payments = valueObject.visit.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.visit.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY,
		) as PaymentType,
	} as Payment);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit again';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit again';
	valueObject.visit.payments = valueObject.visit.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.visit.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.CHEQUE,
		) as PaymentType,
	} as Payment);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect(
		valueObject.visit.payments.some(
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			tenderAmount: valueObject.salesStandardPrice! + 500,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect(valueObject.visit.payments[0].payAmount).toBe(valueObject.salesStandardPrice);
	expect(valueObject.visit.payments[0].tenderAmount).toBe(valueObject.salesStandardPrice! + 500);
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Void visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.Void);

	expect(valueObject.visit.payments.every((payment) => payment.docStatus === documentStatus.Reversed)).toBeTruthy();
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create second patient';
	valueObject.businessPartner = undefined;
	valueObject.setRandom();
	await createPatient(valueObject);
	valueObject.visit!.patient = { uuid: valueObject.businessPartner!.uuid } as Patient;
	const secondPatientName = valueObject.businessPartner!.name;

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	valueObject.stepName = 'Print the receipt';
	valueObject.processUuid = '30dd7243-11c1-4584-af26-5d977d117c84';
	valueObject.processInformationParameters = [
		{ parameterName: 'billId', parameter: valueObject.visit.uuid } as ProcessInfoParameter,
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);
	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`getByUuid method returns the correct data`, async () => {
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);

	const fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit!.uuid);
	expect(fetchedVisit.patient).toBeTruthy();
	expect(fetchedVisit.patient.lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(fetchedVisit.patient.totalVisits).toBe(1);
	expect(fetchedVisit.patient.nationalId).toBe(patient.nationalId);
	expect(fetchedVisit.patient.occupation).toBe(patient.occupation);
	expect(fetchedVisit.patient.nextOfKinName).toBe(patient.nextOfKinName);
	expect(fetchedVisit.patient.nextOfKinContact).toBe(patient.nextOfKinContact);
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);

	const paginatedVisits = await visitApi.get(
		valueObject,
		undefined,
		undefined,
		undefined,
		JSON.stringify({ bh_visit_uu: valueObject.visit!.uuid }),
	);
	expect(paginatedVisits.results.length).toBe(1);
	expect(paginatedVisits.results[0].orders[0].grandTotal).toBeGreaterThan(0);
	expect(paginatedVisits.results[0].orders[0].grandTotal).toBe(valueObject.visit.orders[0].grandTotal);
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reactivate visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	valueObject.stepName = 'Remove the payments';
	valueObject.visit.payments.length = 0;

	valueObject.stepName = 'Re-complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);

	valueObject.stepName = 'Delete visit';
	expect(await visitApi.delete(valueObject, valueObject.visit.uuid)).toBe(true);
	expect(await visitApi.getByUuid(valueObject, valueObject.visit.uuid)).toBeFalsy();
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
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	valueObject.quantity = 100;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	await expect(visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete)).rejects.toBeTruthy();
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
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	valueObject.quantity = 100;
	await createOrder(valueObject);

	let negativeInventoryError: AxiosError;
	try {
		await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);
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

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	valueObject.quantity = 100;
	await createOrder(valueObject);

	await expect(visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete)).rejects.toThrowError(
		negativeInventoryError,
	);
});

test('voiding visits shows data on the report correctly', async () => {
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

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Void visit';
	valueObject.visit!.voidedReason = (await voidedReasonApi.get(valueObject)).results[0];
	const voidingReason = valueObject.visit.voidedReason;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Void);

	valueObject.stepName = 'Run the report';
	valueObject.processUuid = '20a623fb-e127-4c26-98d5-3604a6d100b2';
	valueObject.reportType = 'xlsx';
	valueObject.processInformationParameters = [
		{ parameterName: 'Begin Date', parameter: yesterday() } as ProcessInfoParameter,
		{ parameterName: 'End Date', parameter: tomorrow() } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	const excelFile = xlsx.parse(valueObject.report!);
	const voidedVisitRow = excelFile[0].data.filter((row) =>
		(row[1]?.toString() as string | undefined)?.includes(valueObject.businessPartner!.name.substring(0, 30)),
	)?.[0];
	expect(voidedVisitRow).toBeTruthy();
	expect(voidedVisitRow[4]).toBe(voidingReason.name);
});

test('visit can be saved with really long chief complaint', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);
	const longChiefComplaint = 'this hurts '.repeat(20);
	const clinicalVitalsEncounterTypeWindow = (
		await encounterTypeWindowApi.get(valueObject, 0, 1, undefined, undefined)
	).results.find((result) => result.window.uuid == CLINICAL_VITALS_WINDOW_UUID);
	const chiefComplaintField = clinicalVitalsEncounterTypeWindow?.window.tabs[0].fields.filter(
		(field) => field.uuid == CHIEF_COMPLAINT_FIELD_UUID,
	)[0] as Field;

	valueObject.visit!.encounters!.push({
		encounterType: clinicalVitalsEncounterTypeWindow?.encounterType,
		observations: [
			{
				value: longChiefComplaint,
				field: chiefComplaintField,
			} as Observation,
		],
	} as Encounter);

	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters[0].observations[0].value).toBe(longChiefComplaint);
});

test('clinical vitals fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	const clinicalVitalsEncounterTypeWindow = (
		await encounterTypeWindowApi.get(valueObject, 0, 10, undefined, undefined)
	).results.find((result) => result.window.uuid == CLINICAL_VITALS_WINDOW_UUID);
	const fields = clinicalVitalsEncounterTypeWindow?.window.tabs[0].fields;

	const heightValue = '200';
	const weightValue = '100';

	const codedDiagnosis = (await codedDiagnosisApi.get(valueObject)).results[0];
	const uncodedDiagnosisValue = 'Test uncoded diagnosis';
	const encounter: Partial<Encounter> = {
		encounterType: clinicalVitalsEncounterTypeWindow?.encounterType,
		observations: [
			{
				value: heightValue,
				field: fields?.filter((field) => field.uuid == HEIGHT_FIELD_UUID)[0],
			} as Observation,
		],
		encounterDiagnoses: [
			{
				lineNo: 1,
				uncodedDiagnosis: uncodedDiagnosisValue,
			} as EncounterDiagnosis,
			{
				lineNo: 2,
				codedDiagnosis: { uuid: codedDiagnosis.uuid },
			} as EncounterDiagnosis,
		],
	};

	valueObject.visit!.encounters!.push(encounter as Encounter);

	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations[0].value).toBe(heightValue);
	expect(valueObject.visit.encounters[0].encounterDiagnoses).toHaveLength(2);
	expect(valueObject.visit.encounters[0].encounterDiagnoses[0].uncodedDiagnosis).toBe(uncodedDiagnosisValue);
	expect(valueObject.visit.encounters[0].encounterDiagnoses[1].codedDiagnosis.uuid).toBeTruthy();
	expect(valueObject.visit.encounters[0].encounterDiagnoses[1].codedDiagnosis.uuid).toBe(codedDiagnosis.uuid);

	valueObject.stepName = 'Change observations and remove diagnosis';
	valueObject.visit!.encounters[0].observations = [
		{
			value: weightValue,
			field: fields?.filter((field) => field.uuid == WEIGHT_FIELD_UUID)[0],
		} as Observation,
	];
	valueObject.visit!.encounters[0].encounterDiagnoses = [];

	valueObject.stepName = 'Save visit again';
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations[0].value).toBe(weightValue);
	expect(valueObject.visit.encounters[0].encounterDiagnoses).toHaveLength(0);

	valueObject.stepName = 'Add observations and re-add diagnosis';
	valueObject.visit!.encounters[0].observations = [
		{
			value: heightValue,
			field: fields?.filter((field) => field.uuid == HEIGHT_FIELD_UUID)[0],
		} as Observation,
		{
			value: weightValue,
			field: fields?.filter((field) => field.uuid == WEIGHT_FIELD_UUID)[0],
		} as Observation,
	];
	valueObject.visit!.encounters[0].encounterDiagnoses = [
		{
			lineNo: 1,
			uncodedDiagnosis: uncodedDiagnosisValue,
		} as EncounterDiagnosis,
	];

	valueObject.stepName = 'Save visit again';
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations).toHaveLength(2);
	expect(valueObject.visit.encounters[0].observations[0].value).toBe(heightValue);
	expect(valueObject.visit.encounters[0].observations[1].value).toBe(weightValue);
	expect(valueObject.visit.encounters[0].encounterDiagnoses).toHaveLength(1);
	expect(valueObject.visit.encounters[0].encounterDiagnoses[0].uncodedDiagnosis).toBe(uncodedDiagnosisValue);
});

test(`visit saved and completed matches what is returned from visit getByUuid`, async () => {
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

	valueObject.stepName = 'Create and complete visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const chargeToUse = (await chargeApi.getNonPatientPayments(valueObject)).results.filter(
		(charge) => charge.chargeInformationList.length,
	)[0];
	const chargeInformationToUse = chargeToUse.chargeInformationList.filter(
		(chargeInformation) => chargeInformation.dataType.value === 'T',
	)[0];
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner as Patient | undefined,
		visitDate: valueObject.date,
		orders: [
			{
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: chargeToUse,
						quantity: 1,
						price: 50,
						chargeInformationList: [{ chargeInformationUuid: chargeInformationToUse.uuid, value: 'Test' }],
					} as OrderLine,
				],
			} as Partial<Order>,
		],
		payments: [
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 60,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
			},
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);
	const savedVisit = valueObject.visit!;
	let fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit.uuid);
	expect(isEqual(valueObject.visit, fetchedVisit)).toBeTruthy();

	valueObject.visit = await visitApi.saveAndProcess(valueObject, savedVisit, documentAction.Complete);
	fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit.uuid);
	expect(isEqual(valueObject.visit, fetchedVisit)).toBeTruthy();
});

test(`visit with non-patient payment information can be deleted`, async () => {
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
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const chargeToUse = (await chargeApi.getNonPatientPayments(valueObject)).results.filter(
		(charge) => charge.chargeInformationList.length,
	)[0];
	const chargeInformationToUse = chargeToUse.chargeInformationList.filter(
		(chargeInformation) => chargeInformation.dataType.value === 'T',
	)[0];
	const clinicalVitalsEncounterTypeWindow = (
		await encounterTypeWindowApi.get(
			valueObject,
			0,
			10,
			undefined,
			JSON.stringify({
				ad_window: { ad_window_uu: CLINICAL_VITALS_WINDOW_UUID },
			}),
		)
	).results[0];
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner as Patient | undefined,
		visitDate: valueObject.date,
		encounters: [
			{
				encounterType: clinicalVitalsEncounterTypeWindow.encounterType,
				observations: [
					{
						value: '100',
						field: clinicalVitalsEncounterTypeWindow.window.tabs[0].fields?.filter(
							(field) => field.uuid == HEIGHT_FIELD_UUID,
						)[0],
					} as Observation,
				],
				encounterDiagnoses: [
					{
						lineNo: 1,
						uncodedDiagnosis: 'In some pain...',
					} as EncounterDiagnosis,
				],
			} as Encounter,
		],
		orders: [
			{
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: chargeToUse,
						quantity: 1,
						price: 50,
						chargeInformationList: [{ chargeInformationUuid: chargeInformationToUse.uuid, value: 'Test' }],
					} as OrderLine,
				],
			} as Partial<Order>,
		],
		payments: [
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 60,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
			},
			{
				orgId: 0,
				patient: valueObject.businessPartner as unknown as Patient,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);

	expect(await visitApi.delete(valueObject, valueObject.visit!.uuid)).toBeTruthy();
});
