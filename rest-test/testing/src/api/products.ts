import { Product } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ProductApi extends BaseApi<Product> {
	entityName = 'products';
}

export const productApi = new ProductApi();
