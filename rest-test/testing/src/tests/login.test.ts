import { authenticationApi, initialLoginData } from '../api';

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

test('change access call works', async () => {
	// Get a list of ALL the clients we have access to, but then log in normally
	const allLoginInfo = await authenticationApi.login();
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Find the client and organization that we are logged into
	const client = allLoginInfo.clients.find((client) => client.uuid === valueObject.client?.uuid);
	const organization = client?.organizations.find((org) => org.uuid === valueObject.organization?.uuid);
	// Find a User role that does NOT match the one we are currently logged into
	const roleUser = organization?.roles.find((role) => role.name.endsWith('User') && role.uuid !== valueObject.role?.uuid)
	expect(roleUser).toBeTruthy();

	// Try to switch access to the new role
	const loginResponse = await authenticationApi.changeAccess({
		language: valueObject.language!,
		username: initialLoginData!.username!,
	 	clientUuid: valueObject.client!.uuid,
		organizationUuid: valueObject.organization!.uuid,
		warehouseUuid: valueObject.warehouse!.uuid,
		roleUuid: roleUser!.uuid
	});

	expect(loginResponse.status).toBe('OK');
	expect(loginResponse.clientUuid).toBe(valueObject.client?.uuid);
	expect(loginResponse.organizationUuid).toBe(valueObject.organization?.uuid);
	expect(loginResponse.warehouseUuid).toBe(valueObject.warehouse?.uuid);
	//Expect the token to change
	expect(loginResponse.token).not.toBe(valueObject.sessionToken);
	expect(loginResponse.roleUuid).toBe(roleUser?.uuid);
});
