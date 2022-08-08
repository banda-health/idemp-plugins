import { patientApi } from '../api';
import { Patient } from '../types/org.bandahealth.idempiere.rest';

// Something is wrong with open balances at the moment, so skipping this test
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
