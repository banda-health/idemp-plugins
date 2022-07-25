import { ValueObject } from '../models';
import { Authentication, BaseListResponse } from '../types/org.bandahealth.idempiere.rest';

export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/BHGO/services/rs/auth`;

export const initialLoginData: Partial<Authentication> = {
	username: process.env.IDEMPIERE_USER || 'SuperUser',
	password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	language: 'en_US',
} as const;

/**
 * An abstract class containing base logic for connecting to the API and getting data back
 */
export abstract class BaseApi<T> {
	abstract entityName: string;

	/**
	 * Get the default headers plus an authorization header (needed for almost all requests)
	 * @param valueObject The value object containing the session token
	 * @returns Headers to add to a fetch request
	 */
	protected getAuthorizationHeaders(valueObject: ValueObject) {
		const headers = new Headers();
		headers.append('Content-Type', 'application/json');
		headers.append('Authorization', `Bearer ${valueObject.sessionToken}`);
		return headers;
	}

	async get(
		valueObject: ValueObject,
		page?: number,
		size?: number,
		sortJson?: string,
		filterJson?: string,
	): Promise<BaseListResponse<T>> {
		const response = await fetch(
			`${IDEMPIERE_ENDPOINT}/${this.entityName}?page=${page || ''}&size=${size || ''}&sortJson=${
				sortJson || ''
			}&filterJson=${filterJson || ''}`,
			{
				method: 'GET',
				headers: this.getAuthorizationHeaders(valueObject),
			},
		);
		if (!response.ok) {
			console.log(response);
			throw new Error(`could not get ${this.entityName}`);
		}
		const results = await (response.json() as Promise<BaseListResponse<T>>);
		return results;
	}

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<T> {
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}`, {
			method: 'GET',
			headers: this.getAuthorizationHeaders(valueObject),
		});
		if (!response.ok) {
			console.log(response);
			throw new Error(`could not get single ${this.entityName}`);
		}
		const result = await (response.json() as Promise<T>);
		return result;
	}

	async save(valueObject: ValueObject, data: T): Promise<T> {
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}`, {
			method: 'POST',
			headers: this.getAuthorizationHeaders(valueObject),
			body: JSON.stringify(data),
		});
		if (!response.ok) {
			console.log(response);
			throw new Error(`could not save ${this.entityName}`);
		}
		const result = await (response.json() as Promise<T>);
		return result;
	}

	async delete(valueObject: ValueObject, uuid: string): Promise<boolean> {
		const response = await fetch(`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}`, {
			method: 'DELETE',
			headers: this.getAuthorizationHeaders(valueObject),
		});
		if (!response.ok) {
			console.log(response);
			throw new Error(`could not delete ${this.entityName}`);
		}
		const result = await (response.json() as Promise<boolean>);
		return result;
	}
}
