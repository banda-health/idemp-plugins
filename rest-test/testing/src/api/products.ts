import axios from 'axios';
import { ValueObject } from '../models';
import { Product } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ProductApi extends BaseApi<Product> {
	entityName = 'products';

	async save(valueObject: ValueObject, data: Product): Promise<Product> {
		const headers = this.getAuthorizationHeaders(valueObject);
		return (
			await axios.post<Product>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`,
				data,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}

export const productApi = new ProductApi();
