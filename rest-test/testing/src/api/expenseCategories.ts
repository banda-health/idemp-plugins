import axios from 'axios';
import { ValueObject } from '../models';
import { ExpenseCategory } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi, IDEMPIERE_ENDPOINT } from './base';

class ExpenseCategoryApi extends BaseApi<ExpenseCategory> {
	entityName = 'expensecategories';

	async getAll(valueObject: ValueObject): Promise<ExpenseCategory[]> {
		return (
			await axios.post<ExpenseCategory[]>(
				`${IDEMPIERE_ENDPOINT}/expensecategories`,
				undefined,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
	
	async save(valueObject: ValueObject, data: ExpenseCategory): Promise<ExpenseCategory> {
		return (
			await axios.post<ExpenseCategory>(`${IDEMPIERE_ENDPOINT}/${this.entityName}/save`, data, this.getAuthorizationHeaders(valueObject))
		).data;
	}
}

export const expenseCategoryApi = new ExpenseCategoryApi();
