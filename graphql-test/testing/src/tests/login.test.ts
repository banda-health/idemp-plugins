import { initialLoginData, query } from '../api';
import { ChangeAccessDocument, SignInDocument } from '../__generated__/graphql';

test('can login', async () => {
	await globalThis.__VALUE_OBJECT__.login();
	expect(globalThis.__VALUE_OBJECT__.errorMessage).toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.client).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.organization).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.role).not.toBeFalsy();
	expect(globalThis.__VALUE_OBJECT__.warehouse).not.toBeFalsy();
});

test('error returned if wrong username/password', async () => {
	try {
		await query(globalThis.__VALUE_OBJECT__)({
			query: SignInDocument,
			variables: { credentials: { username: 'bogus', password: 'hacker' } },
		});
		expect(true).toBe(false);
	} catch (e) {
		expect(true).toBe(true);
	}
});

test('change access call works', async () => {
	// Get a list of ALL the clients we have access to, but then log in normally
	const valueObject = globalThis.__VALUE_OBJECT__;
	const {
		data: { signIn: allLoginInfo },
	} = await query(valueObject)({
		query: SignInDocument,
		variables: { credentials: initialLoginData },
	});
	await valueObject.login();

	// Find the client and organization that we are logged into
	const client = allLoginInfo.AD_Clients.find((client) => client.UUID === valueObject.client?.UUID);
	const organization = client?.AD_Orgs.find((org) => org.UUID === valueObject.organization?.UUID);
	// Find a User role that does NOT match the one we are currently logged into
	const roleUser = organization?.AD_Roles?.find(
		(role) => role.Name.endsWith('User') && role.UUID !== valueObject.role?.UUID,
	);
	expect(roleUser).toBeTruthy();

	// Try to switch access to the new role
	const {
		data: { changeAccess: loginResponse },
	} = await query(valueObject)({
		query: ChangeAccessDocument,
		variables: {
			credentials: {
				language: valueObject.language!,
				username: initialLoginData!.username!,
				clientUuid: valueObject.client!.UUID,
				organizationUuid: valueObject.organization!.UUID,
				warehouseUuid: valueObject.warehouse!.UUID,
				roleUuid: roleUser!.UUID,
			},
		},
		context: {
			valueObject,
		},
	});

	//Expect the token to change
	expect(loginResponse.token).not.toBe(valueObject.sessionToken);
});
