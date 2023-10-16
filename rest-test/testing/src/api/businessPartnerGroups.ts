import { BusinessPartnerGroup } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class BusinessPartnerGroupApi extends BaseApi<BusinessPartnerGroup> {
	entityName = 'business-partner-groups';
}

export const businessPartnerGroupApi = new BusinessPartnerGroupApi();
