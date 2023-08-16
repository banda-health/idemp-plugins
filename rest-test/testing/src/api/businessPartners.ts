import { BusinessPartner } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class BusinessPartnerApi extends BaseApi<BusinessPartner> {
	entityName = 'business-partners';
}

export const businessPartnerApi = new BusinessPartnerApi();
