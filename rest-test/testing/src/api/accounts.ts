import { Account } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class AccountApi extends BaseApi<Account> {
	entityName = 'accounts';
}

export const accountApi = new AccountApi();
