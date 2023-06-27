import axios from 'axios';
import { ValueObject } from '../models';
import { BaseListResponse, Charge } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ChargeApi extends BaseApi<Charge> {
	entityName = 'charges';

	async getNonPatientPayments(
		valueObject: ValueObject,
		page?: number,
		size?: number,
		sortJson?: string,
		filterJson?: string,
	): Promise<BaseListResponse<Charge>> {
		return (
			await axios.get<BaseListResponse<Charge>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/non-patient-payments?page=${page || 0}&size=${size || 1000}&sorting=${
					sortJson || ''
				}&filter=${filterJson || ''}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const chargeApi = new ChargeApi();
