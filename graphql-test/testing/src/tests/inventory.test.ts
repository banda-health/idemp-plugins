import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeInventory, referenceUuid } from '../models';
import { createBusinessPartner, createInventory, createOrder, createProduct } from '../utils';
import { Ad_Ref_ListGetDocument, M_InventorySaveDocument, M_StorageOnHandGetDocument } from '../__generated__/graphql';

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

test('inventory can be created with all update reasons', async () => {
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

	const updateReasonList = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				Filter: JSON.stringify({
					ad_reference: { ad_reference_uu: referenceUuid.BH_UPDATE_REASON },
				}),
			},
		})
	).data.AD_Ref_ListGet.Results;
	expect(updateReasonList).toBeDefined();
	expect(updateReasonList.length).toBeTruthy();

	valueObject.stepName = 'Create inventory';
	valueObject.quantity = 1;
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.MaterialPhysicalInventory,
		{ inventory: documentSubTypeInventory.PhysicalInventory },
		false,
		false,
		false,
	);
	await createInventory(valueObject);

	for (const updateReason of updateReasonList) {
		const savedData = (await mutate(valueObject)({
			mutation: M_InventorySaveDocument,
			variables: { Entity: { bh_update_reason: { UU: updateReason.UU }, UU: valueObject.inventory!.UU } },
		}))?.data?.M_InventorySave;
		expect(savedData?.bh_update_reason?.UU).toBe(updateReason.UU);
	}
});
