import { receiveProductsApi, vendorsApi } from '../api';
import { documentAction, documentStatus } from '../models';
import { ReceiveProduct } from '../types/org.bandahealth.idempiere.rest';
import { createPatient, createProduct, createPurchaseOrder, createVendor, createVisit } from '../utils';

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
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = undefined;
	await createPurchaseOrder(valueObject);
	const orderLines = valueObject.order!.orderLines;
	valueObject.order!.orderLines = [];
	let savedOrder = await receiveProductsApi.saveAndProcess(
		valueObject,
		valueObject.order as ReceiveProduct,
		documentAction.Complete,
	);
	expect(savedOrder.docStatus).toBe(documentStatus.Invalid);

	valueObject.stepName = 'Add line and complete PO';
	valueObject.order!.orderLines = orderLines;
	savedOrder = await receiveProductsApi.saveAndProcess(
		valueObject,
		valueObject.order as ReceiveProduct,
		documentAction.Complete,
	);
	expect(savedOrder.docStatus).toBe(documentStatus.Completed);
});
