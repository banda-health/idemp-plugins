import { patientApi, referenceListApi, visitApi, productApi } from '../api';
import { referenceUuid, tenderTypeName } from '../models';
import { Payment, PaymentType, Visit } from '../types/org.bandahealth.idempiere.rest';
import { createPatient, createProduct, createVisit, waitForVisitToComplete, createProductInventory } from '../utils';

test(`Product Created with negative value`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create product with negative value';
	valueObject.salesStandardPrice = 100;
    valueObject.quantity = -100;
	await createProductInventory(valueObject);

	expect(valueObject.product?.totalQuantity).toBe(0);

});