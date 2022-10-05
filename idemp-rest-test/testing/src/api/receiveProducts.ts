import { ReceiveProduct } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class ReceiveProductApi extends DocumentApi<ReceiveProduct> {
	entityName = 'receiveproducts';
}

export const receiveProductApi = new ReceiveProductApi();