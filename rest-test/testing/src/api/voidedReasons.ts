import { VoidedReason } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class VoidedReasonApi extends BaseApi<VoidedReason> {
	entityName = 'voided-reasons';
}

export const voidedReasonApi = new VoidedReasonApi();
