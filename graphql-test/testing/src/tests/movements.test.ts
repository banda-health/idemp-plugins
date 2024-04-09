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
	).data.M_WarehouseGet.Results.find((warehouse) => warehouse.UU !== valueObject.warehouse?.UU);
	await valueObject.setDocumentBaseType(documentBaseType.MaterialMovement, null, false, false, false);
	const movementUuid = v4();
	const { data: savedData } = await mutate(valueObject)({
		mutation: M_MovementSaveWithMovementLinesAndProcessDocument,
		variables: {
			M_Movement: {
				UU: movementUuid,
				AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
				BH_From_Warehouse: { UU: valueObject.warehouse!.UU },
				BH_To_Warehouse: { UU: differentWarehouse!.UU },
				Description: valueObject.getStepMessageLong(),
				C_DocType: { UU: valueObject.documentType!.UU },
				MovementDate: valueObject.date?.getTime(),
				IsApproved: true,
			},
			M_MovementLine: {
				M_Movement: { UU: movementUuid },
				MovementQty: 75,
				M_Product: { UU: valueObject.product!.UU },
				M_Locator: { UU: valueObject.warehouse!.M_Locators![0].UU },
				M_LocatorTo: { UU: differentWarehouse!.M_Locators![0].UU },
			},
			UU: movementUuid,
			DocumentAction: documentAction.Complete,
		},
	});
	expect(savedData?.M_MovementProcess?.DocStatus.Value).toBe(documentStatus.Completed);

	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: {
					Filter: JSON.stringify({
						m_product: { m_product_uu: valueObject.product!.UU },
						m_locator: { m_locator_uu: valueObject.warehouse?.M_Locators?.[0]?.UU },
					}),
				},
			})
		).data.M_StorageOnHandGet.Results.reduce((total, storageOnHand) => total + storageOnHand.QtyOnHand, 0),
	).toBe(25);
	expect(
		(
			await query(valueObject)({
				query: M_StorageOnHandGetDocument,
				variables: {
					Filter: JSON.stringify({
						m_product: { m_product_uu: valueObject.product!.UU },
						m_locator: { m_locator_uu: differentWarehouse?.M_Locators?.[0]?.UU },
					}),
				},
			})
		).data.M_StorageOnHandGet.Results.reduce((total, storageOnHand) => total + storageOnHand.QtyOnHand, 0),
	).toBe(75);
});
