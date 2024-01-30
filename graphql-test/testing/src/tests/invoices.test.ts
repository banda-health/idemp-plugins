import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentStatus } from '../models';
import { createBusinessPartner, createCharge, createInvoice, createPayment, createProduct } from '../utils';
import {
	C_BPartnerGetDocument,
	C_InvoiceDeleteDocument,
	C_InvoiceGetDocument,
	C_PaymentProcessDocument,
} from '../__generated__/graphql';

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
				variables: { size: 1, filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UUID }) },
			})
		).data.C_InvoiceGet.results[0]?.UUID,
	).toBe(valueObject.invoice!.UUID);
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
				filter: JSON.stringify({
					$or: [
						{ c_invoiceline: { c_charge: { name: firstCharge.Name } } },
						{ c_invoiceline: { c_charge: { name: secondCharge.Name } } },
						{ c_invoiceline: { c_charge: { name: thirdCharge.Name } } },
					],
				}),
			},
		})
	).data.C_InvoiceGet.results;
	expect(invoices).toHaveLength(3);

	invoices = (
		await query(valueObject)({
			query: C_InvoiceGetDocument,
			variables: {
				filter: JSON.stringify({ c_bpartner: { name: firstBusinessPartner.Name } }),
			},
		})
	).data.C_InvoiceGet.results;
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
				variables: { size: 1, filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UUID }) },
			})
		).data.C_InvoiceGet.results[0],
	).toBeTruthy();
	expect(
		(
			await mutate(valueObject)({
				mutation: C_InvoiceDeleteDocument,
				variables: { uuids: [valueObject.invoice!.UUID] },
			})
		).data?.C_InvoiceDelete,
	).toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { size: 1, filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UUID }) },
			})
		).data.C_InvoiceGet.results[0],
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
				variables: { size: 1, filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UUID }) },
			})
		).data.C_InvoiceGet.results[0],
	).toBeTruthy();
	await expect(
		mutate(valueObject)({
			mutation: C_InvoiceDeleteDocument,
			variables: { uuids: [valueObject.invoice!.UUID] },
		}),
	).rejects.toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_InvoiceGetDocument,
				variables: { size: 1, filter: JSON.stringify({ c_invoice_uu: valueObject.invoice!.UUID }) },
			})
		).data.C_InvoiceGet.results[0],
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
				variables: { size: 1, filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0]?.TotalOpenBalance,
	).toBe(-90);
	await mutate(valueObject)({
		mutation: C_PaymentProcessDocument,
		variables: { uuid: valueObject.payment!.UUID, documentAction: documentAction.ReverseAccrual },
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { size: 1, filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UUID }) },
			})
		).data.C_BPartnerGet.results[0]?.TotalOpenBalance,
	).toBe(10);
});
