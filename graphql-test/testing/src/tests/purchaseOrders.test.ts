// import isEqual from 'lodash/isEqual';
// import {
// 	attributeSetApi,
// 	attributeSetInstanceApi,
// 	businessPartnerApi,
// 	orderApi,
// 	productApi,
// 	storageOnHandApi,
// } from '../api';
// import { documentAction, documentBaseType, documentStatus, documentSubTypeSalesOrder } from '../models';
// import { AttributeSetInstance, Product, VoidedReason } from '../types/org.bandahealth.idempiere.rest';
// import { RoleName } from '../types/roleName';
// import { createBusinessPartner, createOrder, createProduct, getDateOffset } from '../utils';

// xtest(`information saved correctly after completing a purchase order`, async () => {
// 	await globalThis.__VALUE_OBJECT__.login();
// });

// test(`vendor open balance is 0 after purchase order completed`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	expect((await businessPartnerApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
// });

// test(`invalid orders can be completed`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	try {
// 		await createOrder(valueObject);
// 		expect(true).toBe(false);
// 	} catch {}
// 	// uncomment for iDempeire 8.2+
// 	// expect((await visitApi.getByUuid(valueObject, valueObject.order!.uuid)).docStatus).toBe(documentStatus.Invalid);

// 	valueObject.stepName = 'Add expiration and complete PO';
// 	valueObject.order!.orderLines[0].attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	const savedOrder = await orderApi.saveAndProcess(valueObject, valueObject.order!, documentAction.Complete);
// 	expect(savedOrder.docStatus).toBe(documentStatus.Completed);
// });

// test(`completed order can't be closed`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login(RoleName.ClinicAdmin);

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	expect(valueObject.order?.docStatus).toBe(documentStatus.Completed);
// 	try {
// 		await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.Close);
// 		expect(true).toBe(false);
// 	} catch {
// 		expect(true).toBe(true);
// 	}
// });

// test(`can't void an order after product has been sold`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create a business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	expect(valueObject.order?.docStatus).toBe(documentStatus.Completed);
// 	const purchaseOrder = valueObject.order!;

// 	// Confirm quantity was received
// 	expect(
// 		(
// 			await storageOnHandApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
// 			)
// 		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
// 	).toBe(1);

// 	valueObject.stepName = 'Create sales order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(
// 		documentBaseType.SalesOrder,
// 		documentSubTypeSalesOrder.WarehouseOrder,
// 		true,
// 		false,
// 		false,
// 	);
// 	await createOrder(valueObject);

// 	// Confirm everything was sold
// 	expect(
// 		(
// 			await storageOnHandApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
// 			)
// 		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
// 	).toBe(0);

// 	await expect(orderApi.process(valueObject, purchaseOrder.uuid, documentAction.Void)).rejects.toBeTruthy();
// 	expect((await orderApi.getByUuid(valueObject, purchaseOrder.uuid)).docStatus).toBe(documentStatus.Completed);

// 	// Confirm quantity didn't go negative
// 	expect(
// 		(
// 			await storageOnHandApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
// 			)
// 		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
// 	).toBe(0);
// });

// test(`save returns the same thing as getByUuid`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	valueObject.order!.orderLines[0].attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	const savedOrder = await orderApi.save(valueObject, valueObject.order!);
// 	const fetchedOrder = await orderApi.getByUuid(valueObject, valueObject.order!.uuid);
// 	expect(isEqual(savedOrder, fetchedOrder)).toBeTruthy();
// });

// test(`process returns the same thing as getByUuid`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	valueObject.order!.orderLines[0].attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	valueObject.order = await orderApi.save(valueObject, valueObject.order!);
// 	const processedOrder = await orderApi.process(valueObject, valueObject.order.uuid, documentAction.Complete);
// 	const fetchedOrder = await orderApi.getByUuid(valueObject, valueObject.order!.uuid);
// 	expect(isEqual(processedOrder, fetchedOrder)).toBeTruthy();
// });

// test(`saveAndProcess returns the same thing as getByUuid`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create vendor';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	valueObject.order!.orderLines[0].attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	const savedOrder = await orderApi.saveAndProcess(valueObject, valueObject.order!, documentAction.Complete);
// 	const fetchedOrder = await orderApi.getByUuid(valueObject, valueObject.order!.uuid);
// 	expect(isEqual(savedOrder, fetchedOrder)).toBeTruthy();
// });

// test(`changing a price on an old PO does not change last buying price for product`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.setSalesPrice(200);
// 	valueObject.setPurchasePrice(100);
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create first purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	valueObject.attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	valueObject.setPurchasePrice(110);
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);
// 	let firstPO = valueObject.order!;

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).buyPrice).toBe(110);

// 	valueObject.stepName = 'Create second purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	valueObject.attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	valueObject.setDateOffset(1);
// 	valueObject.setPurchasePrice(120);
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).buyPrice).toBe(120);

// 	valueObject.stepName = 'Re-open first PO';
// 	firstPO = await orderApi.process(valueObject, firstPO.uuid, documentAction.ReActivate);

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).buyPrice).toBe(120);

// 	valueObject.stepName = 'Re-complete first PO';
// 	firstPO.orderLines[0].price = 115;
// 	await orderApi.saveAndProcess(valueObject, firstPO, documentAction.Complete);

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).buyPrice).toBe(120);
// });

// test(`reactivating a PO resets the quantity correctly`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	const expiringAttributeSet = (
// 		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
// 	).results[0];
// 	valueObject.setSalesPrice(200);
// 	valueObject.setPurchasePrice(100);
// 	await createProduct(valueObject);
// 	valueObject.product!.attributeSet = expiringAttributeSet;
// 	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

// 	valueObject.stepName = 'Create expiring attribute set instance';
// 	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
// 		guaranteeDate: getDateOffset(new Date(), 365),
// 		updateReason: {} as VoidedReason,
// 		attributeSet: expiringAttributeSet,
// 	};
// 	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
// 		valueObject,
// 		expiringAttributeSetInstance as AttributeSetInstance,
// 	);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	valueObject.attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).totalQuantity).toBe(1);

// 	valueObject.stepName = 'Re-open first PO';
// 	await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.ReActivate);

// 	expect((await productApi.getByUuid(valueObject, valueObject.product!.uuid)).totalQuantity).toBe(0);
// });

export {};
