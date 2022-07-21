import { ValueObject } from '../models';
import { Patient } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './baseApi';

class PatientApi extends BaseApi<Patient> {
	entityName = 'patients';

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<Patient> {
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/patient/${uuid}`, {
			method: 'POST',
			headers: this.getAuthorizationHeaders(valueObject),
		});
		const result = await (response.json() as Promise<Patient>);
		if (!response.ok) {
			throw new Error(`could not single get ${this.entityName}`);
		}
		return result;
	}

	async save(valueObject: ValueObject, data: Patient): Promise<Patient> {
		const headers = this.getAuthorizationHeaders(valueObject);
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`, {
			method: 'POST',
			headers,
			body: JSON.stringify(data),
		});
		const result = await (response.json() as Promise<Patient>);
		if (!response.ok) {
			throw new Error(`could not save ${this.entityName}`);
		}
		return result;
	}
}

export const patientApi = new PatientApi();
