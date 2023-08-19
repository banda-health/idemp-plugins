import { PayerInformationFieldSuggestion } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class PayerInformationFieldSuggestionApi extends BaseApi<PayerInformationFieldSuggestion> {
	entityName = 'payer-information-field-suggestions';
}

export const payerInformationFieldSuggestionApi = new PayerInformationFieldSuggestionApi();
