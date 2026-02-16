import { mutate, query } from '../api';
import {
	documentAction,
	documentBaseType,
	documentStatus,
	documentSubTypeSalesOrder,
} from '../models';
import {
	createBusinessPartner,
	createCharge,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	formatApiDate,
} from '../utils';
import {
	C_BPartnerGetDocument,
	C_BPartnerSaveDocument,
	C_InvoiceDeleteDocument,
	C_InvoiceGetDocument,
	C_InvoiceProcessDocument,
	C_OrderGetDocument,
	C_OrderProcessDocument,
	C_OrderSaveWithOrderLinesDocument,
	C_PaymentProcessDocument,
	C_InvoiceSaveWithInvoiceLinesDocument,
} from '../__generated__/graphql';
import { v4 } from 'uuid';

test('creating an invoice with a charge', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UU }) },
			})
		).data.C_InvoiceGet.Results[0]?.UU,
	).toBe(valueObject.invoice!.UU);
});

test('invoice searching', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create first charge';
	await createCharge(valueObject);
	const firstCharge = valueObject.charge!;

	valueObject.stepName = 'Create first business partner';
	await createBusinessPartner(valueObject);
	const firstBusinessPartner = valueObject.businessPartner!;

	valueObject.stepName = 'Create first invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create second charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const secondCharge = valueObject.charge!;

	valueObject.stepName = 'Create second invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create third charge';
	valueObject.clearCharge();
	await createCharge(valueObject);
	const thirdCharge = valueObject.charge!;

	valueObject.stepName = 'Create second business partner';
	valueObject.clearBusinessPartner();
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create third invoice';
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	let invoices = (
		await query(valueObject)({
			query: C_InvoiceGetDocument,
			variables: {
				Filter: JSON.stringify({
					$or: [
						{ c_invoiceline: { c_charge: { name: firstCharge.Name } } },
						{ c_invoiceline: { c_charge: { name: secondCharge.Name } } },
						{ c_invoiceline: { c_charge: { name: thirdCharge.Name } } },
					],
				}),
			},
		})
	).data.C_InvoiceGet.Results;
	expect(invoices).toHaveLength(3);

	invoices = (
		await query(valueObject)({
			query: C_InvoiceGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { name: firstBusinessPartner.Name } }),
			},
		})
	).data.C_InvoiceGet.Results;
	expect(invoices).toHaveLength(2);
});

test(`vendor invoices can be deleted when they haven't been completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create vendor invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UU }) },
			})
		).data.C_InvoiceGet.Results[0],
	).toBeTruthy();
	expect(
		(
			await mutate(valueObject)({
				mutation: C_InvoiceDeleteDocument,
				variables: { UUs: [valueObject.invoice!.UU] },
			})
		).data?.C_InvoiceDelete,
	).toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UU }) },
			})
		).data.C_InvoiceGet.Results[0],
	).toBeFalsy();
});

test(`vendor invoices can't be deleted when they've been completed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Create vendor invoice';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);
	expect(valueObject.invoice).toBeTruthy();
	expect(valueObject.invoice!.DocStatus.Value).toBe(documentStatus.Completed);

	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UU }) },
			})
		).data.C_InvoiceGet.Results[0],
	).toBeTruthy();
	await expect(
		mutate(valueObject)({
			mutation: C_InvoiceDeleteDocument,
			variables: { UUs: [valueObject.invoice!.UU] },
		}),
	).rejects.toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UU }) },
			})
		).data.C_InvoiceGet.Results[0],
	).toBeTruthy();
});

test('can complete an invoice', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create charge';
	await createCharge(valueObject);

	valueObject.stepName = 'Complete invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	valueObject.documentAction = documentAction.Complete;
	await createInvoice(valueObject);

	expect(valueObject.invoice).toBeTruthy();
	expect(valueObject.invoice?.DocStatus.Value).toBe(documentStatus.Completed);
});

test('a payment for more than open invoice amounts causes the BP total open balance to be negative', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	await createProduct(valueObject);

	valueObject.stepName = 'Create invoice';
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	valueObject.documentAction = documentAction.Complete;
	valueObject.setSalesPrice(10);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.invoice = undefined;
	valueObject.paymentAmount = 100;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.documentAction = documentAction.Complete;
	await createPayment(valueObject);

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
			})
		).data.C_BPartnerGet.Results[0]?.TotalOpenBalance,
	).toBe(-90);
	await mutate(valueObject)({
		mutation: C_PaymentProcessDocument,
		variables: { UU: valueObject.payment!.UU, DocumentAction: documentAction.ReverseAccrual },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Size: 1, Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
			})
		).data.C_BPartnerGet.Results[0]?.TotalOpenBalance,
	).toBe(10);
});

test('price is not automatically set when pricelist property is sent on invoice line', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product with specific prices';
	valueObject.salesStandardPrice = 50;
	valueObject.purchaseStandardPrice = 30;
	await createProduct(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);

	const orderUU = v4();
	const savedData = (
		await mutate(valueObject)({
			mutation: C_OrderSaveWithOrderLinesDocument,
			variables: {
				C_Order: {
					UU: orderUU,
					BH_Visit: valueObject.visit ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner!.UU },
					C_DocTypeTarget: { UU: valueObject.documentType!.UU },
					DateOrdered: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType!.IsSOTrx,
					M_Warehouse: { UU: valueObject.warehouse!.UU },
					SalesRep: { UU: valueObject.user?.UU! },
				},
				C_OrderLine: {
					C_Order: { UU: orderUU },
					Description: valueObject.getStepMessageLong(),
					M_Product: { UU: valueObject.product!.UU },
					Price: 0,
					PriceList: 1,
					Qty: 1,
					M_AttributeSetInstance: valueObject.attributeSetInstance
						? { UU: valueObject.attributeSetInstance.UU }
						: undefined,
				},
			},
		})
	).data;

	valueObject.order =
		(
			await mutate(valueObject)({
				mutation: C_OrderProcessDocument,
				variables: { UU: orderUU, DocumentAction: valueObject.documentAction },
			})
		).data?.C_OrderProcess || undefined;
	valueObject.orderLine = savedData?.C_OrderLineSave;

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	const invoiceUU = v4();
	const savedInvoiceData = (
		await mutate(valueObject)({
			mutation: C_InvoiceSaveWithInvoiceLinesDocument,
			variables: {
				C_Invoice: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					BH_Visit: valueObject.visit ? { UU: valueObject.visit.UU } : undefined,
					C_BPartner: { UU: valueObject.businessPartner!.UU },
					C_DocTypeTarget: { UU: valueObject.documentType!.UU },
					C_Order: valueObject.order ? { UU: valueObject.order.UU } : undefined,
					DateInvoiced: formatApiDate(valueObject.date),
					Description: valueObject.getStepMessageLong(),
					IsSOTrx: valueObject.documentType!.IsSOTrx,
					UU: invoiceUU,
				},
				C_InvoiceLine: {
					AD_Org: valueObject.organization ? { UU: valueObject.organization.UU } : undefined,
					C_Charge: !valueObject.product && valueObject.charge ? { UU: valueObject.charge.UU } : undefined,
					C_Invoice: { UU: invoiceUU },
					C_OrderLine: valueObject.orderLine ? { UU: valueObject.orderLine.UU } : undefined,
					Description: valueObject.getStepMessageLong(),
					M_Product: valueObject.product ? { UU: valueObject.product.UU } : undefined,
					Price: 0,
					PriceList: 1,
					Qty: valueObject.quantity || 1,
				},
			},
		})
	).data;

	// Verify that the price was NOT set automatically when pricelist is specified
	expect(valueObject.orderLine!.PriceEntered).toBe(0);
	expect(savedInvoiceData!.C_InvoiceLineSave!.PriceEntered).toBe(0);
});

test('completing an invoice returns @InvoiceTotalExceedsPayments@ when business partner is not allowed credit', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	// Set credit status to credit stop so BP is not allowed credit
	await mutate(valueObject)({
		mutation: C_BPartnerSaveDocument,
		variables: {
			Entity: {
				UU: valueObject.businessPartner!.UU,
				SOCreditStatus: { UU: 'ebd6f716-efbe-4a4f-9d3a-e3848f4a3b75' },
			},
		},
	});

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

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

	valueObject.stepName = 'Create invoice (draft)';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	// Complete invoice: should fail with @InvoiceTotalExceedsPayments@ because BP is in credit stop and payments < grand total
	let error: Error | undefined;
	try {
		await mutate(valueObject)({
			mutation: C_InvoiceProcessDocument,
			variables: {
				UU: valueObject.invoice!.UU,
				DocumentAction: documentAction.Complete,
			},
		});
	} catch (e) {
		error = e as Error;
	}

	expect(error).toBeDefined();
	expect(error!.message).toContain('@InvoiceTotalExceedsPayments@');
});
