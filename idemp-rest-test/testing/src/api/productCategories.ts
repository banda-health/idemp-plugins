import axios from 'axios';
import { ValueObject } from '../models';
import { ProductCategory } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ProductCategoryApi extends BaseApi<ProductCategory> {
	entityName = 'productcategories';

	async getAll(valueObject: ValueObject): Promise<ProductCategory[]> {
		return (
			await axios.post<ProductCategory[]>(
				`${IDEMPIERE_ENDPOINT}/productcategories`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const productCategoryApi = new ProductCategoryApi();
