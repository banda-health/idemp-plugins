import { ReceiveProduct, Visit } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class ReceiveProductsApi extends DocumentApi<ReceiveProduct> {
	entityName = 'receive-products';
}

export const receiveProductsApi = new ReceiveProductsApi();
