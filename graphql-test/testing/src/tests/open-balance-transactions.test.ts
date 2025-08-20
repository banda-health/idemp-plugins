import {
	Bh_VisitProcessDocument,
	C_PaymentProcessDocument,
	OpenBalanceTransactionGetDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import {
	createBusinessPartner,
	createCharge,
	createInvoice,
	createOrder,
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

	const transactions = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: OpenBalanceTransactionGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Size: 2,
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.OpenBalanceTransactionGet.Results;
	expect(transactions[0].OpenBalance).toBe(0);
	expect(transactions[0].Amount).toBe(-100);
	expect(transactions[1].OpenBalance).toBe(100);
	expect(transactions[1].Amount).toBe(100);

	valueObject.stepName = 'Reactivate visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				fetchPolicy: 'network-only',
				query: OpenBalanceTransactionGetDocument,
				variables: {
					Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				},
			})
		).data.OpenBalanceTransactionGet.Results,
	).toHaveLength(4);
});

test('voided transactions are not included in the open balance calculation', async () => {
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

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Void payment';
	await mutate(valueObject)({
		mutation: C_PaymentProcessDocument,
		variables: { UU: valueObject.payment!.UU, DocumentAction: documentAction.ReverseAccrual },
	});

	const transactions = (
		await query(valueObject)({
			fetchPolicy: 'network-only',
			query: OpenBalanceTransactionGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Sort: JSON.stringify([['date', 'desc']]),
			},
		})
	).data.OpenBalanceTransactionGet.Results;
	expect(transactions.some((transaction) => transaction.OpenBalance === null)).toBeTruthy();
});
