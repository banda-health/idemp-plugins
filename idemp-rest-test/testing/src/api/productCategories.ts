import { ValueObject } from '../models';
import { ProductCategory } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './baseApi';

class ProductCategoryApi extends BaseApi<ProductCategory> {
	entityName = 'productcategories';

	async getAll(valueObject: ValueObject): Promise<ProductCategory[]> {
		const createInvoiceResponse = await fetch(`${IDEMPIERE_ENDPOINT}/productcategories`, {
			method: 'POST',
			headers: this.getAuthorizationHeaders(valueObject),
		});
		const results = await (createInvoiceResponse.json() as Promise<ProductCategory[]>);
		if (!createInvoiceResponse.ok) {
			throw new Error('could not fetch product categories');
		}
		return results;
	}
}

export const productCategoryApi = new ProductCategoryApi();
