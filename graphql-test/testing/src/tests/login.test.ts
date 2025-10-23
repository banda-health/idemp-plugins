import {
	Ad_ClientGetDocument,
	Ad_UserGetDocument,
	Ad_UserSaveDocument,
	Ad_UserWithRoleSaveDocument,
	ChangeAccessDocument,
	SignInDocument,
	SignInWithClientsDocument,
} from '../__generated__/graphql';
import { initialLoginData, mutate, query } from '../api';

test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.errorMessage).toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeFalsy();
});

test('clients can be returned on initial login object', async () => {
	expect(
		(
			await mutate(globalThis.__VALUE_OBJECT__)({
				mutation: SignInWithClientsDocument,
				variables: { Credentials: initialLoginData },
			})
		).data?.SignIn.AD_Clients?.length,
	).toBeGreaterThanOrEqual(1);
});

test('error returned if wrong username/password', async () => {
	try {
		await mutate(globalThis.__VALUE_OBJECT__)({
			mutation: SignInDocument,
			variables: { Credentials: { ...initialLoginData, Username: 'bogus', Password: 'hacker' } },
		});
		expect(true).toBe(false);
	} catch (e) {
		expect(true).toBe(true);
	}
});

test('change access call works', async () => {
	// Get a list of ALL the clients we have access to, but then log in normally
	const valueObject = globalThis.__VALUE_OBJECT__;
	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: { Credentials: initialLoginData },
	});
	const clients = (await query(valueObject)({ query: Ad_ClientGetDocument })).data.AD_ClientGet.Results;
	await valueObject.login();

	// Find the client and organization that we are logged into
	const client = clients.find((client) => client.UU === valueObject.client?.UU);
	const organization = client?.AD_Orgs.find((org) => org.UU === valueObject.organization?.UU);
	// Find a User role that does NOT match the one we are currently logged into
	const roleUser = organization?.AD_Roles?.find(
		(role) => role.Name.endsWith('User') && role.UU !== valueObject.role?.UU,
	);
	expect(roleUser).toBeTruthy();

	// Try to switch access to the new role
	const originalCookie = valueObject.sessionToken;
	await mutate(valueObject)({
		mutation: ChangeAccessDocument,
		variables: {
			Access: {
				AD_Client_UU: valueObject.client!.UU,
				AD_Org_UU: valueObject.organization!.UU,
				M_Warehouse_UU: valueObject.warehouse!.UU,
				AD_Role_UU: roleUser!.UU,
			},
		},
	});

	//Expect the token to change
	expect(valueObject.sessionToken).not.toBe(originalCookie);
});

test('user is locked after multiple failed login attempts', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Create a test user with a password
	const testUserName = `test_user_lockout_${Date.now()}`;
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: {
				UU: `test-user-lockout-${Date.now()}`,
				Name: testUserName,
				IsActive: true,
				Password: 'testpassword123',
			},
			AD_User_Roles: [], // Empty roles array for simplicity
		},
	});

	// Get the created user and set FailedLoginCount to 4 (above the threshold of 3)
	const createdUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ name: testUserName }) },
		})
	).data.AD_UserGet.Results[0];
	expect(createdUser).toBeTruthy();

	// Set the failed login count to 4 to simulate multiple failed attempts
	await mutate(valueObject)({
		mutation: Ad_UserSaveDocument,
		variables: {
			AD_User: {
				UU: createdUser.UU,
				FailedLoginCount: 4,
			},
		},
	});

	// Now try to login with correct credentials - should be blocked due to too many failed attempts
	try {
		await mutate(valueObject)({
			mutation: SignInDocument,
			variables: { Credentials: { Username: testUserName, Password: 'testpassword123', AD_Language: 'en_US' } },
		});
		expect(true).toBe(false); // Should not reach here
	} catch (e: any) {
		expect(e.message).toContain('Account temporarily locked due to multiple failed login attempts');
	}
});
