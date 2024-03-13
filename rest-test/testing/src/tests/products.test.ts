import { orderApi, productApi, serviceApi } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { Order, OrderLine, Product, Service } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createCharge, createOrder, createProduct } from '../utils';

test('inactive products and services not returned from the search method', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create product 2';
	let product2: Partial<Product> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: 'p2' + valueObject.getDynamicScenarioName(),
		productCategoryUuid: '',
		totalQuantity: valueObject.quantity,
		buyPrice: valueObject.purchaseStandardPrice ?? 1,
		sellPrice: valueObject.salesStandardPrice ?? 1,
	};
	valueObject.product = await productApi.save(valueObject, product2 as Product);
	product2 = valueObject.product!;

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create service 1';
	let service1: Partial<Service> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: 's1' + valueObject.getDynamicScenarioName(),
		productCategoryUuid: '',
	};
	service1 = await serviceApi.save(valueObject, service1 as Service);

	valueObject.stepName = 'Create service 2';
	let service2: Partial<Service> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: 's2' + valueObject.getDynamicScenarioName(),
		productCategoryUuid: '',
	};
	service2 = await serviceApi.save(valueObject, service2 as Service);

	let searchedResults = (await productApi.searchProductsAndServices(valueObject, valueObject.random.toString()))
		.results;
	expect(searchedResults).toHaveLength(4);
	expect(searchedResults.find((product) => product.name === product1.name)).toBeTruthy();
	expect(searchedResults.find((product) => product.name === product2.name)).toBeTruthy();
	expect(searchedResults.find((product) => product.name === service1.name)).toBeTruthy();
	expect(searchedResults.find((product) => product.name === service2.name)).toBeTruthy();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Sell first product so it can be deactivated';
	valueObject.documentAction = documentAction.Complete;
	valueObject.product = product1;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Deactivate a service and product';
	product1.isActive = false;
	await productApi.save(valueObject, product1);
	service1.isActive = false;
	await serviceApi.save(valueObject, service1 as Service);

	searchedResults = (await productApi.searchProductsAndServices(valueObject, valueObject.random.toString())).results;
	expect(searchedResults).toHaveLength(2);
	expect(searchedResults.find((product) => product.name === product1.name)).toBeFalsy();
	expect(searchedResults.find((product) => product.name === product2.name)).toBeTruthy();
	expect(searchedResults.find((product) => product.name === service1.name)).toBeFalsy();
	expect(searchedResults.find((product) => product.name === service2.name)).toBeTruthy();
});

test('search on page beyond returned results resets the page', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create product 2';
	valueObject.product = undefined;
	valueObject.setRandom();
	await createProduct(valueObject);

	expect((await productApi.get(valueObject, 0, 1)).pagingInfo.totalPages).toBeGreaterThan(1);
	const specificSearchResults = await productApi.get(
		valueObject,
		1,
		1,
		undefined,
		JSON.stringify({ name: product1.name }),
	);
	expect(specificSearchResults.results.length).toBe(1);
	expect(specificSearchResults.pagingInfo.page).toBe(0);
	expect(specificSearchResults.pagingInfo.totalPages).toBe(1);
});

test('buying price can only be updated on new items or items without completed POs', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);

	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(100);

	valueObject.product!.buyPrice = 110;
	valueObject.product = await productApi.save(valueObject, valueObject.product!);

	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(110);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Prepare;
	valueObject.setPurchasePrice(120);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.product = await productApi.getByUuid(valueObject, valueObject.product!.uuid);
	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(110);

	valueObject.stepName = 'Complete the PO';
	valueObject.order = await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.Complete);
	valueObject.product = await productApi.getByUuid(valueObject, valueObject.product!.uuid);
	expect(valueObject.product!.hasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.buyPrice).toBe(120);

	valueObject.stepName = 'Try to update the product buying price';
	valueObject.product!.buyPrice = 130;
	valueObject.product!.hasBeenPurchased = false;
	valueObject.product = await productApi.save(valueObject, valueObject.product!);

	expect(valueObject.product!.hasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.buyPrice).toBe(120);

	valueObject.stepName = 'Reactivate the PO';
	valueObject.order = await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.ReActivate);
	valueObject.product = await productApi.getByUuid(valueObject, valueObject.product!.uuid);
	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(110);

	valueObject.stepName = 'Try to update the product buying price again';
	valueObject.product!.buyPrice = 115;
	valueObject.product = await productApi.save(valueObject, valueObject.product!);
	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(115);

	valueObject.stepName = 'Re-complete the PO';
	valueObject.order = await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.Complete);
	valueObject.product = await productApi.getByUuid(valueObject, valueObject.product!.uuid);
	expect(valueObject.product!.hasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.buyPrice).toBe(120);
});

test('buying price can be updated when orders with charges exist', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);

	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);

	const order: Partial<Order> = {
		description: valueObject.getStepMessageLong(),
		dateOrdered: valueObject.date,
		businessPartner: valueObject.businessPartner,
		warehouse: valueObject.warehouse,
		orderLines: [
			{
				description: valueObject.getStepMessageLong(),
				charge: valueObject.charge,
				quantity: valueObject.quantity || 1,
				price: -150,
				attributeSetInstance: valueObject.attributeSetInstance,
			} as OrderLine,
		],
		isSalesOrderTransaction: valueObject.documentType!.isSalesTransaction,
		documentTypeTarget: valueObject.documentType,
	};
	valueObject.order = await orderApi.save(valueObject, order as Order);
	if (!valueObject.order) {
		throw new Error('Order not created');
	}
	valueObject.orderLine = valueObject.order!.orderLines[0];
	valueObject.order = await orderApi.process(valueObject, valueObject.order!.uuid, valueObject.documentAction!);
	if (!valueObject.order) {
		throw new Error('Order not processed');
	}

	valueObject.product = await productApi.getByUuid(valueObject, valueObject.product!.uuid);
	expect(valueObject.product!.hasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.buyPrice).toBe(100);
});
