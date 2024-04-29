import axios, { AxiosError } from 'axios';
import { randomUUID } from 'crypto';
import isEqual from 'lodash/isEqual';
import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import { v4 } from 'uuid';
import {
	businessPartnerApi,
	businessPartnerGroupApi,
	codedDiagnosisApi,
	conceptApi,
	encounterApi,
	encounterTypeWindowApi,
	languageApi,
	referenceListApi,
	roleApi,
	visitApi,
	voidedReasonApi,
	userApi,
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
	AttributeSetInstance,
	BusinessPartner,
	Charge,
	Encounter,
	EncounterDiagnosis,
	EncounterDiagnostic,
	Field,
	Invoice,
	InvoiceLine,
	Observation,
	Order,
	OrderLine,
	Payment,
	PaymentType,
	ProcessInfoParameter,
	Visit,
	VoidedReason,
	User,
} from '../types/org.bandahealth.idempiere.rest';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	formatDate,
	runReport,
	tomorrow,
	yesterday,
} from '../utils';

const CLINICAL_VITALS_WINDOW_UUID = '53b4d743-c311-40e5-aa8e-c0880c42c1b1';
const CHIEF_COMPLAINT_WINDOW_UUID = 'ee3189d3-9bf5-4528-b5c8-26f2cabde1ed';
const CHIEF_COMPLAINT_FIELD_UUID = 'e1d01fe4-16b6-4125-a385-34cf4531c06f';
const HEIGHT_FIELD_UUID = '2842fb94-b841-4973-903e-89c7f24455b2';
const WEIGHT_FIELD_UUID = 'e0f68d60-0610-4caa-9dc3-b0143101ccd3';
const LAB_DIAGNOSTICS_WINDOW_UUID = '3084592a-531b-4fbd-a412-5c14c2b15288';
const LAB_NOTES_FIELD_UUID = '4c4e87c6-e453-470b-87bd-a0c4c6a83438';

xtest(`information saved correctly after completing a visit`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

test(`patient open balance is 0 after visit if complete payment was made`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`visit saved from scratch is correct`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create and complete visit';
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner!,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			} as Partial<Invoice>,
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner!,
				description: valueObject.getStepMessageLong(),
				payAmount: 60,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner!,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, visitToSave, documentAction.Complete);

	expect(valueObject.visit.orders.every((order) => order.docStatus === documentStatus.Completed));
	expect(valueObject.visit.invoices.every((order) => order.docStatus === documentStatus.Completed));
	expect(valueObject.visit.payments.every((order) => order.docStatus === documentStatus.Completed));

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		50,
	);
});

test(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 50;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		50,
	);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.visit.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		60,
	);
});

test(`patient open balance correct with multiple payments`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	const totalCharge = 100;
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payments';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	valueObject.visit!.payments = [
		{
			payAmount: 50,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
		{
			payAmount: 30,
			paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];
	let paymentTotal = valueObject.visit!.payments.reduce(
		(runningTotal, payment) => (runningTotal += payment.payAmount),
		0,
	);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		totalCharge - paymentTotal,
	);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	const newPayment = valueObject.visit.payments.find((payment) => payment.docStatus === 'DR');
	expect(newPayment).not.toBeUndefined();
	newPayment!.payAmount = 40;
	paymentTotal = valueObject
		.visit!.payments.filter((payment) => !['RE', 'VO'].includes(payment.docStatus))
		.reduce((runningTotal, payment) => (runningTotal += payment.payAmount), 0);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		totalCharge - paymentTotal,
	);
});

test('payments can be removed and added to re-opened visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = valueObject.salesStandardPrice;
	valueObject.tenderType = (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
		(tenderType) => tenderType.name === tenderTypeName.CASH,
	) as PaymentType;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit.payments = valueObject.visit.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.visit.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY,
		) as PaymentType,
		documentType: valueObject.documentType,
	} as Payment);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit again';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit again';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit.payments = valueObject.visit.payments.filter((payment) => payment.docStatus !== 'DR');
	valueObject.visit.payments.push({
		payAmount: valueObject.salesStandardPrice,
		paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
			(tenderType) => tenderType.name === tenderTypeName.CHEQUE,
		) as PaymentType,
		documentType: valueObject.documentType,
	} as Payment);
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test('re-opened visit returns voided/reversed invoices and payments', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reverse visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	expect(
		valueObject.visit.invoices.some(
			(invoice) => invoice.docStatus === documentStatus.Reversed || invoice.docStatus === documentStatus.Voided,
		),
	).toBeTruthy();
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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			tenderAmount: valueObject.salesStandardPrice! + 500,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect(valueObject.visit.payments[0].payAmount).toBe(valueObject.salesStandardPrice);
	expect(valueObject.visit.payments[0].tenderAmount).toBe(valueObject.salesStandardPrice! + 500);
});

test('voiding visit returns voided/reversed invoices and payments', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Void visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.Void);

	expect(valueObject.visit.invoices.every((invoice) => invoice.docStatus === documentStatus.Reversed)).toBeTruthy();
	expect(valueObject.visit.payments.every((payment) => payment.docStatus === documentStatus.Reversed)).toBeTruthy();
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`completing a "future" visit doesn't cause problems with the payment`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(5);
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test('correct patient shown when patient changed after initial switch', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create first business partner';
	await createBusinessPartner(valueObject);
	const firstPatientName = valueObject.businessPartner!.name;

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create second patient';
	valueObject.businessPartner = undefined;
	valueObject.setRandom();
	await createBusinessPartner(valueObject);
	valueObject.visit!.patient = { uuid: valueObject.businessPartner!.uuid } as BusinessPartner;
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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	const pharmacySalesPatients = (
		await businessPartnerApi.get(valueObject, 0, 10, undefined, JSON.stringify({ c_bp_group: { name: 'OTC Patient' } }))
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
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`getByUuid method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	const businessPartner: Partial<BusinessPartner> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
		isCustomer: true,
	};
	valueObject.businessPartner = await businessPartnerApi.save(valueObject, businessPartner as BusinessPartner);

	valueObject.stepName = 'Get insurer to use';
	const insurerOrDonorToUse = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = insurerOrDonorToUse.payerInformationFieldList.filter(
		(payerInformationField) => payerInformationField.dataType.value === 'T',
	)[0];
	const randomInformationField = randomUUID();

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	const twoDaysAgo = new Date();
	twoDaysAgo.setDate(twoDaysAgo.getDate() - 2);
	twoDaysAgo.setUTCHours(12);
	valueObject.date = twoDaysAgo;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: -50,
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: insurerOrDonorToUse,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, name: randomInformationField },
						],
					} as InvoiceLine,
				],
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 10,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);

	const fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit!.uuid);
	expect(fetchedVisit.patient).toBeTruthy();
	expect(fetchedVisit.patient.lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(fetchedVisit.patient.totalVisits).toBe(1);
	expect(fetchedVisit.patient.nationalId).toBe(businessPartner.nationalId);
	expect(fetchedVisit.patient.occupation).toBe(businessPartner.occupation);
	expect(fetchedVisit.patient.nextOfKinName).toBe(businessPartner.nextOfKinName);
	expect(fetchedVisit.patient.nextOfKinContact).toBe(businessPartner.nextOfKinContact);
	// Make sure every invoice has it's BP
	expect(fetchedVisit.invoices.every((invoice) => !!invoice.businessPartner?.businessPartnerGroup?.uuid)).toBe(true);
	// Make sure each invoice that has an order and every invoice line has it's order line
	expect(fetchedVisit.invoices.some((invoice) => !!invoice.order?.uuid)).toBe(true);
	expect(
		fetchedVisit.invoices
			.find((invoice) => !!invoice.order?.uuid)
			?.invoiceLines.some((invoiceLine) => !!invoiceLine.orderLine?.uuid),
	).toBe(true);
	expect(
		fetchedVisit.invoices
			.find((invoice) =>
				invoice.invoiceLines.find((invoiceLine) => invoiceLine.businessPartnerSpecificPayerInformationList.length),
			)
			?.invoiceLines.find((invoiceLine) => invoiceLine.businessPartnerSpecificPayerInformationList.length)
			?.businessPartnerSpecificPayerInformationList[0].name,
	).toBe(randomInformationField);
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const businessPartner: Partial<BusinessPartner> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
		isCustomer: true,
	};
	const savedPatient = await businessPartnerApi.save(valueObject, businessPartner as BusinessPartner);
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
		documentSubTypeSalesOrder.WarehouseOrder,
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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Reactivate visit';
	valueObject.visit = await visitApi.process(valueObject, valueObject.visit.uuid, documentAction.ReActivate);

	valueObject.stepName = 'Remove the payments';
	valueObject.visit.payments.length = 0;

	valueObject.stepName = 'Re-complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(
		valueObject.salesStandardPrice,
	);
});

test('can delete a drafted visit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);

	valueObject.stepName = 'Delete visit';
	expect(await visitApi.deleteByUuid(valueObject, valueObject.visit.uuid)).toBe(true);
	expect(await visitApi.getByUuid(valueObject, valueObject.visit.uuid)).toBeFalsy();
});

test(`product created and sold with more than received quantity throws an error`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	valueObject.quantity = 100;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
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
		documentSubTypeSalesOrder.WarehouseOrder,
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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.visit!.payments = [
		{
			payAmount: valueObject.salesStandardPrice,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
			documentType: valueObject.documentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

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

	valueObject.stepName = 'Create business partner';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);
	const longChiefComplaint = 'this hurts '.repeat(20);
	const chiefComplaintEncounterTypeWindow = (
		await encounterTypeWindowApi.get(valueObject, undefined, undefined, undefined, undefined)
	).results.find((result) => result.window.uuid == CHIEF_COMPLAINT_WINDOW_UUID);
	expect(chiefComplaintEncounterTypeWindow).toBeTruthy();
	const chiefComplaintField = chiefComplaintEncounterTypeWindow?.window.tabs[0].fields.filter(
		(field) => field.uuid == CHIEF_COMPLAINT_FIELD_UUID,
	)[0] as Field;

	valueObject.visit!.encounters!.push({
		encounterType: chiefComplaintEncounterTypeWindow?.encounterType,
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
	await createBusinessPartner(valueObject);

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
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create and complete visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const insurerOrDonor = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = insurerOrDonor.payerInformationFieldList.filter(
		(payerInformationField) => payerInformationField.dataType.value === 'T',
	)[0];
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonor.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: -50,
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: insurerOrDonor,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonor.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, name: 'Test' },
						],
					} as InvoiceLine,
				],
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 60,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);
	const savedVisit = valueObject.visit!;
	let fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit.uuid);
	// This is a flaky test, so figure out why it fails (if it does)
	if (!isEqual(valueObject.visit, fetchedVisit)) {
		console.log(JSON.stringify(valueObject.visit), JSON.stringify(fetchedVisit));
	}
	expect(isEqual(valueObject.visit, fetchedVisit)).toBeTruthy();

	valueObject.visit = await visitApi.saveAndProcess(valueObject, savedVisit, documentAction.Complete);
	fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit.uuid);
	// This is a flaky test, so figure out why it fails (if it does)
	if (!isEqual(valueObject.visit, fetchedVisit)) {
		console.log(JSON.stringify(valueObject.visit), JSON.stringify(fetchedVisit));
	}
	expect(isEqual(valueObject.visit, fetchedVisit)).toBeTruthy();
});

test(`visit with non-patient payment information can be deleted`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const insurerOrDonorToUse = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = insurerOrDonorToUse.payerInformationFieldList.filter(
		(payerInformationField) => payerInformationField.dataType.value === 'T',
	)[0];
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonorToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: -50,
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: insurerOrDonorToUse,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonorToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, name: 'Test' },
						],
					} as InvoiceLine,
				],
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 10,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);

	expect(await visitApi.deleteByUuid(valueObject, valueObject.visit!.uuid)).toBeTruthy();
});

test(`visit invoice updates work`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const insurerOrDonorToUse = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'D'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = insurerOrDonorToUse.payerInformationFieldList.filter(
		(payerInformationField) => payerInformationField.dataType.value === 'T',
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
		patient: valueObject.businessPartner,
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
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonorToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: -50,
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: insurerOrDonorToUse,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						charge: insurerOrDonorToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, name: 'Test' },
						],
					} as InvoiceLine,
				],
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 10,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.save(valueObject, visitToSave);

	expect(valueObject.visit.invoices).toHaveLength(2);
	expect(valueObject.visit.invoices.find((invoice) => invoice.invoiceLines.length === 2)).toBeTruthy();
	expect(valueObject.visit.invoices.find((invoice) => invoice.invoiceLines.length === 1)).toBeTruthy();
	expect(valueObject.visit.payments).toHaveLength(2);

	valueObject.stepName = 'Remove insurance payer';
	valueObject.visit.invoices = valueObject.visit.invoices.filter(
		(invoice) => invoice.businessPartner.uuid === valueObject.businessPartner?.uuid,
	);
	valueObject.visit.invoices[0].invoiceLines = valueObject.visit.invoices[0].invoiceLines.filter(
		(invoiceLine) => !invoiceLine.charge,
	);
	valueObject.visit.payments[0].payAmount += 50; // Increase the cash payment by what the insurance was previously paying
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit);

	expect(valueObject.visit.invoices).toHaveLength(1);
	expect(valueObject.visit.invoices[0].invoiceLines).toHaveLength(1);
	expect(valueObject.visit.payments).toHaveLength(2);
});

test(`open balances are correct after re-openings and voiding`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create insurer';
	await createBusinessPartner(valueObject);
	valueObject.businessPartner!.businessPartnerGroup = (
		await businessPartnerGroupApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ bh_subtype: { $in: ['I'] } }),
		)
	).results[0];
	const insurer = await businessPartnerApi.save(valueObject, valueObject.businessPartner!);

	valueObject.stepName = 'Create business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	const paymentReceiptDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLineUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	const tenderTypes = await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false);
	const visitToSave = {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				orderLines: [
					{
						uuid: orderLineUuid,
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
					} as OrderLine,
				],
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						product: valueObject.product,
						quantity: 1,
						price: 100,
						orderLine: { uuid: orderLineUuid },
					} as InvoiceLine,
					{
						description: valueObject.getStepMessageLong(),
						charge: insurer.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: -50,
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: insurer,
				dateInvoiced: valueObject.date?.toISOString(),
				invoiceLines: [
					{
						description: valueObject.getStepMessageLong(),
						charge: insurer.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
					} as InvoiceLine,
				],
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
		payments: [
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 10,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.CASH) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
			{
				orgId: 0,
				businessPartner: valueObject.businessPartner,
				description: valueObject.getStepMessageLong(),
				payAmount: 40,
				paymentType: tenderTypes.find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType,
				documentType: paymentReceiptDocumentType,
			},
		],
	} as Visit;
	valueObject.visit = await visitApi.saveAndProcess(valueObject, visitToSave, documentAction.Complete);

	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(50);

	valueObject.stepName = 'Re-open visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.ReActivate);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-complete the visit as-is';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(50);

	valueObject.stepName = 'Re-re-open visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.ReActivate);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Remove reversed/voided invoices and payments';
	valueObject.visit.invoices = valueObject.visit.invoices.filter(
		(invoice) =>
			![
				documentStatus.Voided as string,
				documentAction.ReverseAccrual as string,
				documentStatus.Reversed as string,
			].includes(invoice.docStatus),
	);
	valueObject.visit.payments = valueObject.visit.payments.filter(
		(payment) =>
			![
				documentStatus.Voided as string,
				documentAction.ReverseAccrual as string,
				documentStatus.Reversed as string,
			].includes(payment.docStatus),
	);
	expect(valueObject.visit.invoices).toHaveLength(2);
	expect(valueObject.visit.payments).toHaveLength(2);

	valueObject.stepName = 'Remove insurance payer';
	valueObject.visit.invoices = valueObject.visit.invoices.filter(
		(invoice) => invoice.businessPartner.uuid === valueObject.businessPartner?.uuid,
	);
	valueObject.visit.invoices[0].invoiceLines = valueObject.visit.invoices[0].invoiceLines.filter(
		(invoiceLine) => !invoiceLine.charge,
	);
	valueObject.visit.payments[0].payAmount += 50; // Increase the cash payment by what the insurance was previously paying
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Void the visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit, documentAction.Void);
	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
	expect((await businessPartnerApi.getByUuid(valueObject, insurer.uuid)).totalOpenBalance).toBe(0);
});

test(`visit can be saved without order and invoice lines`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();

	valueObject.stepName = 'Create visit';
	valueObject.visit = await visitApi.save(valueObject, {
		description: valueObject.getStepMessageLong(),
		patient: valueObject.businessPartner,
		visitDate: valueObject.date,
		orders: [
			{
				uuid: orderUuid,
				description: valueObject.getStepMessageLong(),
				dateOrdered: valueObject.date,
				warehouse: valueObject.warehouse,
				documentTypeTarget: salesOrderDocumentType,
			} as Partial<Order>,
		],
		invoices: [
			{
				description: valueObject.getStepMessageLong(),
				businessPartner: valueObject.businessPartner!,
				dateInvoiced: valueObject.date?.toISOString(),
				order: { uuid: orderUuid },
				documentTypeTarget: customerInvoiceDocumentType,
			},
		],
	} as Visit);

	expect(valueObject.visit).toBeTruthy();
	expect(valueObject.visit.orders).toHaveLength(1);
	expect(valueObject.visit.orders[0].orderLines).toHaveLength(0);
	expect(valueObject.visit.invoices).toHaveLength(1);
	expect(valueObject.visit.invoices[0].invoiceLines).toHaveLength(0);
});

test(`document number should be returned for saved visits`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

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
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);

	const paginatedVisits = await visitApi.get(
		valueObject,
		undefined,
		undefined,
		undefined,
		JSON.stringify({ bh_visit_uu: valueObject.visit!.uuid }),
	);
	expect(paginatedVisits.results[0].documentNumber).not.toBe('');
});

test(`can delete order & invoice lines at the same time`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create product 2';
	valueObject.salesStandardPrice = 120;
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product2 = valueObject.product!;

	valueObject.stepName = 'Create visit';
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	const salesOrderDocumentType = valueObject.documentType!;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const customerInvoiceDocumentType = valueObject.documentType!;
	const orderUuid = randomUUID();
	const orderLine1Uuid = randomUUID();
	const orderLine2Uuid = randomUUID();
	
	//valueObject.stepName = 'Create user directly';

	const availableRoles = (await roleApi.get(valueObject)).results;
	const cashierRole = availableRoles.filter((role) => role.name.toLowerCase().includes('cashier'))[0];

	const userToCreate: Partial<User> = {
		name: valueObject.getDynamicStepMessage(),
		isActive: true,
		roles: [cashierRole]
	};
	const createdUser = await userApi.save(valueObject, userToCreate as User);
	
	
	const visit: Partial<Visit> = {
		uuid: randomUUID(),
		patient: valueObject.businessPartner!,
		visitDate: new Date(1698751197099),
		encounters: [
			{
				clientId: 1000000,
				orgId: 1000000,
				uuid: v4(),
				created: '2023-10-31 02:20:22',
				isActive: true,
				createdTimestamp: new Date(1698751222099),
				encounterType: {
					clientId: 0,
					orgId: 0,
					uuid: '6b25aa54-bbae-4432-a4e9-7a9a3116fc95',
					created: '2023-07-06 12:37:28',
					isActive: true,
					createdTimestamp: new Date(1688636248131),
					name: 'Capture Vitals',
					value: 'V',
					description: '',
					createdBy: createdUser,
					updatedBy: createdUser,
					updated: new Date(1688636248131),
				},
				observations: [],
				encounterDiagnoses: [],
				encounterDiagnostics: [],
				createdBy: createdUser,
				updatedBy: createdUser,
				updated: new Date(1688636248131),
			},
			{
				clientId: 1000000,
				orgId: 1000000,
				uuid: v4(),
				created: '2023-10-31 02:20:22',
				isActive: true,
				createdTimestamp: new Date(1698751222393),
				encounterType: {
					clientId: 0,
					orgId: 0,
					uuid: '9bd78d1a-3ec7-46eb-a7b9-58c183b823ae',
					created: '2023-07-21 11:30:16',
					isActive: true,
					createdTimestamp: new Date(1689928216746),
					name: 'Clinical Details',
					description: 'clinical details',
					value: 'D',
					createdBy: createdUser,
					updatedBy: createdUser,
					updated: new Date(1688636248131),
				},
				observations: [],
				encounterDiagnoses: [],
				encounterDiagnostics: [],
				createdBy: createdUser,
				updatedBy: createdUser,
				updated: new Date(1688636248131),
			},
		],
		orders: [
			{
				clientId: 1000000,
				orgId: 1000000,
				uuid: orderUuid,
				created: '2023-10-31 02:20:22',
				isActive: true,
				createdTimestamp: new Date(1698751222709),
				dateAccount: new Date(1698751222709),
				businessPartner: valueObject.businessPartner!,
				description: '',
				dateOrdered: new Date(1698699600000),
				grandTotal: 30200,
				docStatus: 'DR',
				createdBy: createdUser,
				updatedBy: createdUser,
				updated: new Date(1688636248131),
				orderLines: [
					{
						clientId: 1000000,
						orgId: 1000000,
						uuid: orderLine1Uuid,
						created: '2023-11-01 11:56:45',
						isActive: true,
						createdTimestamp: new Date(1698829005247),
						price: 200,
						quantity: 1,
						product: product1,
						lineNetAmount: 200,
						charge: null as unknown as Charge,
						description: '',
						attributeSetInstance: null as unknown as AttributeSetInstance,
						instructions: '',
						createdBy: createdUser,
						updatedBy: createdUser,
						updated: new Date(1688636248131),
					},
					{
						clientId: 1000000,
						orgId: 1000000,
						uuid: orderLine2Uuid,
						created: '2023-10-31 02:20:22',
						isActive: true,
						createdTimestamp: new Date(1698751222793),
						price: 30000,
						quantity: 1,
						product: product2,
						lineNetAmount: 30000,
						charge: null as unknown as Charge,
						description: '',
						attributeSetInstance: null as unknown as AttributeSetInstance,
						instructions: '',
						createdBy: createdUser,
						updatedBy: createdUser,
						updated: new Date(1688636248131),
					},
				],
				warehouse: valueObject.warehouse!,
				voidedReason: {} as VoidedReason,
				documentTypeTarget: salesOrderDocumentType,
				isSalesOrderTransaction: true,
			},
		],
		invoices: [
			{
				clientId: 1000000,
				orgId: 1000000,
				uuid: randomUUID(),
				created: '2023-10-31 02:20:23',
				isActive: true,
				dateInvoicedCreated: new Date(1698751223299),
				description: '',
				createdTimestamp: new Date(1698751223299),
				businessPartner: valueObject.businessPartner!,
				createdBy: createdUser,
				updatedBy: createdUser,
				updated: new Date(1688636248131),
				invoiceLines: [
					{
						clientId: 1000000,
						orgId: 1000000,
						uuid: randomUUID(),
						created: '2023-10-31 02:20:23',
						isActive: true,
						createdTimestamp: new Date(1698751223383),
						invoiceId: 1838261,
						price: 30000,
						quantity: 1,
						lineNetAmount: 30000,
						product: product1,
						attributeSetInstance: null as unknown as AttributeSetInstance,
						businessPartnerSpecificPayerInformationList: [],
						orderLine: { uuid: orderLine1Uuid } as OrderLine,
						charge: null as unknown as Charge,
						description: '',
						createdBy: createdUser,
						updatedBy: createdUser,
						updated: new Date(1688636248131),
					},
					{
						clientId: 1000000,
						orgId: 1000000,
						uuid: '49cd1fa7-33db-4043-9ede-93f3296b80dd',
						created: '2023-11-01 11:56:45',
						isActive: true,
						createdTimestamp: new Date(1698829005952),
						invoiceId: 1838261,
						price: 200,
						quantity: 1,
						lineNetAmount: 200,
						product: product2,
						attributeSetInstance: null as unknown as AttributeSetInstance,
						businessPartnerSpecificPayerInformationList: [],
						orderLine: { uuid: orderLine2Uuid } as OrderLine,
						charge: null as unknown as Charge,
						description: '',
						createdBy: createdUser,
						updatedBy: createdUser,
						updated: new Date(1688636248131),
					},
				],
				docStatus: 'DR',
				dateInvoiced: '2023-10-31',
				grandTotal: 30200,
				paymentRule: 'P',
				voidedReason: {} as VoidedReason,
				isSalesOrderTransaction: true,
				documentTypeTarget: customerInvoiceDocumentType,
				order: { uuid: orderUuid } as Order,
			},
		],
	};
	valueObject.visit = await visitApi.save(valueObject, visit as Visit);

	valueObject.stepName = 'Remove order & invoice lines';
	valueObject.visit.orders[0].orderLines = valueObject.visit.orders[0].orderLines.filter(
		(orderLine) => orderLine.uuid === orderLine1Uuid,
	);
	valueObject.visit.invoices[0].invoiceLines = valueObject.visit.invoices[0].invoiceLines.filter(
		(invoiceLine) => invoiceLine.orderLine.uuid === orderLine1Uuid,
	);
	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit).toBeTruthy();
	expect(valueObject.visit.orders).toHaveLength(1);
	expect(valueObject.visit.orders[0].orderLines).toHaveLength(1);
	expect(valueObject.visit.invoices).toHaveLength(1);
	expect(valueObject.visit.invoices[0].invoiceLines).toHaveLength(1);
});

test('can delete encounters', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	const clinicalVitalsEncounterTypeWindow = (
		await encounterTypeWindowApi.get(valueObject, 0, 10, undefined, undefined)
	).results.find((result) => result.window.uuid == CLINICAL_VITALS_WINDOW_UUID);
	const fields = clinicalVitalsEncounterTypeWindow?.window.tabs[0].fields;

	const codedDiagnosis = (await codedDiagnosisApi.get(valueObject)).results[0];
	const uncodedDiagnosisValue = 'Test uncoded diagnosis';
	const encounter: Partial<Encounter> = {
		encounterType: clinicalVitalsEncounterTypeWindow?.encounterType,
		observations: [
			{
				value: '200',
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

	// add first encounter
	valueObject.visit!.encounters!.push(encounter as Encounter);
	// add second encounter
	valueObject.visit!.encounters!.push(encounter as Encounter);

	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters).toHaveLength(2);

	valueObject.stepName = 'Delete encounter';
	const encounterUuidsToDelete = valueObject.visit.encounters.map((encounter) => encounter.uuid);
	expect(await encounterApi.delete(valueObject, encounterUuidsToDelete)).toBe(true);
	expect(
		(
			await encounterApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ bh_encounter_uu: { $in: encounterUuidsToDelete } }),
			)
		).results,
	).toHaveLength(0);
});

test('expression functions work in sorting', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit 1';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-1);
	await createVisit(valueObject);
	const visit1 = valueObject.visit!;

	valueObject.stepName = 'Create visit 2';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(1);
	valueObject.date!.setHours(12);
	await createVisit(valueObject);
	const visit2 = valueObject.visit!;

	valueObject.stepName = 'Create visit 3';
	valueObject.documentAction = undefined;
	valueObject.date!.setHours(11);
	await createVisit(valueObject);
	const visit3 = valueObject.visit!;

	const sortedVisits = (
		await visitApi.get(
			valueObject,
			undefined,
			undefined,
			JSON.stringify([
				['$date(bh_visitdate)', 'DESC'],
				['bh_visitdate', 'ASC'],
			]),
			JSON.stringify({ bh_visit_uu: { $in: [visit1.uuid, visit2.uuid, visit3.uuid] } }),
		)
	).results;
	expect(sortedVisits).toHaveLength(3);
	expect(sortedVisits[0].uuid).toBe(visit3.uuid);
	expect(sortedVisits[1].uuid).toBe(visit2.uuid);
	expect(sortedVisits[2].uuid).toBe(visit1.uuid);
});

test('lab diagnostic fields', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	const labDiagnosticEncounterTypeWindow = (
		await encounterTypeWindowApi.get(valueObject, 0, 10, undefined, undefined)
	).results.find((result) => result.window.uuid == LAB_DIAGNOSTICS_WINDOW_UUID);
	const fields = labDiagnosticEncounterTypeWindow?.window.tabs[0].fields;

	const LAB_NOTES_VALUE = 'Add a lab note';
	const CONCEPT_RESULT_1 = 'Result 1';

	const concepts = (await conceptApi.get(valueObject)).results;
	const encounter: Partial<Encounter> = {
		encounterType: labDiagnosticEncounterTypeWindow?.encounterType,
		observations: [
			{
				value: LAB_NOTES_VALUE,
				field: fields?.filter((field) => field.uuid == LAB_NOTES_FIELD_UUID)[0],
			} as Observation,
		],
		encounterDiagnostics: [
			{
				lineNo: 1,
				concept: { uuid: concepts[0]?.uuid },
				value: CONCEPT_RESULT_1,
				status: 'C',
			} as EncounterDiagnostic,
		],
	};

	valueObject.visit!.encounters!.push(encounter as Encounter);

	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.encounters).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations).toHaveLength(1);
	expect(valueObject.visit.encounters[0].observations[0].value).toBe(LAB_NOTES_VALUE);
	expect(valueObject.visit.encounters[0].encounterDiagnostics).toHaveLength(1);
	expect(valueObject.visit.encounters[0].encounterDiagnostics[0].value).toBe(CONCEPT_RESULT_1);
	expect(valueObject.visit.encounters[0].encounterDiagnostics[0].concept.uuid).toBe(concepts[0].uuid);
});
