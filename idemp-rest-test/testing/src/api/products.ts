import { ValueObject } from '../models';
import { Product } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './baseApi';

class ProductApi extends BaseApi<Product> {
	entityName = 'products';

	async save(valueObject: ValueObject, data: Product): Promise<Product> {
		const headers = this.getAuthorizationHeaders(valueObject);
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`, {
			method: 'POST',
			headers,
			body: JSON.stringify(data),
		});
		const result = await (response.json() as Promise<Product>);
		if (!response.ok) {
			throw new Error(`could not save ${this.entityName}`);
		}
		return result;
	}
}

export const productApi = new ProductApi();
