import { ProductCategory } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ProductCategoryApi extends BaseApi<ProductCategory> {
	entityName = 'product-categories';
}

export const productCategoryApi = new ProductCategoryApi();
