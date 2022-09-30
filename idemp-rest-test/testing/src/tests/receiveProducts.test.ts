import { vendorsApi } from '../api';
import { documentAction } from '../models';
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
