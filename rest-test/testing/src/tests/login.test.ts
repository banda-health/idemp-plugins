import { authenticationApi } from '../api';

test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.errorMessage).toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeFalsy();
});

test('ok response returned if wrong username/password', async () => {
	const loginResponse = await authenticationApi.login({ username: 'bogus', password: 'hacker' });
	expect(loginResponse.status).toBe('UNAUTHORIZED');
});
