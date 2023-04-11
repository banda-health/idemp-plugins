import { attributeSetApi, attributeSetInstanceApi, productApi, receiveProductsApi, vendorsApi, visitApi } from '../api';
import { documentAction, documentStatus } from '../models';
import { AttributeSetInstance, Product, ReceiveProduct, VoidedReason } from '../types/org.bandahealth.idempiere.rest';
import { createProduct, createPurchaseOrder, createVendor, getDateOffset } from '../utils';

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
	await valueObject.login('Clinic Admin');

	valueObject.stepName = 'Create vendor';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);
	expect(valueObject.order.docStatus).toBe(documentStatus.Completed);
	try {
		await receiveProductsApi.process(valueObject, valueObject.order!.uuid, documentAction.Close);
		expect(true).toBe(false);
	} catch {
		expect(true).toBe(true);
	}
});
