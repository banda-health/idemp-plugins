import axios, { AxiosRequestConfig } from 'axios';
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
	 * Get the authorization header (needed for almost all requests)
	 * @param valueObject The value object containing the session token
	 * @returns Headers to add to a request
	 */
	protected getAuthorizationHeaders(valueObject: ValueObject): AxiosRequestConfig<any> {
		return {
			headers: { Authorization: `Bearer ${valueObject.sessionToken}` },
		};
	}

	async get(
		valueObject: ValueObject,
		page?: number,
		size?: number,
		sortJson?: string,
		filterJson?: string,
	): Promise<BaseListResponse<T>> {
		return (
			await axios.get<BaseListResponse<T>>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}?page=${page || 0}&size=${size || 1000}&sorting=${
					sortJson || ''
				}&filter=${filterJson || ''}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}

	async getByUuid(valueObject: ValueObject, uuid: string): Promise<T> {
		return (
			await axios.get<T>(`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}`, this.getAuthorizationHeaders(valueObject))
		).data;
	}

	async save(valueObject: ValueObject, data: T): Promise<T> {
		return (
			await axios.post<T>(`${IDEMPIERE_ENDPOINT}/${this.entityName}`, data, this.getAuthorizationHeaders(valueObject))
		).data;
	}

	async delete(valueObject: ValueObject, uuid: string): Promise<boolean> {
		return (
			await axios.delete<boolean>(
				`${IDEMPIERE_ENDPOINT}/${this.entityName}/${uuid}`,
				this.getAuthorizationHeaders(valueObject),
			)
		).data;
	}
}
