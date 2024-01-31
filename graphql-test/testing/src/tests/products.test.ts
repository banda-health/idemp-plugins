import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import {
	createBusinessPartner,
	createOrder,
	createProduct,
	getDefaultProductCategory,
	getDefaultTaxCategory,
} from '../utils';
import {
	C_OrderProcessDocument,
	C_UomGetDefaultDocument,
	M_ProductGetDocument,
	M_ProductSaveDocument,
	M_ProductSaveManyDocument,
} from '../__generated__/graphql';

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
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				entity: {
					AD_Org: { UUID: valueObject.organization!.UUID },
					Description: valueObject.getStepMessageLong(),
					Name: 'p2' + valueObject.getDynamicScenarioName(),
					BH_BuyPrice: valueObject.purchaseStandardPrice ?? 1,
					BH_SellPrice: valueObject.salesStandardPrice ?? 1,
					C_TaxCategory: { UUID: (await getDefaultTaxCategory(valueObject)).UUID },
					M_Product_Category: { UUID: (await getDefaultProductCategory(valueObject)).UUID },
					C_UOM: { UUID: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UUID },
					ProductType: { UUID: '59dcc5c9-ab37-4f5c-9987-6e2347f50093' }, // Items
				},
			},
		})
	).data?.M_ProductSave;
	let product2 = valueObject.product!;

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create service 1';
	let service1 = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				entity: {
					AD_Org: { UUID: valueObject.organization!.UUID },
					Description: valueObject.getStepMessageLong(),
					Name: 's1' + valueObject.getDynamicScenarioName(),
					C_TaxCategory: { UUID: (await getDefaultTaxCategory(valueObject)).UUID },
					M_Product_Category: { UUID: (await getDefaultProductCategory(valueObject)).UUID },
					C_UOM: { UUID: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UUID },
					ProductType: { UUID: '265e0369-47e4-4be9-b6d5-e344230f5588' }, // Service
				},
			},
		})
	).data!.M_ProductSave!;
	expect(service1).toBeTruthy();

	valueObject.stepName = 'Create service 2';
	let service2 = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				entity: {
					AD_Org: { UUID: valueObject.organization!.UUID },
					Description: valueObject.getStepMessageLong(),
					Name: 's2' + valueObject.getDynamicScenarioName(),
					C_TaxCategory: { UUID: (await getDefaultTaxCategory(valueObject)).UUID },
					M_Product_Category: { UUID: (await getDefaultProductCategory(valueObject)).UUID },
					C_UOM: { UUID: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UUID },
					ProductType: { UUID: '265e0369-47e4-4be9-b6d5-e344230f5588' }, // Service
				},
			},
		})
	).data!.M_ProductSave!;
	expect(service2).toBeTruthy();

	let searchedResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				size: 15,
				filter: JSON.stringify({ name: { $text: valueObject.random.toString() }, isactive: true }),
			},
		})
	).data.M_ProductGet.results;
	expect(searchedResults).toHaveLength(4);
	expect(searchedResults.find((product) => product.Name === product1.Name)).toBeTruthy();
	expect(searchedResults.find((product) => product.Name === product2.Name)).toBeTruthy();
	expect(searchedResults.find((product) => product.Name === service1.Name)).toBeTruthy();
	expect(searchedResults.find((product) => product.Name === service2.Name)).toBeTruthy();

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Sell first product so it can be deactivated';
	valueObject.documentAction = documentAction.Complete;
	valueObject.product = product1;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Deactivate a service and product';
	await mutate(valueObject)({
		mutation: M_ProductSaveManyDocument,
		variables: {
			entities: [
				{ UUID: product1.UUID, IsActive: false },
				{ UUID: service1.UUID, IsActive: false },
			],
		},
	});

	searchedResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				size: 15,
				filter: JSON.stringify({ name: { $text: valueObject.random.toString() }, isactive: true }),
			},
		})
	).data.M_ProductGet.results;
	expect(searchedResults).toHaveLength(2);
	expect(searchedResults.find((product) => product.Name === product1.Name)).toBeFalsy();
	expect(searchedResults.find((product) => product.Name === product2.Name)).toBeTruthy();
	expect(searchedResults.find((product) => product.Name === service1.Name)).toBeFalsy();
	expect(searchedResults.find((product) => product.Name === service2.Name)).toBeTruthy();
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

	expect(
		(await query(valueObject)({ query: M_ProductGetDocument, variables: { page: 0, size: 1 } })).data.M_ProductGet
			.pagingInfo.totalPages,
	).toBeGreaterThan(1);
	const specificSearchResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { page: 1, size: 1, filter: JSON.stringify({ name: product1.Name }) },
		})
	).data.M_ProductGet;
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

	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(100);

	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { entity: { UUID: valueObject.product!.UUID, BH_BuyPrice: 110 } },
		})
	).data?.M_ProductSave;

	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(110);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Prepare;
	valueObject.setPurchasePrice(120);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { size: 1, filter: JSON.stringify({ m_product_uu: valueObject.product!.UUID }) },
		})
	).data.M_ProductGet.results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(110);

	valueObject.stepName = 'Complete the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { uuid: valueObject.order!.UUID, documentAction: documentAction.Complete },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { size: 1, filter: JSON.stringify({ m_product_uu: valueObject.product!.UUID }) },
		})
	).data.M_ProductGet.results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);

	valueObject.stepName = 'Try to update the product buying price';
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { entity: { UUID: valueObject.product!.UUID, BH_BuyPrice: 130 } },
		})
	).data?.M_ProductSave;

	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);

	valueObject.stepName = 'Reactivate the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { uuid: valueObject.order!.UUID, documentAction: documentAction.ReActivate },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { size: 1, filter: JSON.stringify({ m_product_uu: valueObject.product!.UUID }) },
		})
	).data.M_ProductGet.results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(110);

	valueObject.stepName = 'Try to update the product buying price again';
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { entity: { UUID: valueObject.product!.UUID, BH_BuyPrice: 115 } },
		})
	).data?.M_ProductSave;
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(115);

	valueObject.stepName = 'Re-complete the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { uuid: valueObject.order!.UUID, documentAction: documentAction.Complete },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { size: 1, filter: JSON.stringify({ m_product_uu: valueObject.product!.UUID }) },
		})
	).data.M_ProductGet.results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);
});
