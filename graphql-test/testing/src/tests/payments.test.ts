// import { paymentApi, referenceListApi, visitApi } from '../api';
// import { documentAction, documentBaseType, documentStatus, referenceUuid, tenderTypeName } from '../models';
// import { PaymentType, Visit } from '../types/org.bandahealth.idempiere.rest';
// import { createBusinessPartner, createOrder, createPayment, createProduct, createVisit } from '../utils';

// test('payment type updated with UUID, not value', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create Cash Payment';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	const cashPaymentType = { ...valueObject.payment!.paymentType };
// 	const mobilePaymentType = (
// 		await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)
// 	).find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType;

// 	valueObject.stepName = 'Set only payment type value';
// 	let updatedPayment = await paymentApi.save(valueObject, {
// 		...valueObject.payment!,
// 		paymentType: { ...cashPaymentType, value: mobilePaymentType.value },
// 	});
// 	expect(updatedPayment.paymentType.uuid).not.toBeFalsy();
// 	expect(updatedPayment.paymentType.uuid).toBe(cashPaymentType.uuid);

// 	valueObject.stepName = 'Set only UUID';
// 	updatedPayment = await paymentApi.save(valueObject, {
// 		...valueObject.payment!,
// 		paymentType: { ...cashPaymentType, uuid: mobilePaymentType.uuid },
// 	});
// 	expect(updatedPayment.paymentType.uuid).toBe(mobilePaymentType.uuid);
// });

// test('payment values are saved correctly', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create Cash Payment';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	valueObject.payment!.payAmount = 500;
// 	valueObject.payment!.tenderAmount = 600;

// 	const newPayment = await paymentApi.save(valueObject, valueObject.payment!);

// 	expect(newPayment.payAmount).toBe(valueObject.payment!.payAmount);
// 	expect(newPayment.tenderAmount).toBe(valueObject.payment!.tenderAmount);
// });

// test('debt payments are processed correctly', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	valueObject.stepName = 'Create visit';
// 	await createVisit(valueObject);

// 	valueObject.stepName = 'Create Cash Payment';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	expect(valueObject.payment!.payAmount).toBe(valueObject.payment!.payAmount);
// 	expect(valueObject.payment!.tenderAmount).toBe(valueObject.payment!.tenderAmount);
// 	expect(valueObject.payment!.docStatus).toBe(documentStatus.Completed);
// });

// test('filtering by payments not on a visit works', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create non-visit payment';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);
// 	const nonVisitPayment = valueObject.payment!;

// 	valueObject.stepName = 'Create visit payment';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	valueObject.stepName = 'Create visit';
// 	const visit: Partial<Visit> = {
// 		description: valueObject.getStepMessageLong(),
// 		patient: valueObject.businessPartner,
// 		visitDate: valueObject.date,
// 		payments: [valueObject.payment!],
// 	};
// 	valueObject.visit = await visitApi.save(valueObject, visit as Visit);

// 	expect(
// 		(
// 			await paymentApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: nonVisitPayment.uuid }),
// 			)
// 		).results[0],
// 	).toBeTruthy();
// 	expect(
// 		(
// 			await paymentApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ bh_visit: { bh_visit_uu: { $null: true } }, c_payment_uu: nonVisitPayment.uuid }),
// 			)
// 		).results[0],
// 	).toBeFalsy();
// 	expect(
// 		(
// 			await paymentApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ bh_visit_id: { $null: true }, c_payment_uu: valueObject.payment!.uuid }),
// 			)
// 		).results[0],
// 	).toBeFalsy();
// 	expect(
// 		(
// 			await paymentApi.get(
// 				valueObject,
// 				undefined,
// 				undefined,
// 				undefined,
// 				JSON.stringify({ bh_visit: { bh_visit_uu: { $nnull: true } }, c_payment_uu: valueObject.payment!.uuid }),
// 			)
// 		).results[0],
// 	).toBeTruthy();
// });

export {};
