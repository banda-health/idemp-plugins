import { Service } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ServiceApi extends BaseApi<Service> {
	entityName = 'bh-services';
}

export const serviceApi = new ServiceApi();
