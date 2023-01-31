import { Patient } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class PatientApi extends BaseApi<Patient> {
	entityName = 'patients';
}

export const patientApi = new PatientApi();
