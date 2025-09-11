import {
	C_OrderLineSaveDocument,
	C_OrderProcessDocument,
	M_AttributeSetGetDocument,
	M_AttributeSetInstanceSaveDocument,
	M_ProductSaveDocument,
	M_StorageOnHandGetDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType } from '../models';
import {
	createBusinessPartner,
	createInOutFromOrder,
	createOrder,
	createProduct,
	formatApiDate,
	getDateOffset,
} from '../utils';

test('can sort by ASI guarantee date', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	const expiringAttributeSet = (
		await query(valueObject)({
			query: M_AttributeSetGetDocument,
			variables: { Filter: JSON.stringify({ isguaranteedate: true }) },
		})
	).data.M_AttributeSetGet.Results[0];
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { Entity: { UU: valueObject.product!.UU, M_AttributeSet: { UU: expiringAttributeSet.UU } } },
		})
	).data?.M_ProductSave;

	valueObject.stepName = 'Create first expiring attribute set instance';
	const lateExpiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: {
					GuaranteeDate: formatApiDate(getDateOffset(new Date(), 730)),
					M_AttributeSet: { UU: expiringAttributeSet.UU },
				},
			},
		})
	).data!.M_AttributeSetInstanceSave!;

	valueObject.stepName = 'Create first purchase order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Add expiration and complete first PO';
	await mutate(valueObject)({
		mutation: C_OrderLineSaveDocument,
		variables: {
			Entity: {
				UU: valueObject.orderLine!.UU,
				M_AttributeSetInstance: { UU: lateExpiringAttributeSetInstance.UU },
			},
		},
	});
	(
		await mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Complete },
		})
	).data?.C_OrderProcess;
	await valueObject.refreshOrder();

	valueObject.stepName = 'Create first material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create second expiring attribute set instance';
	const earlyExpiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: {
					GuaranteeDate: formatApiDate(getDateOffset(new Date(), 365)),
					M_AttributeSet: { UU: expiringAttributeSet.UU },
				},
			},
		})
	).data!.M_AttributeSetInstanceSave!;

	valueObject.stepName = 'Create second purchase order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Add expiration and complete second PO';
	await mutate(valueObject)({
		mutation: C_OrderLineSaveDocument,
		variables: {
			Entity: {
				UU: valueObject.orderLine!.UU,
				M_AttributeSetInstance: { UU: earlyExpiringAttributeSetInstance.UU },
			},
		},
	});
	(
		await mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Complete },
		})
	).data?.C_OrderProcess;
	await valueObject.refreshOrder();

	valueObject.stepName = 'Create second material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	let sortedStorageOnHand = (
		await query(valueObject)({
			query: M_StorageOnHandGetDocument,
			variables: {
				Sort: JSON.stringify([['m_attributesetinstance.guaranteedate', 'asc']]),
				Filter: JSON.stringify({
					m_attributesetinstance: {
						m_attributesetinstance_uu: {
							$in: [lateExpiringAttributeSetInstance.UU, earlyExpiringAttributeSetInstance.UU],
						},
					},
				}),
			},
		})
	).data.M_StorageOnHandGet.Results;
	expect(sortedStorageOnHand).toHaveLength(2);
	expect(sortedStorageOnHand[0].M_AttributeSetInstance.UU).toBe(earlyExpiringAttributeSetInstance.UU);
	expect(sortedStorageOnHand[1].M_AttributeSetInstance.UU).toBe(lateExpiringAttributeSetInstance.UU);

	sortedStorageOnHand = (
		await query(valueObject)({
			query: M_StorageOnHandGetDocument,
			variables: {
				Sort: JSON.stringify([['m_attributesetinstance.guaranteedate', 'desc']]),
				Filter: JSON.stringify({
					m_attributesetinstance: {
						m_attributesetinstance_uu: {
							$in: [lateExpiringAttributeSetInstance.UU, earlyExpiringAttributeSetInstance.UU],
						},
					},
				}),
			},
		})
	).data.M_StorageOnHandGet.Results;
	expect(sortedStorageOnHand).toHaveLength(2);
	expect(sortedStorageOnHand[0].M_AttributeSetInstance.UU).toBe(lateExpiringAttributeSetInstance.UU);
	expect(sortedStorageOnHand[1].M_AttributeSetInstance.UU).toBe(earlyExpiringAttributeSetInstance.UU);
});
