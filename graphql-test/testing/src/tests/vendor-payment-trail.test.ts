import { C_BPartnerDocument, VendorPaymentTrailGetDocument } from '../__generated__/graphql';
import { query } from '../api';
import { documentAction, documentBaseType } from '../models';
import {
	createBusinessPartner,
	createCharge,
	createInOutFromOrder,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
} from '../utils';

test('data is grouped correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.purchaseStandardPrice = 100;
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order 1';
	valueObject.quantity = 5;
	valueObject.documentAction = documentAction.Complete;
	valueObject.setDateOffset(-5);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create vendor invoice 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create full payment 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, false, false, false);
	await createPayment(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(0);

	let paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Size: 1,
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeTruthy();
	expect(paymentTrailResults[0].Charged).toBe(500);
	expect(paymentTrailResults[0].Paid).toBe(500);
	expect(paymentTrailResults[0].OpenBalance).toBe(0);

	valueObject.stepName = 'Create purchase order 2';
	valueObject.quantity = 10;
	valueObject.documentAction = documentAction.Complete;
	valueObject.setDateOffset(1);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt 2';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create vendor invoice 2';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create partial payment 2';
	valueObject.documentAction = documentAction.Complete;
	valueObject.paymentAmount = 500;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, false, false, false);
	await createPayment(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(-500);

	paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Size: 1,
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeTruthy();
	expect(paymentTrailResults[0].Charged).toBe(1000);
	expect(paymentTrailResults[0].Paid).toBe(500);
	expect(paymentTrailResults[0].OpenBalance).toBe(500);

	valueObject.stepName = 'Create purchase order 3';
	valueObject.quantity = 15;
	valueObject.documentAction = documentAction.Complete;
	valueObject.setDateOffset(1);
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt 3';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create vendor invoice 3';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(-2000);

	paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Size: 1,
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeFalsy();
	expect(paymentTrailResults[0].Charged).toBe(1500);
	expect(paymentTrailResults[0].Paid).toBe(0);
	expect(paymentTrailResults[0].OpenBalance).toBe(2000);

	// Now do an expense
	valueObject.stepName = 'Create charge';
	valueObject.setDateOffset(1);
	valueObject.order = undefined;
	valueObject.clearProduct();
	await createCharge(valueObject);

	valueObject.stepName = 'Create vendor invoice 4';
	valueObject.quantity = 1;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APInvoice, null, false, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create partial payment 4';
	valueObject.documentAction = documentAction.Complete;
	valueObject.paymentAmount = valueObject.salesStandardPrice;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, false, false, false);
	await createPayment(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(-2000);

	paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Size: 1,
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeFalsy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeTruthy();
	expect(paymentTrailResults[0].Charged).toBe(100);
	expect(paymentTrailResults[0].Paid).toBe(100);
	expect(paymentTrailResults[0].OpenBalance).toBe(2000);

	// Create open-balance payments
	valueObject.stepName = 'Create open balance payment 1';
	valueObject.order = undefined;
	valueObject.invoice = undefined;
	valueObject.paymentAmount = 900;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, false, false, false);
	await createPayment(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(-1100);

	paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeFalsy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeFalsy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.IsAllocated).toBeTruthy();
	expect(paymentTrailResults[0].Charged).toBe(0);
	expect(paymentTrailResults[0].Paid).toBe(900);
	expect(paymentTrailResults[0].OpenBalance).toBe(1100);
	// Check the expense doesn't have any change in paid amount
	expect(paymentTrailResults[1].Charged).toBe(100);
	expect(paymentTrailResults[1].Paid).toBe(100);
	expect(paymentTrailResults[1].OpenBalance).toBe(2000);
	// Check the first order doesn't have any change in paid amount
	expect(paymentTrailResults[paymentTrailResults.length - 2].Charged).toBe(500);
	expect(paymentTrailResults[paymentTrailResults.length - 2].Paid).toBe(500);
	expect(paymentTrailResults[paymentTrailResults.length - 2].OpenBalance).toBe(0);

	valueObject.stepName = 'Create open balance payment 2';
	valueObject.order = undefined;
	valueObject.invoice = undefined;
	valueObject.paymentAmount = 300;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, false, false, false);
	await createPayment(valueObject);

	// Check values
	expect(
		(await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })).data
			.C_BPartner?.TotalOpenBalance,
	).toBe(-800);

	paymentTrailResults = (
		await query(valueObject)({
			query: VendorPaymentTrailGetDocument,
			variables: {
				Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }),
				Sort: JSON.stringify([
					['date', 'desc'],
					['created', 'desc'],
				]),
			},
		})
	).data.VendorPaymentTrailGet.Results;
	expect(paymentTrailResults[0].C_Order?.UU).toBeFalsy();
	expect(paymentTrailResults[0].C_Invoice?.UU).toBeFalsy();
	expect(paymentTrailResults[0].C_Payment?.UU).toBeTruthy();
	expect(paymentTrailResults[0].C_Payment?.IsAllocated).toBeTruthy();
	expect(paymentTrailResults[0].Charged).toBe(0);
	expect(paymentTrailResults[0].Paid).toBe(300);
	expect(paymentTrailResults[0].OpenBalance).toBe(800);
	// Check the first invoice is now paid
	expect(paymentTrailResults[paymentTrailResults.length - 2].C_Invoice?.IsPaid).toBeTruthy();
});
