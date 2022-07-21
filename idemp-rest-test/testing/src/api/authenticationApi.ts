import { Authentication, AuthResponse } from '../types/org.bandahealth.idempiere.rest';
import { IDEMPIERE_ENDPOINT, initialLoginData } from './baseApi';

class AuthenticationApi {
	/**
	 * Login with a new set of data
	 * @param loginData What data should be sent in order to log in
	 * @returns The login response
	 */
	async login(loginData?: Partial<Authentication>): Promise<AuthResponse> {
		const loginResponse = await fetch(`${IDEMPIERE_ENDPOINT}/session`, this.getRequestOptions(loginData));
		const loginInfo = await (loginResponse.json() as Promise<AuthResponse>);
		if (!loginResponse.ok || loginInfo.status !== 'OK') {
			throw new Error('could not login');
		}

		return loginInfo;
	}

	/**
	 * Get the data to send as part of a request, including headers & a method type of `POST`
	 * @param loginData What data should be sent in order to log in
	 * @returns The request information to send in a fetch request
	 */
	getRequestOptions(loginData?: Partial<Authentication>): RequestInit {
		const myHeaders = new Headers();
		myHeaders.append('Content-Type', 'application/json');
		return {
			method: 'POST',
			headers: myHeaders,
			body: JSON.stringify(loginData ?? initialLoginData),
		};
	}
}

export const authenticationApi = new AuthenticationApi();
