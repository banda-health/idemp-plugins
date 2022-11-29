import axios from 'axios';
import { ValueObject } from '../models';
import { Patient } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class PatientApi extends BaseApi<Patient> {
	entityName = 'patients';

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<Patient> {
		return (
			await axios.post<Patient>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/patient/${uuid}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async save(valueObject: ValueObject, data: Patient): Promise<Patient> {
		return (
			await axios.post<Patient>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const patientApi = new PatientApi();
