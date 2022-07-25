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
		const response = await fetch(
			`${IDEMPIERE_ENDPOINT}/${this.entityName}/root/${rootId}?page=${page || ''}&size=${size || ''}&sortJson=${
				sortJson || ''
			}&filterJson=${filterJson || ''}`,
			{
				method: 'GET',
				headers: this.getAuthorizationHeaders(valueObject),
			},
		);
		const results = await (response.json() as Promise<BaseListResponse<Menu>>);
		if (!response.ok) {
			throw new Error(`could not get ${this.entityName}`);
		}
		return results;
	}
}

export const menuApi = new MenuApi();
