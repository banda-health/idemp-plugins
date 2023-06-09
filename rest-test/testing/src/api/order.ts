import { Order } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class OrderApi extends DocumentApi<Order> {
	entityName = 'orders';
}

export const orderApi = new OrderApi();
