import { patientApi } from '../api';
import { documentAction } from '../models';
import { BusinessPartner, Patient } from '../types/org.bandahealth.idempiere.rest';
import { createProduct, createVisit, formatDate } from '../utils';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const patient: Partial<Patient> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
	};
	const savedPatient = await patientApi.save(valueObject, patient as Patient);

	expect(savedPatient.totalOpenBalance).toBe(0);
	expect(savedPatient.name).toBe(patient.name);
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create patient';
	const patient: Partial<Patient> = {
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		dateOfBirth: valueObject.date?.toISOString(),
		gender: 'male',
		nationalId: '156156',
		occupation: 'Programmer',
		nextOfKinName: 'Wifey',
		nextOfKinContact: '155155',
	};
	const savedPatient = await patientApi.save(valueObject, patient as Patient);
	valueObject.businessPartner = savedPatient as BusinessPartner;
	delete (valueObject.businessPartner as Partial<Patient>).approximateDateOfBirth;

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

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
});
