import axios, { AxiosError } from 'axios';
import { randomUUID } from 'crypto';
import isEqual from 'lodash/isEqual';
import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import { businessPartnerApi, languageApi, referenceListApi, visitApi, voidedReasonApi } from '../api';
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
	Invoice,
	InvoiceLine,
	Order,
	OrderLine,
	Payment,
	PaymentType,
	ProcessInfoParameter,
	Visit,
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

test('re-opened visit returns voided/reversed payments', async () => {
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

test('voiding visit returns voided/reversed payments', async () => {
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

	const fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit!.uuid);
	expect(fetchedVisit.patient).toBeTruthy();
	expect(fetchedVisit.patient.lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(fetchedVisit.patient.totalVisits).toBe(1);
	expect(fetchedVisit.patient.nationalId).toBe(businessPartner.nationalId);
	expect(fetchedVisit.patient.occupation).toBe(businessPartner.occupation);
	expect(fetchedVisit.patient.nextOfKinName).toBe(businessPartner.nextOfKinName);
	expect(fetchedVisit.patient.nextOfKinContact).toBe(businessPartner.nextOfKinContact);
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
	expect(await visitApi.delete(valueObject, valueObject.visit.uuid)).toBe(true);
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
	valueObject.visit!.chiefComplaint = longChiefComplaint;

	valueObject.visit = await visitApi.save(valueObject, valueObject.visit!);
	expect(valueObject.visit.chiefComplaint).toBe(longChiefComplaint);
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
	const businessPartnerToUse = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'W'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = businessPartnerToUse.payerInformationFieldList.filter(
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
						charge: businessPartnerToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, value: 'Test' },
						],
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
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
	expect(isEqual(valueObject.visit, fetchedVisit)).toBeTruthy();

	valueObject.visit = await visitApi.saveAndProcess(valueObject, savedVisit, documentAction.Complete);
	fetchedVisit = await visitApi.getByUuid(valueObject, valueObject.visit.uuid);
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
	const businessPartnerToUse = (
		await businessPartnerApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bp_group: { bh_subtype: { $in: ['I', 'W'] } } }),
		)
	).results.filter((businessPartner) => businessPartner.payerInformationFieldList.length)[0];
	const payerInformationFieldToUse = businessPartnerToUse.payerInformationFieldList.filter(
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
						charge: businessPartnerToUse.businessPartnerGroup.associatedCustomerReceivablesCharge,
						quantity: 1,
						price: 50,
						businessPartnerSpecificPayerInformationList: [
							{ payerInformationFieldUuid: payerInformationFieldToUse.uuid, value: 'Test' },
						],
					} as InvoiceLine,
				],
				order: { uuid: orderUuid },
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

	expect(await visitApi.delete(valueObject, valueObject.visit!.uuid)).toBeTruthy();
});
