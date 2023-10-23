import { productApi, serviceApi } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { Product, Service } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createOrder, createProduct } from '../utils';

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
