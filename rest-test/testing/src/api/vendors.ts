import axios from 'axios';
import { ValueObject } from '../models';
import { BaseListResponse, Vendor } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class VendorsApi extends BaseApi<Vendor> {
	entityName = 'vendors';

	async get(
		valueObject: ValueObject,
		page?: number | undefined,
		size?: number | undefined,
		sortJson?: string | undefined,
		filterJson?: string | undefined,
	): Promise<BaseListResponse<Vendor>> {
		return (
			await axios.post<BaseListResponse<Vendor>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}?page=${page || 0}&size=${size || 1000}&sortJson=${
					sortJson || ''
				}&filterJson=${filterJson || ''}`,
				null,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<Vendor> {
		return (
			await axios.post<Vendor>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/vendor/${uuid}`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async save(valueObject: ValueObject, data: Vendor): Promise<Vendor> {
		return (
			await axios.post<Vendor>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const vendorsApi = new VendorsApi();
