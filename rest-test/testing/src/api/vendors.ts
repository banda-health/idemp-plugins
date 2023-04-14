import { Vendor } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class VendorsApi extends BaseApi<Vendor> {
	entityName = 'vendors';
}

export const vendorsApi = new VendorsApi();
