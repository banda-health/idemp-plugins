import { Transaction } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class TransactionApi extends DocumentApi<Transaction> {
	entityName = 'transactions';
}

export const transactionApi = new TransactionApi();
