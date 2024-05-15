import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentStatus, documentSubTypeSalesOrder } from '../models';
import { RoleName } from '../types/roleName';
import { createBusinessPartner, createOrder, createProduct, getDateOffset } from '../utils';
import {
	C_BPartnerGetDocument,
	C_OrderGetDocument,
	C_OrderLineSaveDocument,
	C_OrderProcessDocument,
	M_AttributeSetGetDocument,
	M_AttributeSetInstanceSaveDocument,
	M_ProductGetDocument,
	M_ProductSaveDocument,
	M_StorageOnHandGetDocument,
} from '../__generated__/graphql';

xtest(`information saved correctly after completing a purchase order`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

test(`vendor open balance is 0 after purchase order completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
			})
		).data.C_BPartnerGet.Results[0].TotalOpenBalance,
	).toBe(0);
});

test(`invalid orders can be completed`, async () => {
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

	valueObject.stepName = 'Create expiring attribute set instance';
	const expiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: {
					GuaranteeDate: getDateOffset(new Date(), 365).getTime(),
					M_AttributeSet: { UU: expiringAttributeSet.UU },
				},
			},
		})
	).data!.M_AttributeSetInstanceSave!;
	expect(expiringAttributeSetInstance).toBeTruthy();

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	try {
		await createOrder(valueObject);
		expect(true).toBe(false);
	} catch {}
	// uncomment for iDempeire 8.2+
	// expect((await visitApi.getByUuid(valueObject, valueObject.order!.uuid)).docStatus).toBe(documentStatus.Invalid);

	valueObject.stepName = 'Add expiration and complete PO';
	await mutate(valueObject)({
		mutation: C_OrderLineSaveDocument,
		variables: {
			Entity: {
				UU: valueObject.orderLine!.UU,
				M_AttributeSetInstance: { UU: expiringAttributeSetInstance.UU },
			},
		},
	});
	const savedOrder = (
		await mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Complete },
		})
	).data?.C_OrderProcess;
	expect(savedOrder?.DocStatus.Value).toBe(documentStatus.Completed);
});

test(`completed order can't be closed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicAdmin);

	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);
	expect(valueObject.order?.DocStatus.Value).toBe(documentStatus.Completed);
	await expect(
		mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Close },
		}),
	).rejects.toBeTruthy();
});

test(`can't void an order after product has been sold`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create a business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);
	expect(valueObject.order?.DocStatus.Value).toBe(documentStatus.Completed);
	const purchaseOrder = valueObject.order!;

	// Confirm quantity was received
	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product?.UU } }) },
			})
		).data.M_StorageOnHandGet.Results.reduce(
			(totalQuantity, storageOnHand) => storageOnHand.QtyOnHand + totalQuantity,
			0,
		),
	).toBe(1);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	// Confirm everything was sold
	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product?.UU } }) },
			})
		).data.M_StorageOnHandGet.Results.reduce(
			(totalQuantity, storageOnHand) => storageOnHand.QtyOnHand + totalQuantity,
			0,
		),
	).toBe(0);

	await expect(
		mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: purchaseOrder.UU, DocumentAction: documentAction.Void },
		}),
	).rejects.toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_OrderGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_order_uu: purchaseOrder.UU }) },
			})
		).data.C_OrderGet.Results[0].DocStatus.Value,
	).toBe(documentStatus.Completed);

	// Confirm quantity didn't go negative
	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product?.UU } }) },
			})
		).data.M_StorageOnHandGet.Results.reduce(
			(totalQuantity, storageOnHand) => storageOnHand.QtyOnHand + totalQuantity,
			0,
		),
	).toBe(0);
});

test(`changing a price on an old PO does not change last buying price for product`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	const expiringAttributeSet = (
		await query(valueObject)({
			query: M_AttributeSetGetDocument,
			variables: { Filter: JSON.stringify({ isguaranteedate: true }) },
		})
	).data.M_AttributeSetGet.Results[0];
	valueObject.setSalesPrice(200);
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { Entity: { UU: valueObject.product!.UU, M_AttributeSet: { UU: expiringAttributeSet.UU } } },
		})
	).data?.M_ProductSave;

	valueObject.stepName = 'Create expiring attribute set instance';
	const expiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: {
					GuaranteeDate: getDateOffset(new Date(), 365).getTime(),
					M_AttributeSet: { UU: expiringAttributeSet.UU },
				},
			},
		})
	).data!.M_AttributeSetInstanceSave!;
	expect(expiringAttributeSetInstance).toBeTruthy();

	valueObject.stepName = 'Create first purchase order';
	valueObject.documentAction = documentAction.Complete;
	valueObject.attributeSetInstance = expiringAttributeSetInstance;
	valueObject.setPurchasePrice(110);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);
	let firstPO = valueObject.order!;

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product?.UU }) },
			})
		).data.M_ProductGet.Results[0].LastPurchasePrice,
	).toBe(110);

	valueObject.stepName = 'Create second purchase order';
	valueObject.documentAction = documentAction.Complete;
	valueObject.attributeSetInstance = expiringAttributeSetInstance;
	valueObject.setDateOffset(1);
	valueObject.setPurchasePrice(120);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product?.UU }) },
			})
		).data.M_ProductGet.Results[0].LastPurchasePrice,
	).toBe(120);

	valueObject.stepName = 'Re-open first PO';
	firstPO = (
		await mutate(valueObject)({
			mutation: C_OrderProcessDocument,
			variables: { UU: firstPO.UU, DocumentAction: documentAction.ReActivate },
		})
	).data!.C_OrderProcess!;
	expect(firstPO).toBeTruthy();

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product?.UU }) },
			})
		).data.M_ProductGet.Results[0].LastPurchasePrice,
	).toBe(120);

	valueObject.stepName = 'Re-complete first PO';
	await mutate(valueObject)({
		mutation: C_OrderLineSaveDocument,
		variables: { Entity: { UU: valueObject.orderLine!.UU, Price: 115 } },
	});
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { UU: firstPO.UU, DocumentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product?.UU }) },
			})
		).data.M_ProductGet.Results[0].LastPurchasePrice,
	).toBe(120);
});

test(`reactivating a PO resets the quantity correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	const expiringAttributeSet = (
		await query(valueObject)({
			query: M_AttributeSetGetDocument,
			variables: { Filter: JSON.stringify({ isguaranteedate: true }) },
		})
	).data.M_AttributeSetGet.Results[0];
	valueObject.setSalesPrice(200);
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { Entity: { UU: valueObject.product!.UU, M_AttributeSet: { UU: expiringAttributeSet.UU } } },
		})
	).data?.M_ProductSave;

	valueObject.stepName = 'Create expiring attribute set instance';
	const expiringAttributeSetInstance = (
		await mutate(valueObject)({
			mutation: M_AttributeSetInstanceSaveDocument,
			variables: {
				Entity: {
					GuaranteeDate: getDateOffset(new Date(), 365).getTime(),
					M_AttributeSet: { UU: expiringAttributeSet.UU },
				},
			},
		})
	).data!.M_AttributeSetInstanceSave!;
	expect(expiringAttributeSetInstance).toBeTruthy();

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	valueObject.attributeSetInstance = expiringAttributeSetInstance;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
			})
		).data.M_ProductGet.Results[0].TotalQuantity,
	).toBe(1);

	valueObject.stepName = 'Re-open first PO';

	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.ReActivate },
	});

	expect(
		(
			await query(valueObject)({
				query: M_ProductGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
			})
		).data.M_ProductGet.Results[0].TotalQuantity,
	).toBe(0);
});
