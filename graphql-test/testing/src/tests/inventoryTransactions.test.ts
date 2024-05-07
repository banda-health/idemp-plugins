import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { createBusinessPartner, createInvoice, createOrder, createPayment, createProduct, createVisit } from '../utils';
import { Bh_VisitProcessDocument, InventoryTransactionGetDocument } from '../__generated__/graphql';

test('re-opened visits appear in the list', async () => {
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
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
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
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const initialInventoryTransactions = (
		await query(valueObject)({
			query: InventoryTransactionGetDocument,
			variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product?.UU } }) },
		})
	).data.InventoryTransactionGet.Results;
	expect(initialInventoryTransactions).toHaveLength(2);

	valueObject.stepName = 'Reactivate visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: InventoryTransactionGetDocument,
				variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product?.UU } }) },
			})
		).data.InventoryTransactionGet.Results,
	).toHaveLength(4);
});
