import { Payment } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documentApi';

class PaymentApi extends DocumentApi<Payment> {
	entityName = 'payments';
}

export const paymentApi = new PaymentApi();
