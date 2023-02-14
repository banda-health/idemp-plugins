import axios, { AxiosError, AxiosRequestConfig } from 'axios';
import { ValueObject } from '../models';
import { Authentication, BaseListResponse } from '../types/org.bandahealth.idempiere.rest';

export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/BHGO/services/rs/auth`;

export const initialLoginData: Partial<Authentication> = {
	username: process.env.IDEMPIERE_USER || 'SuperUser',
	password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	language: 'en_US',
} as const;

/**
 * Axios does a poor job showing where errors are thrown. This is an attempt to allow the stack trace
 * to be as close to the call as possible. We'll log a new error per request URL (meaning we can have
 * issues if we have tests running in parallel, which they aren't in the CI pipeline) and, if an error
 * was thrown by the request, we'll use the stack trace of the error for that call.
 */
let errorTracker: { [route: string]: Error | undefined } = {};
axios.interceptors.request.use((config) => {
	// Create an error close to the calling code
	errorTracker[config.baseURL!] = new Error();
	return config;
});
axios.interceptors.response.use(
	(response) => response,
	(error: Error | AxiosError) => {
		// If this is an Axios error, we'll use our own error tracking
		if (axios.isAxiosError(error)) {
			error.stack = errorTracker[error.config!.baseURL!]?.stack;
		}
		throw error;
	},
);

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
