import { movementApi, storageOnHandApi, warehouseApi } from '../api';
import { documentAction, documentStatus } from '../models';
import { Movement, MovementLine } from '../types/org.bandahealth.idempiere.rest';
import { createProduct, createPurchaseOrder, createVendor } from '../utils';

test('can move inventory between warehouses', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.quantity = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create movement';
	const differentWarehouse = (await warehouseApi.get(valueObject)).results.find(
		(warehouse) => warehouse.uuid !== valueObject.warehouse?.uuid,
	);
	const movement = {
		fromWarehouse: valueObject.warehouse,
		toWarehouse: differentWarehouse,
		movementDate: valueObject.date?.toISOString(),
		description: valueObject.getStepMessageLong(),
		user: valueObject.user,
	} as Movement;
	const movementLine = {
		movementQuantity: 75,
		product: valueObject.product,
		locator: valueObject.warehouse?.locators[0],
		locatorTo: differentWarehouse?.locators[0],
	} as MovementLine;
	movement.movementLines = [movementLine];
	const savedMovement = await movementApi.saveAndProcess(valueObject, movement, documentAction.Complete);
	expect(savedMovement.docStatus).toBe(documentStatus.Completed);

	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({
					m_product: { m_product_uu: valueObject.product!.uuid },
					m_locator: { m_locator_uu: valueObject.warehouse?.locators[0]?.uuid },
				}),
			)
		).results.reduce((total, storageOnHand) => total + storageOnHand.quantityOnHand, 0),
	).toBe(25);
	expect(
		(
			await storageOnHandApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({
					m_product: { m_product_uu: valueObject.product!.uuid },
					m_locator: { m_locator_uu: differentWarehouse?.locators[0]?.uuid },
				}),
			)
		).results.reduce((total, storageOnHand) => total + storageOnHand.quantityOnHand, 0),
	).toBe(75);
});
