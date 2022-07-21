import { Invoice } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documentApi';

class InvoiceApi extends DocumentApi<Invoice> {
	entityName = 'invoices';
}

export const invoiceApi = new InvoiceApi();
