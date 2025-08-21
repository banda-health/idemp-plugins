import { C_OrderLineDocument, C_OrderLineGetDocument, C_OrderLineSaveManyDocument } from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentBaseType, documentSubTypeSalesOrder } from '../models';
import { createBusinessPartner, createOrder, createProduct } from '../utils';

test('working with included order lines', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	await createProduct(valueObject);

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

	valueObject.stepName = 'Create product 2';
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product2 = valueObject.product!;

	valueObject.stepName = 'Create product 3';
	valueObject.clearProduct();
	await createProduct(valueObject);
	const product3 = valueObject.product!;

	await mutate(valueObject)({
		mutation: C_OrderLineSaveManyDocument,
		variables: {
			Entities: [
				{
					C_Order: { UU: valueObject.order!.UU },
					Description: valueObject.getStepMessageLong(),
					Included_OrderLine: { UU: valueObject.orderLine!.UU },
					M_Product: { UU: product2.UU },
					M_AttributeSetInstance: valueObject.attributeSetInstance
						? { UU: valueObject.attributeSetInstance.UU }
						: undefined,
					Qty: valueObject.quantity || 1,
					Price:
						(valueObject.documentType?.IsSOTrx
							? valueObject.salesStandardPrice || valueObject.product?.BH_SellPrice || 0
							: valueObject.purchaseStandardPrice || valueObject.product?.BH_BuyPrice || 0) *
						(valueObject.quantity || 1),
				},
				{
					C_Order: { UU: valueObject.order!.UU },
					Description: valueObject.getStepMessageLong(),
					Included_OrderLine: { UU: valueObject.orderLine!.UU },
					M_Product: { UU: product3.UU },
					M_AttributeSetInstance: valueObject.attributeSetInstance
						? { UU: valueObject.attributeSetInstance.UU }
						: undefined,
					Qty: valueObject.quantity || 1,
					Price:
						(valueObject.documentType?.IsSOTrx
							? valueObject.salesStandardPrice || valueObject.product?.BH_SellPrice || 0
							: valueObject.purchaseStandardPrice || valueObject.product?.BH_BuyPrice || 0) *
						(valueObject.quantity || 1),
				},
			],
		},
	});

	let orderLine = (
		await query(valueObject)({ query: C_OrderLineDocument, variables: { UU: valueObject.orderLine!.UU } })
	).data.C_OrderLine!;
	expect(orderLine.Included_OrderLineList?.length).toBe(2);

	const orderLines = (
		await query(valueObject)({
			query: C_OrderLineGetDocument,
			variables: {
				Filter: JSON.stringify({
					'c_orderline::included_orderline_id->c_orderline_id.c_orderline_uu': valueObject.orderLine!.UU,
				}),
			},
		})
	).data.C_OrderLineGet.Results;
	expect(orderLines.length).toBe(2);
	expect(orderLines[0].Included_OrderLine?.UU).toBe(orderLine.UU);
	expect(orderLines[1].Included_OrderLine?.UU).toBe(orderLine.UU);
});

test('price is set automatically when no pricelist property is sent', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product with specific prices';
	valueObject.salesStandardPrice = 50;
	valueObject.purchaseStandardPrice = 30;
	await createProduct(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	// Create a new order line without specifying a price - should be set automatically
	const savedOrderLine = (
		await mutate(valueObject)({
			mutation: C_OrderLineSaveManyDocument,
			variables: {
				Entities: [
					{
						C_Order: { UU: valueObject.order!.UU },
						Description: 'Test order line with automatic price',
						M_Product: { UU: valueObject.product!.UU },
						M_AttributeSetInstance: valueObject.attributeSetInstance
							? { UU: valueObject.attributeSetInstance.UU }
							: undefined,
						Price: 0, // This price should be overridden
						Qty: 2,
					},
				],
			},
		})
	).data!.C_OrderLineSaveMany![0];

	// Verify that the price was set automatically
	expect(savedOrderLine.PriceEntered).toBe(50);
});

test('price is not automatically set when pricelist property is sent', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product with specific prices';
	valueObject.salesStandardPrice = 50;
	valueObject.purchaseStandardPrice = 30;
	await createProduct(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	// Create a new order line with a pricelist specified - price should not be set automatically
	const savedOrderLine = (
		await mutate(valueObject)({
			mutation: C_OrderLineSaveManyDocument,
			variables: {
				Entities: [
					{
						C_Order: { UU: valueObject.order!.UU },
						Description: 'Test order line with pricelist - no automatic price',
						M_Product: { UU: valueObject.product!.UU },
						M_AttributeSetInstance: valueObject.attributeSetInstance
							? { UU: valueObject.attributeSetInstance.UU }
							: undefined,
						Price: 0,
						PriceList: 1,
						Qty: 2,
					},
				],
			},
		})
	).data!.C_OrderLineSaveMany![0];

	// Verify that the price was NOT set automatically when pricelist is specified
	expect(savedOrderLine.PriceEntered).toBe(0);
});
