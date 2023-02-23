import { patientApi } from '../api';
import { documentAction } from '../models';
import { BusinessPartner, Patient } from '../types/org.bandahealth.idempiere.rest';
import { createProduct, createPurchaseOrder, createVendor, createVisit, formatDate } from '../utils';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const patient: Partial<Patient> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		address: '505 W 5th St'
	};
	const savedPatient = await patientApi.save(valueObject, patient as Patient);

	expect(savedPatient.totalOpenBalance).toBe(0);
	expect(savedPatient.name).toBe(patient.name);
	expect(savedPatient.address).toBe(patient.address);
});

test(`get method returns the correct data`, async () => {
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

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	const patient: Partial<Patient> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
		address: '514 E North Ave'
	};
	const savedPatient = await patientApi.save(valueObject, patient as Patient);
	valueObject.businessPartner = savedPatient as BusinessPartner;

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = documentAction.Complete;
	const twoDaysAgo = new Date();
	twoDaysAgo.setDate(twoDaysAgo.getDate() - 2);
	twoDaysAgo.setUTCHours(12);
	valueObject.date = twoDaysAgo;
	await createVisit(valueObject);

	const searchedPatients = (
		await patientApi.get(valueObject, 0, 10, undefined, JSON.stringify({ name: savedPatient.name }))
	).results;
	expect(searchedPatients).toHaveLength(1);
	expect(searchedPatients[0].lastVisitDate).toBe(formatDate(twoDaysAgo));
	expect(searchedPatients[0].totalVisits).toBe(1);
	expect(searchedPatients[0].nationalId).toBe(patient.nationalId);
	expect(searchedPatients[0].occupation).toBe(patient.occupation);
	expect(searchedPatients[0].nextOfKinName).toBe(patient.nextOfKinName);
	expect(searchedPatients[0].nextOfKinContact).toBe(patient.nextOfKinContact);
	expect(searchedPatients[0].address).toBe(patient.address);
});
