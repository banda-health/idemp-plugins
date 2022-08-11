import { patientApi, visitApi } from '../api';
import { documentAction, tenderType } from '../models';
import { Payment, PaymentType, Visit } from '../types/org.bandahealth.idempiere.rest';
import { createPatient, createProduct, createVisit, waitForVisitToComplete } from '../utils';

xtest(`information saved correctly after completing a visit`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
});

// Something is wrong with open balances at the moment, so skipping this test
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
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);
});

// Something is wrong with open balances at the moment, so skipping this test
test(`patient open balance updated after visit if complete payment wasn't made`, async () => {
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
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order! as Visit, documentAction.Complete);
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);
});

// Something is wrong with open balances at the moment, so skipping this test
test(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
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
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(50);

	valueObject.stepName = 'Reverse visit';
	valueObject.order = await visitApi.process(valueObject, valueObject.order.uuid, documentAction.ReActivate);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(0);

	valueObject.stepName = 'Re-completing visit';
	valueObject.order.payments[0].payAmount = 40;
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, documentAction.Complete);
	await waitForVisitToComplete(valueObject);

	expect((await patientApi.getByUuid(valueObject, valueObject.businessPartner!.uuid)).totalOpenBalance).toBe(60);
});
