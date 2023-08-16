import { PayerInformationFieldSuggestion } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class PayerInformationFieldSuggestionApi extends BaseApi<PayerInformationFieldSuggestion> {
	entityName = 'payment-information-field-suggestions';
}

export const payerInformationFieldSuggestionApi = new PayerInformationFieldSuggestionApi();
