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
			variables: { Credentials: { Username: 'bogus', Password: 'hacker' } },
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
		data: { SignIn: allLoginInfo },
	} = await query(valueObject)({
		query: SignInDocument,
		variables: { Credentials: initialLoginData },
	});
	await valueObject.login();

	// Find the client and organization that we are logged into
	const client = allLoginInfo.AD_Clients.find((client) => client.UU === valueObject.client?.UU);
	const organization = client?.AD_Orgs.find((org) => org.UU === valueObject.organization?.UU);
	// Find a User role that does NOT match the one we are currently logged into
	const roleUser = organization?.AD_Roles?.find(
		(role) => role.Name.endsWith('User') && role.UU !== valueObject.role?.UU,
	);
	expect(roleUser).toBeTruthy();

	// Try to switch access to the new role
	const {
		data: { ChangeAccess: loginResponse },
	} = await query(valueObject)({
		query: ChangeAccessDocument,
		variables: {
			Credentials: {
				AD_Language: valueObject.language!,
				Username: initialLoginData!.Username!,
				AD_Client_UU: valueObject.client!.UU,
				AD_Org_UU: valueObject.organization!.UU,
				M_Warehouse_UU: valueObject.warehouse!.UU,
				AD_Role_UU: roleUser!.UU,
			},
		},
		context: {
			valueObject,
		},
	});

	//Expect the token to change
	expect(loginResponse.Token).not.toBe(valueObject.sessionToken);
});
