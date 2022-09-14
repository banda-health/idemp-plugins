import axios from 'axios';
import { ValueObject } from '../models';
import { Account, BaseListResponse, Patient } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class AccountApi extends BaseApi<Account> {
	entityName = 'accounts';

	async get(
		valueObject: ValueObject,
		page?: number | undefined,
		size?: number | undefined,
		sortJson?: string | undefined,
		filterJson?: string | undefined,
	): Promise<BaseListResponse<Account>> {
		return (
			await axios.post<BaseListResponse<Account>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}?page=${page || 0}&size=${size || 1000}&sorting=${
					sortJson || ''
				}&filter=${filterJson || ''}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<Account> {
		return (
			await axios.post<Account>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/account/${uuid}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async save(valueObject: ValueObject, data: Patient): Promise<Account> {
		return (
			await axios.post<Account>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const accountApi = new AccountApi();
