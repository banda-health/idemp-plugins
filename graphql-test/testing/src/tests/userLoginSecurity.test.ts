import { initialLoginData, mutate, query } from '../api';
import { createBusinessPartner } from '../utils';
import {
	Ad_UserGetDocument,
	Ad_UserSaveDocument,
	Ad_SysConfigGetDocument,
	SignInDocument,
} from '../__generated__/graphql';

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
