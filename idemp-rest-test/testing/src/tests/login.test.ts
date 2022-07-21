import { authenticationApi, IDEMPIERE_ENDPOINT } from '../api';
import { AuthResponse } from '../types/org.bandahealth.idempiere.rest';

test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.errorMessage).toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeFalsy();
});

test('200 returned if wrong username/password', async () => {
	const loginResponse = await fetch(
		`${IDEMPIERE_ENDPOINT}/session`,
		authenticationApi.getRequestOptions({ username: 'bogus', password: 'hacker' }),
	);
	expect(loginResponse.status).toBe(200);
	const loginInfo = await (loginResponse.json() as Promise<AuthResponse>);
	expect(loginInfo.status).toBe('UNAUTHORIZED');
});
