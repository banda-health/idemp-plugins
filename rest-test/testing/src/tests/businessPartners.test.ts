import { businessPartnerApi, businessPartnerGroupApi, visitApi } from '../api';
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
	valueObject.businessPartner! = {
		...valueObject.businessPartner!,
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
		address: '514 E North Ave',
		businessPartnerGroup: (
			await businessPartnerGroupApi.get(
				valueObject,
				undefined,
				undefined,
				undefined,
				JSON.stringify({ name: 'Patients - DO NOT CHANGE' }),
			)
		).results[0],
	};
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
			JSON.stringify({
				name: valueObject.businessPartner.name,
				c_bp_group: { name: valueObject.businessPartner.businessPartnerGroup.name },
			}),
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

	const specificBusinessPartner = await businessPartnerApi.getByUuid(valueObject, searchedBusinessPartners[0].uuid);
	expect(specificBusinessPartner).toBeTruthy();
	expect(specificBusinessPartner.lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(specificBusinessPartner.totalVisits).toBe(1);
	expect(specificBusinessPartner.nationalId).toBe(valueObject.businessPartner.nationalId);
	expect(specificBusinessPartner.occupation).toBe(valueObject.businessPartner.occupation);
	expect(specificBusinessPartner.nextOfKinName).toBe(valueObject.businessPartner.nextOfKinName);
	expect(specificBusinessPartner.nextOfKinContact).toBe(valueObject.businessPartner.nextOfKinContact);
	expect(specificBusinessPartner.address).toBe(valueObject.businessPartner.address);
});
