import { Bh_VisitProcessDocument, C_PaymentSaveDocument, PaymentTrailGetDocument } from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPatient,
	createPayment,
	createProduct,
	createVisit,
} from '../utils';

test('everything is shown', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.quantity = 5;
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
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	valueObject.quantity = 1;
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
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const paymentTrail = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: PaymentTrailGetDocument,
			variables: {
				C_BPartner_UU: valueObject.businessPartner!.UU,
				Size: 1,
				Sort: JSON.stringify([
					['transaction_date', 'desc'],
					['updated', 'desc'],
				]),
			},
		})
	).data.PaymentTrailGet.Results;
	expect(paymentTrail[0].OpenBalance).toBe(0);
	expect(paymentTrail[0].Credits).toBe(100);
	expect(paymentTrail[0].Debits).toBe(100);

	valueObject.stepName = 'Reactivate visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				fetchPolicy: 'network-only',
				query: PaymentTrailGetDocument,
				variables: {
					C_BPartner_UU: valueObject.businessPartner!.UU,
				},
			})
		).data.PaymentTrailGet.Results,
	).toHaveLength(1);
});

test('filtering by visits', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.quantity = 5;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create first visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create first order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	valueObject.quantity = 1;
	await createOrder(valueObject);

	valueObject.stepName = 'Create first invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create first payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete first visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});
	const firstVisit = valueObject.visit!;

	valueObject.stepName = 'Create second visit';
	valueObject.date = new Date();
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create second order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	valueObject.quantity = 1;
	await createOrder(valueObject);

	valueObject.stepName = 'Create second invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Complete second visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	let paymentTrail = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: PaymentTrailGetDocument,
			variables: {
				C_BPartner_UU: valueObject.businessPartner!.UU,
				Filter: JSON.stringify({ bh_visit: { bh_visit_uu: firstVisit.UU } }),
			},
		})
	).data.PaymentTrailGet.Results;
	expect(paymentTrail[0].OpenBalance).toBe(0);
	expect(paymentTrail[0].Credits).toBe(100);
	expect(paymentTrail[0].Debits).toBe(100);

	paymentTrail = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: PaymentTrailGetDocument,
			variables: {
				C_BPartner_UU: valueObject.businessPartner!.UU,
				Filter: JSON.stringify({ bh_visit: { bh_visit_uu: valueObject.visit!.UU } }),
			},
		})
	).data.PaymentTrailGet.Results;
	expect(paymentTrail[0].OpenBalance).toBe(100);
	expect(paymentTrail[0].Credits).toBe(0);
	expect(paymentTrail[0].Debits).toBe(100);
});

test('scheduled payments are not included in total balance calculation', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createPatient(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.quantity = 5;
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
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	valueObject.quantity = 1;
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	valueObject.stepName = 'Schedule payment';
	valueObject.visit = undefined;
	valueObject.documentAction = documentAction.Prepare;
	await createPayment(valueObject);
	await mutate(valueObject)({
		mutation: C_PaymentSaveDocument,
		variables: {
			Entity: { PayAmt: 100, Scheduled: true, UU: valueObject.payment!.UU },
		},
	});

	const paymentTrail = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: PaymentTrailGetDocument,
			variables: {
				C_BPartner_UU: valueObject.businessPartner!.UU,
				Size: 1,
				Sort: JSON.stringify([
					['transaction_date', 'desc'],
					['updated', 'desc'],
				]),
			},
		})
	).data.PaymentTrailGet.Results;
	expect(paymentTrail[0].OpenBalance).toBeNull();
	expect(paymentTrail[0].Credits).toBe(100);
	expect(paymentTrail[0].Debits).toBe(0);
});
