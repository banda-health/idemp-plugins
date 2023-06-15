import { User } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class UserApi extends BaseApi<User> {
	entityName = 'users';
}

export const userApi = new UserApi();
