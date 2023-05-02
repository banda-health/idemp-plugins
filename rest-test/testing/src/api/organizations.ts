import { Organization } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class OrganizationApi extends BaseApi<Organization> {
	entityName = 'organizations';
}

export const organizationApi = new OrganizationApi();
