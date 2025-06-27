import { v4 } from 'uuid';
import {
	Bh_ConceptGetForProductCatalogueDocument,
	Bh_Product_IncludedDeleteDocument,
	Bh_Product_IncludedSaveManyDocument,
	Bh_VisitProcessDocument,
	C_OrderProcessDocument,
	C_UomGetDefaultDocument,
	M_ProductDocument,
	M_ProductGetDocument,
	M_ProductMergeDocument,
	M_ProductSaveDocument,
	M_ProductSaveManyDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	getDefaultProductCategory,
	getDefaultTaxCategory,
} from '../utils';

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
	valueObject.product = undefined;
	const oldRandom = valueObject.random;
	valueObject.setRandom();
	await createProduct(valueObject);
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				Entity: {
					UU: valueObject.product!.UU,
					Name: 'p2' + product1.Name,
				},
			},
		})
	).data?.M_ProductSave;
	let product2 = valueObject.product!;
	valueObject.random = oldRandom;

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create service 1';
	let service1 = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				Entity: {
					AD_Org: { UU: valueObject.organization!.UU },
					Description: valueObject.getStepMessageLong(),
					Name: 's1' + valueObject.getDynamicScenarioName(),
					C_TaxCategory: { UU: (await getDefaultTaxCategory(valueObject)).UU },
					M_Product_Category: { UU: (await getDefaultProductCategory(valueObject)).UU },
					C_UOM: { UU: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU },
					ProductType: { UU: '265e0369-47e4-4be9-b6d5-e344230f5588' }, // Service
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
				Entity: {
					AD_Org: { UU: valueObject.organization!.UU },
					Description: valueObject.getStepMessageLong(),
					Name: 's2' + valueObject.getDynamicScenarioName(),
					C_TaxCategory: { UU: (await getDefaultTaxCategory(valueObject)).UU },
					M_Product_Category: { UU: (await getDefaultProductCategory(valueObject)).UU },
					C_UOM: { UU: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU },
					ProductType: { UU: '265e0369-47e4-4be9-b6d5-e344230f5588' }, // Service
				},
			},
		})
	).data!.M_ProductSave!;
	expect(service2).toBeTruthy();

	let searchedResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				Size: 15,
				Filter: JSON.stringify({ name: { $text: valueObject.random.toString() }, isactive: true }),
			},
		})
	).data.M_ProductGet.Results;
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
			Entities: [
				{ UU: product1.UU, IsActive: false },
				{ UU: service1.UU, IsActive: false },
			],
		},
	});

	searchedResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				Size: 15,
				Filter: JSON.stringify({ name: { $text: valueObject.random.toString() }, isactive: true }),
			},
		})
	).data.M_ProductGet.Results;
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
		(await query(valueObject)({ query: M_ProductGetDocument, variables: { Page: 0, Size: 1 } })).data.M_ProductGet
			.PagingInfo.TotalPages,
	).toBeGreaterThan(1);
	const specificSearchResults = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { Page: 1, Size: 1, Filter: JSON.stringify({ name: product1.Name }) },
		})
	).data.M_ProductGet;
	expect(specificSearchResults.Results.length).toBe(1);
	expect(specificSearchResults.PagingInfo.Page).toBe(0);
	expect(specificSearchResults.PagingInfo.TotalPages).toBe(1);
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
			variables: { Entity: { UU: valueObject.product!.UU, BH_BuyPrice: 110 } },
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
			variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
		})
	).data.M_ProductGet.Results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(110);

	valueObject.stepName = 'Complete the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Complete },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
		})
	).data.M_ProductGet.Results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);

	valueObject.stepName = 'Try to update the product buying price';
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { Entity: { UU: valueObject.product!.UU, BH_BuyPrice: 130 } },
		})
	).data?.M_ProductSave;

	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);

	valueObject.stepName = 'Reactivate the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.ReActivate },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
		})
	).data.M_ProductGet.Results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(110);

	valueObject.stepName = 'Try to update the product buying price again';
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: { Entity: { UU: valueObject.product!.UU, BH_BuyPrice: 115 } },
		})
	).data?.M_ProductSave;
	expect(valueObject.product!.HasBeenPurchased).toBeFalsy();
	expect(valueObject.product!.LastPurchasePrice).toBe(115);

	valueObject.stepName = 'Re-complete the PO';
	await mutate(valueObject)({
		mutation: C_OrderProcessDocument,
		variables: { UU: valueObject.order!.UU, DocumentAction: documentAction.Complete },
	});
	valueObject.product = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ m_product_uu: valueObject.product!.UU }) },
		})
	).data.M_ProductGet.Results[0];
	expect(valueObject.product!.HasBeenPurchased).toBeTruthy();
	expect(valueObject.product!.LastPurchasePrice).toBe(120);
});

test('can sort by last purchase price', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create first product';
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);
	const firstProduct = valueObject.product!;

	valueObject.stepName = 'Create purchase order for the first product';
	valueObject.documentAction = documentAction.Complete;
	valueObject.setPurchasePrice(120);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create second product';
	valueObject.product = undefined;
	valueObject.setRandom();
	valueObject.setPurchasePrice(100);
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order for the second product';
	valueObject.documentAction = documentAction.Complete;
	valueObject.setPurchasePrice(140);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	const secondProduct = valueObject.product!;
	let productSorts = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				Sort: JSON.stringify([['product_costs.purchase_price', 'desc']]),
				Filter: JSON.stringify({ m_product_uu: { $in: [firstProduct.UU, secondProduct.UU] } }),
			},
		})
	).data.M_ProductGet.Results;
	expect(productSorts).toHaveLength(2);
	expect(productSorts[0].UU).toBe(secondProduct.UU);
	expect(productSorts[1].UU).toBe(firstProduct.UU);

	productSorts = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: {
				Sort: JSON.stringify([['product_costs.purchase_price', 'asc']]),
				Filter: JSON.stringify({ m_product_uu: { $in: [firstProduct.UU, secondProduct.UU] } }),
			},
		})
	).data.M_ProductGet.Results;
	expect(productSorts).toHaveLength(2);
	expect(productSorts[0].UU).toBe(firstProduct.UU);
	expect(productSorts[1].UU).toBe(secondProduct.UU);
});

test('merging patients', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner 1';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit 1';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-2);
	await createVisit(valueObject);

	valueObject.stepName = 'Create order 1';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice 1';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment 1';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 23;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit 1';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const product1 = valueObject.product!;

	valueObject.clearBusinessPartner();
	valueObject.clearProduct();

	valueObject.stepName = 'Create business partner 2';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 2';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order 2';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit 2';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-2);
	await createVisit(valueObject);

	valueObject.stepName = 'Create order 2';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice 2';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment 2';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 68;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit 2';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const product2 = valueObject.product!;

	const result = (
		await mutate(valueObject)({
			mutation: M_ProductMergeDocument,
			variables: { OldUU: product1.UU, NewUU: product2.UU },
		})
	).data?.M_ProductMerge;
	expect(result).toBe(true);

	let product = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product1.UU } })).data.M_Product;
	expect(product).toBeFalsy();
	product = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product2.UU } })).data.M_Product!;
	expect(product).toBeTruthy();
});

test('can work with included products', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create product 2';
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product2 = valueObject.product!;

	valueObject.stepName = 'Create product 3';
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product3 = valueObject.product!;

	await mutate(valueObject)({
		mutation: Bh_Product_IncludedSaveManyDocument,
		variables: {
			BH_Product_IncludedList: [
				{ Included_Product: { UU: product2.UU }, M_Product: { UU: product1.UU }, Qty: 5, SeqNo: 10, UU: v4() },
				{ Included_Product: { UU: product3.UU }, M_Product: { UU: product1.UU }, Qty: 6, SeqNo: 20 },
			],
		},
	});

	let productToCheck = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product1.UU } })).data
		.M_Product!;
	expect(productToCheck.BH_Product_IncludedList).toHaveLength(2);
	expect(productToCheck.BH_Product_IncludedList![0].SeqNo).toBe(10);
	expect(productToCheck.BH_Product_IncludedList![0].Qty).toBe(5);
	expect(productToCheck.BH_Product_IncludedList![0].Included_Product.UU).toBe(product2.UU);
	expect(productToCheck.BH_Product_IncludedList![1].SeqNo).toBe(20);
	expect(productToCheck.BH_Product_IncludedList![1].Qty).toBe(6);
	expect(productToCheck.BH_Product_IncludedList![1].Included_Product.UU).toBe(product3.UU);

	await mutate(valueObject)({
		mutation: Bh_Product_IncludedDeleteDocument,
		variables: { UUs: [productToCheck.BH_Product_IncludedList![1].UU] },
	});

	productToCheck = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product1.UU } })).data
		.M_Product!;
	expect(productToCheck.BH_Product_IncludedList).toHaveLength(1);
});

test('unable to include the same product multiple times', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);
	const product1 = valueObject.product!;

	valueObject.stepName = 'Create product 2';
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product2 = valueObject.product!;

	await expect(
		mutate(valueObject)({
			mutation: Bh_Product_IncludedSaveManyDocument,
			variables: {
				BH_Product_IncludedList: [
					{ Included_Product: { UU: product2.UU }, M_Product: { UU: product1.UU }, Qty: 5, SeqNo: 10, UU: v4() },
					{ Included_Product: { UU: product2.UU }, M_Product: { UU: product1.UU }, Qty: 6, SeqNo: 20 },
				],
			},
		}),
	).rejects.toBeTruthy();
});
test('product concept can be updated', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const concepts = (
		await query(valueObject)({
			query: Bh_ConceptGetForProductCatalogueDocument,
			variables: { Filter: JSON.stringify({ BH_Source: { $in: ['BHPharmacy'] } }) },
		})
	).data.BH_ConceptGet.Results;

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product with concept 1';
	await createProduct(valueObject);
	const product = valueObject.product!;

	await createProduct(valueObject);
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				Entity: {
					UU: valueObject.product!.UU,
					Name: 'p1' + product.Name,
					BH_Concept: {
						UU: concepts[0].UU,
					},
				},
			},
		})
	).data?.M_ProductSave;
	let savedProduct = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product.UU } })).data
		.M_Product!;

	expect(savedProduct.BH_Concept?.UU).toBe(concepts[0].UU);

	valueObject.stepName = 'Change product concept to concept 2';
	valueObject.product = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				Entity: {
					UU: valueObject.product!.UU,
					BH_Concept: {
						UU: concepts[1].UU,
					},
				},
			},
		})
	).data?.M_ProductSave;

	savedProduct = (await query(valueObject)({ query: M_ProductDocument, variables: { UU: product.UU } })).data
		.M_Product!;

	expect(savedProduct.BH_Concept?.UU).toBe(concepts[1].UU);
});
