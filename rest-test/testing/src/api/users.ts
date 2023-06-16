import axios from 'axios';
import { ValueObject } from '../models';
import { BaseListResponse, User } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class UserApi extends BaseApi<User> {
	entityName = 'users';

	async getNonAdmins(
		valueObject: ValueObject,
		page?: number,
		size?: number,
		sortJson?: string,
		filterJson?: string,
	): Promise<BaseListResponse<User>> {
		return (
			await axios.get<BaseListResponse<User>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/non-admins?page=${page || 0}&size=${size || 1000}&sorting=${
					sortJson || ''
				}&filter=${filterJson || ''}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const userApi = new UserApi();
