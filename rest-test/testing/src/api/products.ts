import axios from 'axios';
import { ValueObject } from '../models';
import { BaseListResponse, Product } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ProductApi extends BaseApi<Product> {
	entityName = 'products';

	async searchProductsAndServices(valueObject: ValueObject, query: string): Promise<BaseListResponse<Product>> {
		return (
			await axios.get<BaseListResponse<Product>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/search/items?value=${query}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const productApi = new ProductApi();
