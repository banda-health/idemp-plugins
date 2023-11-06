import { storageOnHandApi } from '../api';
import { documentAction, documentBaseType } from '../models';
import { createBusinessPartner, createInventory, createOrder, createProduct } from '../utils';

test('inventory count can be performed', async () => {
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

	valueObject.stepName = 'Create inventory';
	valueObject.quantity = 2;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialPhysicalInventory, null, false, false, false);
	await createInventory(valueObject);

	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ m_product: { m_product_uu: valueObject.product!.uuid } }),
			)
		).results.reduce((total, storageOnHand) => total + storageOnHand.quantityOnHand, 0),
	).toBe(2);
});
