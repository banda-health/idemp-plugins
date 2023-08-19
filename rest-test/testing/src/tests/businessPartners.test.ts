import { businessPartnerApi, visitApi } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { BusinessPartner } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner, createOrder, createProduct, createVisit, formatDate } from '../utils';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
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
	valueObject.businessPartner!.gender = 'male';
	valueObject.businessPartner!.nationalId = '156156';
	valueObject.businessPartner!.occupation = 'Programmer';
	valueObject.businessPartner!.nextOfKinName = 'Wifey';
	valueObject.businessPartner!.nextOfKinContact = '155155';
	valueObject.businessPartner!.address = '514 E North Ave';
	valueObject.businessPartner = await businessPartnerApi.save(valueObject, valueObject.businessPartner!);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

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
		documentSubTypeSalesOrder.WarehouseOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	const searchedBusinessPartners = (
		await businessPartnerApi.get(
			valueObject,
			0,
			10,
			undefined,
			JSON.stringify({ name: valueObject.businessPartner.name }),
		)
	).results;
	expect(searchedBusinessPartners).toHaveLength(1);
	expect(searchedBusinessPartners[0].lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(searchedBusinessPartners[0].totalVisits).toBe(1);
	expect(searchedBusinessPartners[0].nationalId).toBe(valueObject.businessPartner.nationalId);
	expect(searchedBusinessPartners[0].occupation).toBe(valueObject.businessPartner.occupation);
	expect(searchedBusinessPartners[0].nextOfKinName).toBe(valueObject.businessPartner.nextOfKinName);
	expect(searchedBusinessPartners[0].nextOfKinContact).toBe(valueObject.businessPartner.nextOfKinContact);
	expect(searchedBusinessPartners[0].address).toBe(valueObject.businessPartner.address);
});
