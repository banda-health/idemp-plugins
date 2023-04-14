import { Charge } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ChargeApi extends BaseApi<Charge> {
	entityName = 'charges';
}

export const chargeApi = new ChargeApi();
