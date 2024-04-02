import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentStatus, referenceUuid, tenderTypeName } from '../models';
import { createBusinessPartner, createOrder, createPayment, createProduct, createVisit } from '../utils';
import {
	Ad_Ref_ListGetDocument,
	Bh_VisitSaveWithPaymentsDocument,
	C_PaymentGetDocument,
	C_PaymentSaveDocument,
	C_PaymentSaveMutation,
} from '../__generated__/graphql';

test('payment type updated with UUID, not value', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	const mobilePaymentType = (
		await query(valueObject)({
			query: Ad_Ref_ListGetDocument,
			variables: {
				size: 15,
				filter: JSON.stringify({ ad_reference: { ad_reference_uu: referenceUuid.TENDER_TYPES } }),
			},
		})
	).data.AD_Ref_ListGet.results.find((tenderType) => tenderType.Name === tenderTypeName.MOBILE_MONEY);

	valueObject.stepName = 'Set only payment type value';
	let updatedPayment: C_PaymentSaveMutation['C_PaymentSave'] | undefined;
	try {
		updatedPayment = (
			await mutate(valueObject)({
				mutation: C_PaymentSaveDocument,
				variables: {
					entity: {
						UUID: valueObject.payment!.UUID,
						TenderType: {
							Value: mobilePaymentType?.Value,
						},
					},
				},
			})
		).data?.C_PaymentSave;
		expect(false).toBe(true);
	} catch {}

	valueObject.stepName = 'Set only UUID';
	updatedPayment = (
		await mutate(valueObject)({
			mutation: C_PaymentSaveDocument,
			variables: {
				entity: {
					UUID: valueObject.payment!.UUID,
					TenderType: {
						UUID: mobilePaymentType!.UUID,
					},
				},
			},
		})
	).data?.C_PaymentSave;
	expect(updatedPayment?.TenderType.UUID).toBe(mobilePaymentType?.UUID);
});

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
				entity: {
					UUID: valueObject.payment!.UUID,
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
				UUID: visitUuid,
				Description: valueObject.getDynamicStepMessage(),
				Patient: { UUID: valueObject.businessPartner!.UUID },
				BH_VisitDate: valueObject.date?.getTime(),
			},
			C_Payments: [
				{
					UUID: valueObject.payment!.UUID,
					BH_Visit: { UUID: visitUuid },
				},
			],
		},
	});

	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: { filter: JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: nonVisitPayment.UUID }) },
			})
		).data.C_PaymentGet.results[0],
	).toBeTruthy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					filter: JSON.stringify({ bh_visit: { bh_visit_uu: { $null: true } }, c_payment_uu: nonVisitPayment.UUID }),
				},
			})
		).data.C_PaymentGet.results[0],
	).toBeFalsy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					filter: JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: valueObject.payment!.UUID }),
				},
			})
		).data.C_PaymentGet.results[0],
	).toBeFalsy();
	expect(
		(
			await query(valueObject)({
				query: C_PaymentGetDocument,
				variables: {
					filter: JSON.stringify({
						bh_visit: { bh_visit_uu: { $nnull: true } },
						c_payment_uu: valueObject.payment!.UUID,
					}),
				},
			})
		).data.C_PaymentGet.results[0],
	).toBeTruthy();
});
