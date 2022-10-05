import { patientApi, referenceListApi, visitApi, productApi } from '../api';
import { referenceUuid, tenderTypeName } from '../models';
import { Payment, PaymentType, Visit } from '../types/org.bandahealth.idempiere.rest';
import { createPatient, createProduct, createVisit, waitForVisitToComplete, createBusinessPartner, receiveProduct, createBusinessPartnerAsVendor } from '../utils';

test(`product created and sold with more than received quantity`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create Business Partner';
	await createBusinessPartnerAsVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	//Create a purchase order to receive the product
	valueObject.stepName = "Create purchase order";
    await receiveProduct(valueObject);

	//create a sale with more than received
	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	valueObject.quantity = 100;
	await createVisit(valueObject);

	valueObject.order!.payments = [
		{
			payAmount: 1000000,
			paymentType: (await referenceListApi.getByReference(valueObject, referenceUuid.TENDER_TYPES, false)).find(
				(tenderType) => tenderType.name === tenderTypeName.CASH,
			) as PaymentType,
		} as Payment,
	];

	valueObject.stepName = 'Complete visit';
	valueObject.order = await visitApi.saveAndProcess(valueObject, valueObject.order as Visit, 'DR');
	await waitForVisitToComplete(valueObject);

});