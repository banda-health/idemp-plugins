import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentStatus } from '../models';
import { createBusinessPartner, createOrder, createProduct } from '../utils';
import {
	M_MovementSaveWithMovementLinesAndProcessDocument,
	M_StorageOnHandGetDocument,
	M_WarehouseGetDocument,
} from '../__generated__/graphql';

test('can move inventory between warehouses', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.quantity = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create movement';
	const differentWarehouse = (
		await query(valueObject)({ query: M_WarehouseGetDocument })
	).data.M_WarehouseGet.results.find((warehouse) => warehouse.UUID !== valueObject.warehouse?.UUID);
	await valueObject.setDocumentBaseType(documentBaseType.MaterialMovement, null, false, false, false);
	const movementUuid = v4();
	const { data: savedData } = await mutate(valueObject)({
		mutation: M_MovementSaveWithMovementLinesAndProcessDocument,
		variables: {
			M_Movement: {
				UUID: movementUuid,
				AD_Org: valueObject.organization ? { UUID: valueObject.organization.UUID } : undefined,
				BH_From_Warehouse: { UUID: valueObject.warehouse!.UUID },
				BH_To_Warehouse: { UUID: differentWarehouse!.UUID },
				Description: valueObject.getStepMessageLong(),
				C_DocType: { UUID: valueObject.documentType!.UUID },
				MovementDate: valueObject.date?.getTime(),
				IsApproved: true,
			},
			M_MovementLine: {
				M_Movement: { UUID: movementUuid },
				MovementQty: 75,
				M_Product: { UUID: valueObject.product!.UUID },
				M_Locator: { UUID: valueObject.warehouse!.M_Locators![0].UUID },
				M_LocatorTo: { UUID: differentWarehouse!.M_Locators![0].UUID },
			},
			uuid: movementUuid,
			documentAction: documentAction.Complete,
		},
	});
	expect(savedData?.M_MovementProcess?.DocStatus.Value).toBe(documentStatus.Completed);

	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: {
					filter: JSON.stringify({
						m_product: { m_product_uu: valueObject.product!.UUID },
						m_locator: { m_locator_uu: valueObject.warehouse?.M_Locators?.[0]?.UUID },
					}),
				},
			})
		).data.M_StorageOnHandGet.results.reduce((total, storageOnHand) => total + storageOnHand.QtyOnHand, 0),
	).toBe(25);
	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: {
					filter: JSON.stringify({
						m_product: { m_product_uu: valueObject.product!.UUID },
						m_locator: { m_locator_uu: differentWarehouse?.M_Locators?.[0]?.UUID },
					}),
				},
			})
		).data.M_StorageOnHandGet.results.reduce((total, storageOnHand) => total + storageOnHand.QtyOnHand, 0),
	).toBe(75);
});
