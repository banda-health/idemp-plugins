import { ExpenseCategory } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ExpenseCategoryApi extends BaseApi<ExpenseCategory> {
	entityName = 'expense-categories';
}

export const expenseCategoryApi = new ExpenseCategoryApi();
