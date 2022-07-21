import { patientApi, visitApi } from '../api';
import { tenderType } from '../models';
import { Payment, PaymentType, Visit } from '../types/org.bandahealth.idempiere.rest';
import {
	createBusinessPartner,
	createOrder,
	createPatient,
	createProduct,
	createVisit,
	waitForVisitToComplete,
} from '../utils';

test(`patient open balance is 0 after visit if complete payment was made`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	await createPatient(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: valueObject.orderLine!.lineNetAmount,
			paymentType: tenderType.CASH as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, 'CO');
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
}, 15000);

xtest(`patient open balance updated after visit if complete payment wasn't made`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	await createPatient(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: 50,
			paymentType: tenderType.CASH as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order! as Visit, 'CO');
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);
});

xtest(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	await createBusinessPartner(globalThis.__VALUE_OBJECT__);
	await createOrder(globalThis.__VALUE_OBJECT__);
});
