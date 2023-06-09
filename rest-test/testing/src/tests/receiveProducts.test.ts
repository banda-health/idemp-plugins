import {
	attributeSetApi,
	attributeSetInstanceApi,
	productApi,
	receiveProductsApi,
	storageOnHandApi,
	vendorsApi,
} from '../api';
import { documentAction, documentBaseType, documentStatus, documentSubTypeSalesOrder } from '../models';
import { AttributeSetInstance, Product, ReceiveProduct, VoidedReason } from '../types/org.bandahealth.idempiere.rest';
import { RoleName } from '../types/roleName';
import {
	createBusinessPartner,
	createOrder,
	createProduct,
	createPurchaseOrder,
	createVendor,
	getDateOffset,
} from '../utils';

xtest(`information saved correctly after completing a purchase order`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

test(`vendor open balance is 0 after purchase order completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	expect((await vendorsApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

test(`invalid orders can be completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	const expiringAttributeSet = (
		await attributeSetApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ isguaranteedate: true }))
	).results[0];
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);
	valueObject.product!.attributeSet = expiringAttributeSet;
	valueObject.product = await productApi.save(valueObject, valueObject.product as Product);

	valueObject.stepName = 'Create expiring attribute set instance';
	let expiringAttributeSetInstance: Partial<AttributeSetInstance> = {
		guaranteeDate: getDateOffset(new Date(), 365),
		updateReason: {} as VoidedReason,
		attributeSet: expiringAttributeSet,
	};
	expiringAttributeSetInstance = await attributeSetInstanceApi.save(
		valueObject,
		expiringAttributeSetInstance as AttributeSetInstance,
	);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = undefined;
	await createPurchaseOrder(valueObject);
	let savedOrder: ReceiveProduct | undefined;
	try {
		let savedOrder = await receiveProductsApi.saveAndProcess(
			valueObject,
			valueObject.order as ReceiveProduct,
			documentAction.Complete,
		);
		expect(true).toBe(false);
	} catch {}
	// uncomment for iDempeire 8.2+
	// expect((await visitApi.getByUuid(valueObject, valueObject.order!.uuid)).docStatus).toBe(documentStatus.Invalid);

	valueObject.stepName = 'Add expiration and complete PO';
	valueObject.order!.orderLines[0].attributeSetInstance = expiringAttributeSetInstance as AttributeSetInstance;
	savedOrder = await receiveProductsApi.saveAndProcess(
		valueObject,
		valueObject.order as ReceiveProduct,
		documentAction.Complete,
	);
	expect(savedOrder.docStatus).toBe(documentStatus.Completed);
});

test(`completed order can't be closed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.ClinicAdmin);

	valueObject.stepName = 'Create vendor';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);
	expect(valueObject.order?.docStatus).toBe(documentStatus.Completed);
	try {
		await receiveProductsApi.process(valueObject, valueObject.order!.uuid, documentAction.Close);
		expect(true).toBe(false);
	} catch {
		expect(true).toBe(true);
	}
});

test(`can't void an order after product has been sold`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create a business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);
	expect(valueObject.order?.docStatus).toBe(documentStatus.Completed);
	const purchaseOrder = valueObject.order as ReceiveProduct;

	// Confirm quantity was received
	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
			)
		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
	).toBe(1);

	valueObject.stepName = 'Create another business partner for sales orders';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	// Confirm everything was sold
	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
			)
		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
	).toBe(0);

	await expect(receiveProductsApi.process(valueObject, purchaseOrder.uuid, documentAction.Void)).rejects.toBeTruthy();
	expect((await receiveProductsApi.getByUuid(valueObject, purchaseOrder.uuid)).docStatus).toBe(
		documentStatus.Completed,
	);

	// Confirm quantity didn't go negative
	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }),
			)
		).results.reduce((totalQuantity, storageOnHand) => storageOnHand.quantityOnHand + totalQuantity, 0),
	).toBe(0);
});
