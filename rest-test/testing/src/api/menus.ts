import axios from 'axios';
import { BaseApi, IDEMPIERE_ENDPOINT } from '.';
import { ValueObject } from '../models';
import { BaseListResponse, Menu } from '../types/org.bandahealth.idempiere.rest';

class MenuApi extends BaseApi<Menu> {
	entityName = 'menus';

	async getByRootId(
		valueObject: ValueObject,
		rootId: string,
		page?: number,
		size?: number,
		sortJson?: string,
		filterJson?: string,
	): Promise<BaseListResponse<Menu>> {
		return (
			await axios.get<BaseListResponse<Menu>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/root/${rootId}?page=${page || ''}&size=${size || ''}&sortJson=${
					sortJson || ''
				}&filterJson=${filterJson || ''}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const menuApi = new MenuApi();
