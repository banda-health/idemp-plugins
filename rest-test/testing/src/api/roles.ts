import { Role } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class RoleApi extends BaseApi<Role> {
	entityName = 'roles';
}

export const roleApi = new RoleApi();
