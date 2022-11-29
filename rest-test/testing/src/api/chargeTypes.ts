import { ChargeType } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ChargeTypeApi extends BaseApi<ChargeType> {
	entityName = 'charge-types';
}

export const chargeTypeApi = new ChargeTypeApi();
