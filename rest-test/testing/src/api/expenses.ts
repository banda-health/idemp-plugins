import { Expense } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class ExpenseApi extends DocumentApi<Expense> {
	entityName = 'expenses';
}

export const expenseApi = new ExpenseApi();
