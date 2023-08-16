import { businessPartnerApi, visitApi } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { BusinessPartner } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createOrder, createProduct, createPurchaseOrder, createVisit, formatDate } from '../utils';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const businessPartner: Partial<BusinessPartner> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		address: '505 W 5th St',
	};
	const savedPatient = await businessPartnerApi.save(valueObject, businessPartner as BusinessPartner);

	expect(savedPatient.totalOpenBalance).toBe(0);
	expect(savedPatient.name).toBe(businessPartner.name);
	expect(savedPatient.address).toBe(businessPartner.address);
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	const businessPartner: Partial<BusinessPartner> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
		address: '514 E North Ave',
	};
	const savedPatient = await businessPartnerApi.save(valueObject, businessPartner as BusinessPartner);
	valueObject.businessPartner = savedPatient as BusinessPartner;

	valueObject.stepName = 'Create visit';
	const twoDaysAgo = new Date();
	twoDaysAgo.setDate(twoDaysAgo.getDate() - 2);
	twoDaysAgo.setUTCHours(12);
	valueObject.date = twoDaysAgo;
	await createVisit(valueObject);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	const searchedBusinessPartners = (
		await businessPartnerApi.get(valueObject, 0, 10, undefined, JSON.stringify({ name: savedPatient.name }))
	).results;
	expect(searchedBusinessPartners).toHaveLength(1);
	expect(searchedBusinessPartners[0].lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(searchedBusinessPartners[0].totalVisits).toBe(1);
	expect(searchedBusinessPartners[0].nationalId).toBe(businessPartner.nationalId);
	expect(searchedBusinessPartners[0].occupation).toBe(businessPartner.occupation);
	expect(searchedBusinessPartners[0].nextOfKinName).toBe(businessPartner.nextOfKinName);
	expect(searchedBusinessPartners[0].nextOfKinContact).toBe(businessPartner.nextOfKinContact);
	expect(searchedBusinessPartners[0].address).toBe(businessPartner.address);
});
