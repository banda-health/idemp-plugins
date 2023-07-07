import axios from 'axios';
import { Authentication, AuthResponse } from '../types/org.bandahealth.idempiere.rest';
import { IDEMPIERE_ENDPOINT, initialLoginData } from './base';

class AuthenticationApi {
	/**
	 * Login with a new set of data
	 * @param loginData What data should be sent in order to log in
	 * @returns The login response
	 */
	async login(loginData?: Partial<Authentication>): Promise<AuthResponse> {
		return (
			await axios.post<AuthResponse>(`${IDEMPIERE_ENDPOINT}/session`, {
				...initialLoginData,
				...(loginData ?? initialLoginData),
			})
		).data;
	}
	/**
	 * Login with a new set of data
	 * @param loginData What data should be sent in order to log in
	 * @returns The login response
	 */
	async changePassword(
		loginData: Pick<Authentication, 'username' | 'newPassword' | 'password'>,
	): Promise<AuthResponse> {
		return (
			await axios.post<AuthResponse>(`${IDEMPIERE_ENDPOINT}/session/change-password`, {
				...initialLoginData,
				...loginData,
			})
		).data;
	}
}

export const authenticationApi = new AuthenticationApi();
