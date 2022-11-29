import { paymentApi, referenceListApi } from '../api';
import { referenceUuid, tenderTypeName } from '../models';
import { PaymentType } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createPayment } from '../utils';

test('payment type updated with UUID, not value', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Business Partner';
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

	valueObject.stepName = 'Create Business Partner';
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
