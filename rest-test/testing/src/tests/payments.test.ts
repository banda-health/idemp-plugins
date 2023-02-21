import { paymentApi, referenceListApi } from '../api';
import { documentAction, documentStatus, referenceUuid, tenderTypeName } from '../models';
import { PaymentType } from '../types/org.bandahealth.idempiere.rest';
import {
	createBusinessPartner,
	createPayment,
	createProduct,
	createPurchaseOrder,
	createVendor,
	createVisit,
} from '../utils';

test('payment type updated with UUID, not value', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = undefined;
	await createPayment(valueObject);

	const cashPaymentType = { ...valueObject.payment!.paymentType };
	const mobilePaymentType = (
		await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)
	).find((tenderType) => tenderType.name === tenderTypeName.MOBILE_MONEY) as PaymentType;

	valueObject.stepName = 'Set only payment type value';
	let updatedPayment = await paymentApi.save(valueObject, {
		...valueObject.payment!,
		paymentType: { ...cashPaymentType, value: mobilePaymentType.value },
	});
	expect(updatedPayment.paymentType.uuid).not.toBeFalsy();
	expect(updatedPayment.paymentType.uuid).toBe(cashPaymentType.uuid);

	valueObject.stepName = 'Set only UUID';
	updatedPayment = await paymentApi.save(valueObject, {
		...valueObject.payment!,
		paymentType: { ...cashPaymentType, uuid: mobilePaymentType.uuid },
	});
	expect(updatedPayment.paymentType.uuid).toBe(mobilePaymentType.uuid);
});

test('payment values are saved correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = undefined;
	await createPayment(valueObject);

	valueObject.payment!.payAmount = 500;
	valueObject.payment!.tenderAmount = 600;

	const newPayment = await paymentApi.save(valueObject, valueObject.payment!);

	expect(newPayment.payAmount).toBe(valueObject.payment!.payAmount);
	expect(newPayment.tenderAmount).toBe(valueObject.payment!.tenderAmount);
});

test('debt payments are processed correctly', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create business partner';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = documentAction.Complete;
	await createVisit(valueObject);

	valueObject.stepName = 'Create Cash Payment';
	valueObject.documentAction = undefined;
	await createPayment(valueObject);
	const newPayment = await paymentApi.saveAndProcess(valueObject, valueObject.payment!, documentAction.Complete);

	expect(newPayment.payAmount).toBe(valueObject.payment!.payAmount);
	expect(newPayment.tenderAmount).toBe(valueObject.payment!.tenderAmount);
	expect(newPayment.docStatus).toBe(documentStatus.Completed);
});
