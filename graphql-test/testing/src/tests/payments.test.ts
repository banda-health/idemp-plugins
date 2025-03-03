import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentStatus, referenceUuid, tenderTypeName } from '../models';
import {
	createBusinessPartner,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	getBankAccountOfOrganization,
} from '../utils';
import {
	Ad_Ref_ListGetDocument,
	Bh_VisitDocument,
	Bh_VisitSaveDocument,
	Bh_VisitSaveWithPaymentsDocument,
	C_BPartnerGetDocument,
	C_PaymentGetDocument,
	C_PaymentSaveDocument,
} from '../__generated__/graphql';

test('payment values are saved correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	const newPayment = (
		await mutate(valueObject)({
			mutation: C_PaymentSaveDocument,
			variables: {
				Entity: {
					UU: valueObject.payment!.UU,
					BH_tender_amount: 600,
					PayAmt: 500,
				},
			},
		})
	).data!.C_PaymentSave!;

	expect(newPayment).toBeTruthy();
	expect(newPayment.PayAmt).toBe(500);
	expect(newPayment.BH_tender_amount).toBe(600);
});

test('debt payments are processed correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	await createVisit(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	valueObject.order = undefined;
	await createPayment(valueObject);

	expect(valueObject.payment!.DocStatus.Value).toBe(documentStatus.Completed);
});

test('filtering by payments not on a visit works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create non-visit payment';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);
	const nonVisitPayment = valueObject.payment!;

	valueObject.stepName = 'Create visit payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Create visit';
	const visitUuid = v4();
	await mutate(valueObject)({
		mutation: Bh_VisitSaveWithPaymentsDocument,
		variables: {
			BH_Visit: {
				UU: visitUuid,
				Description: valueObject.getDynamicStepMessage(),
				Patient: { UU: valueObject.businessPartner!.UU },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Payments: [
				{
					UU: valueObject.payment!.UU,
					BH_Visit: { UU: visitUuid },
				},
			],
		},
	});

	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: { Filter: JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: nonVisitPayment.UU }) },
			})
		).data.C_PaymentGet.Results[0],
	).toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					Filter: JSON.stringify({ bh_visit: { bh_visit_uu: { $null: true } }, c_payment_uu: nonVisitPayment.UU }),
				},
			})
		).data.C_PaymentGet.Results[0],
	).toBeFalsy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					Filter: JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: valueObject.payment!.UU }),
				},
			})
		).data.C_PaymentGet.Results[0],
	).toBeFalsy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					Filter: JSON.stringify({
						bh_visit: { bh_visit_uu: { $nnull: true } },
						c_payment_uu: valueObject.payment!.UU,
					}),
				},
			})
		).data.C_PaymentGet.Results[0],
	).toBeTruthy();
});

test('can sort by business partner', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create first business partner';
	await createBusinessPartner(valueObject);
	const firstBusinessPartner = valueObject.businessPartner!;

	valueObject.stepName = 'Create payment for the first business partner';
	valueObject.paymentAmount = 100;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);
	const firstPayment = valueObject.payment!;

	valueObject.stepName = 'Create second business partner';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);
	const secondBusinessPartner = valueObject.businessPartner!;

	valueObject.stepName = 'Create payment for the second business partner';
	valueObject.paymentAmount = 100;
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);
	const secondPayment = valueObject.payment!;

	let sortedBusinessPartnerList = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: {
				Sort: JSON.stringify([['created', 'asc']]),
				Filter: JSON.stringify({ c_bpartner_uu: { $in: [firstBusinessPartner.UU, secondBusinessPartner.UU] } }),
			},
		})
	).data.C_BPartnerGet.Results;
	expect(sortedBusinessPartnerList).toHaveLength(2);

	let sortedPayments = (
		await query(valueObject)({
			query: C_PaymentGetDocument,
			variables: {
				Sort: JSON.stringify([['c_bpartner.created', 'asc']]),
				Filter: JSON.stringify({
					c_bpartner: { c_bpartner_uu: { $in: [firstBusinessPartner.UU, secondBusinessPartner.UU] } },
				}),
			},
		})
	).data.C_PaymentGet.Results;
	expect(sortedPayments).toHaveLength(2);
	expect(sortedPayments[0].UU).toBe(firstPayment.UU);
	expect(sortedPayments[1].UU).toBe(secondPayment.UU);

	sortedPayments = (
		await query(valueObject)({
			query: C_PaymentGetDocument,
			variables: {
				Sort: JSON.stringify([['c_bpartner.created', 'desc']]),
				Filter: JSON.stringify({
					c_bpartner: { c_bpartner_uu: { $in: [firstBusinessPartner.UU, secondBusinessPartner.UU] } },
				}),
			},
		})
	).data.C_PaymentGet.Results;
	expect(sortedPayments).toHaveLength(2);
	expect(sortedPayments[0].UU).toBe(secondPayment.UU);
	expect(sortedPayments[1].UU).toBe(firstPayment.UU);
});
test('can schedule a debt payment', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create payment for Business partner';
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);

	const paymentUU = v4();

	valueObject.setDateOffset(10);
	await mutate(valueObject)({
		mutation: C_PaymentSaveDocument,
		variables: {
			Entity: {
				UU: paymentUU,
				C_BPartner: valueObject.businessPartner,
				BH_tender_amount: 600,
				PayAmt: 500,
				Scheduled: true,
				TenderType: {
					UU: (
						valueObject.tenderType ||
						(
							await query(valueObject)({
								query: Ad_Ref_ListGetDocument,
								variables: {
									Size: 1,
									Filter: JSON.stringify({
										ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES },
										name: tenderTypeName.CASH,
									}),
								},
							})
						).data.AD_Ref_ListGet.Results[0]
					)?.UU,
				},
				C_BankAccount: { UU: (await getBankAccountOfOrganization(valueObject))?.UU! },
				C_Currency: {
					UU: valueObject.invoice?.C_Currency.UU || valueObject.order?.C_Currency.UU || valueObject.currency?.UU!,
				},
			},
		},
	});

	let payment = (
		await query(valueObject)({
			query: C_PaymentGetDocument,
			variables: {
				Sort: JSON.stringify([['c_bpartner.created', 'asc']]),
				Filter: JSON.stringify({ c_payment_uu: valueObject.payment?.UU }),
			},
		})
	).data.C_PaymentGet.Results[0];
	expect(payment).toBeTruthy();
	expect(payment.Scheduled).toBe(true);

	valueObject.setDateOffset(10);
	await mutate(valueObject)({
		mutation: C_PaymentSaveDocument,
		variables: {
			Entity: {
				UU: valueObject.payment!.UU,
				DateTrx: valueObject.date?.getTime(),
			},
		},
	});
	payment = (
		await query(valueObject)({
			query: C_PaymentGetDocument,
			variables: { Filter: JSON.stringify({ c_payment_uu: payment.UU }) },
		})
	).data.C_PaymentGet.Results[0];
	expect(payment).toBeTruthy();
	expect(payment.Scheduled).toBe(true);
	expect(payment.DateTrx).toBe(valueObject.date?.getTime());
});
