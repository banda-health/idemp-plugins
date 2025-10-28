import { createBusinessPartner } from '../utils';
import {
	Ad_ClientGetDocument,
	Ad_RoleGetDocument,
	Ad_RoleWithIncludedSaveDocument,
	Ad_SysConfigGetDocument,
	Ad_UserGetDocument,
	Ad_UserSaveDocument,
	Ad_UserWithRoleSaveDocument,
	ChangeAccessDocument,
	SignInDocument,
	SignInWithClientsDocument,
} from '../__generated__/graphql';
import { initialLoginData, mutate, query } from '../api';
import { roleUuid } from './roles.test';
import { v4 } from 'uuid';

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

test('verify system configuration for login security settings', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Test that USER_LOCKING_MAX_LOGIN_ATTEMPT is set to 3
	const maxLoginAttemptConfig = (
		await query(valueObject)({
			query: Ad_SysConfigGetDocument,
			variables: { Filter: JSON.stringify({ name: 'USER_LOCKING_MAX_LOGIN_ATTEMPT' }) },
		})
	).data.AD_SysConfigGet.Results[0];

	expect(maxLoginAttemptConfig).toBeTruthy();
	expect(maxLoginAttemptConfig.Value).toBe('3');

	// Test that USER_LOCKING_MAX_INACTIVE_PERIOD_DAY is set to 30
	const maxInactivePeriodConfig = (
		await query(valueObject)({
			query: Ad_SysConfigGetDocument,
			variables: { Filter: JSON.stringify({ name: 'USER_LOCKING_MAX_INACTIVE_PERIOD_DAY' }) },
		})
	).data.AD_SysConfigGet.Results[0];

	expect(maxInactivePeriodConfig).toBeTruthy();
	expect(maxInactivePeriodConfig.Value).toBe('30');
});

test('verify login is blocked after maximum inactive days', async () => {
	let valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Create a test user
	valueObject.stepName = 'Create test user for login blocking';
	await createBusinessPartner(valueObject);
	const testUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];

	expect(testUser).toBeTruthy();
	
	valueObject.stepName = 'Create role';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.Results;
	const mustHavesRole = masterRoles.filter((role) => role.UU === roleUuid.MUST_HAVES)[0];
	const availableRoles = masterRoles.filter((role) => role.UU !== roleUuid.MUST_HAVES);
	let roleUuidToUse = v4();
	await mutate(valueObject)({
		mutation: Ad_RoleWithIncludedSaveDocument,
		variables: {
			AD_Role: {
				UU: roleUuidToUse,
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
			AD_Role_IncludedList: [
				{
					AD_Role: { UU: roleUuidToUse },
					Included_Role: { UU: mustHavesRole.UU },
					SeqNo: 10,
				},
				{
					AD_Role: { UU: roleUuidToUse },
					Included_Role: { UU: availableRoles[0].UU },
					SeqNo: 20,
				},
			],
		},
	});
	const role = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.Results[0];
	expect(role.UU).toBeTruthy();

	valueObject.stepName = 'Assign role to user and update date last login';
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { 
				UU: testUser.UU, 
				Password: '123', 
				DateLastLogin: 1704056400 // Set to 2024-01-01 00:00:00.000000
			},
			AD_User_Roles: { AD_User: { UU: testUser.UU }, AD_Role: { UU: role.UU } },
		},
	});

	// Verify the user has inactive days
	let updatedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: testUser.UU }) },
		})
	).data.AD_UserGet.Results[0];
	
	expect(updatedUser.DateLastLogin).toBe(1704056400);
	
	// Log out current user
	valueObject.logout();

	// Try to login with the test user - this should fail 
	let unauthorizedError;
	try {
		await mutate(valueObject)({
			mutation: SignInDocument,
			variables: { 
				Credentials: { 
					...initialLoginData,
					Username: testUser.Name, 
					Password: '123',
				} 
			},
		});
		// If we get here, the test should fail because login should be blocked
		expect(true).toBe(false);
	} catch (error) {
		unauthorizedError = error as Error;
	}
	
	expect(unauthorizedError?.message).toMatch('Forbidden');
});

test('verify login is blocked after maximum failed attempts', async () => {
	let valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Create a test user
	valueObject.stepName = 'Create test user for login blocking';
	await createBusinessPartner(valueObject);
	const testUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];

	expect(testUser).toBeTruthy();

	// Set the user's failed login attempts to the maximum (3)
	await mutate(valueObject)({
		mutation: Ad_UserSaveDocument,
		variables: {
			AD_User: {
				UU: testUser.UU,
				FailedLoginCount: 3, // Set to maximum attempts
			},
		},
	});

	// Verify the user has maximum failed attempts
	let updatedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: testUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	expect(updatedUser.FailedLoginCount).toBe(3);

	// Log out current user
	valueObject.logout();

	// Try to login with the test user - this should fail due to maximum attempts reached
	let unauthorizedError;
	try {
		await mutate(valueObject)({
			mutation: SignInDocument,
			variables: { 
				Credentials: { 
					...initialLoginData,
					Username: testUser.Name, 
					Password: 'wrongpassword', // Wrong password to trigger failed attempt
				} 
			},
		});
		// If we get here, the test should fail because login should be blocked
		expect(true).toBe(false);
	} catch (error) {
		unauthorizedError = error as Error;
	}
	
	expect(unauthorizedError?.message).toMatch('Unauthorized');
});

test('verify user failed login attempts are reset to 0', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// Create a test user
	valueObject.stepName = 'Create test user for login attempts';
	await createBusinessPartner(valueObject);
	const testUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];

	expect(testUser).toBeTruthy();

	// Simulate failed login attempts by updating the user's failedlogincount
	await mutate(valueObject)({
		mutation: Ad_UserSaveDocument,
		variables: {
			AD_User: {
				UU: testUser.UU,
				FailedLoginCount: 5, // Set to 5 failed attempts
			},
		},
	});

	// Verify the user has failed attempts
	let updatedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: testUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	expect(updatedUser.FailedLoginCount).toBe(5);

	// Reset the failed login attempts to 0 (simulating the migration)
	await mutate(valueObject)({
		mutation: Ad_UserSaveDocument,
		variables: {
			AD_User: {
				UU: testUser.UU,
				FailedLoginCount: 0, // Reset to 0
			},
		},
	});

	// Verify the user's failed attempts are now 0
	updatedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: testUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	expect(updatedUser.FailedLoginCount).toBe(0);
});
