import axios from 'axios';
import { ValueObject } from '../models';
import { Vendor } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class VendorApi extends BaseApi<Vendor> {
	entityName = 'vendors';

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

export const vendorApi = new VendorApi();