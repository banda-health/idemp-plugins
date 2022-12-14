import axios from 'axios';
import { ValueObject } from '../models';
import { BaseListResponse, Patient } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class PatientApi extends BaseApi<Patient> {
	entityName = 'patients';

	async get(
		valueObject: ValueObject,
		page?: number | undefined,
		size?: number | undefined,
		sortJson?: string | undefined,
		filterJson?: string | undefined,
	): Promise<BaseListResponse<Patient>> {
		return (
			await axios.post<BaseListResponse<Patient>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}?page=${page || 0}&size=${size || 1000}&sorting=${
					sortJson || ''
				}&filter=${filterJson || ''}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

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
