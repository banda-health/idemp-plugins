import { Account, ChargeInformationSuggestion } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ChargeInformationSuggestionApi extends BaseApi<ChargeInformationSuggestion> {
	entityName = 'charge-information-suggestions';
}

export const chargeInformationSuggestionApi = new ChargeInformationSuggestionApi();
