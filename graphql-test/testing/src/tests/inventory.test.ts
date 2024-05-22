import { query } from '../api';
import { documentAction, documentBaseType, documentSubTypeInventory } from '../models';
import { createBusinessPartner, createInventory, createOrder, createProduct } from '../utils';
import { M_StorageOnHandGetDocument } from '../__generated__/graphql';

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
	await valueObject.setDocumentBaseType(
		documentBaseType.MaterialPhysicalInventory,
		{ inventory: documentSubTypeInventory.PhysicalInventory },
		false,
		false,
		false,
	);
	await createInventory(valueObject);

	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: { Filter: JSON.stringify({ m_product: { m_product_uu: valueObject.product!.UU } }) },
			})
		).data.M_StorageOnHandGet.Results.reduce((total, storageOnHand) => total + storageOnHand.QtyOnHand, 0),
	).toBe(2);
});
