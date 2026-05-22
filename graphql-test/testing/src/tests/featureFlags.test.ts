import { v4 as uuidv4 } from 'uuid';
import {
	Ad_ClientGetDocument,
	Ad_SystemGetDocument,
	Ad_UserGetDocument,
	Ad_UserWithRoleSaveDocument,
	Bh_Feature_FlagDeleteDocument,
	Bh_Feature_FlagSaveDocument,
	Bh_Feature_Flag_RuleDeleteDocument,
	Bh_Feature_Flag_RuleSaveDocument,
	ChangeAccessDocument,
	FeatureFlagsDocument,
	SignInDocument,
} from '../__generated__/graphql';
import { initialLoginData, mutate, query } from '../api';
import { ValueObject } from '../models';
import { RoleName } from '../types/roleName';

/** Matches X_BH_Feature_Flag_RuleResolver.BH_ENVIRONMENT_UUIDS_BY_VALUE */
const FEATURE_FLAG_ENVIRONMENT_UUID_BY_VALUE: Record<string, string> = {
	E: '80ee3010-2e49-4aa8-934e-2c5662b1b70d',
	I: 'd3239ec8-bbdc-42c3-997b-c3be8d89d914',
	P: '1b3201b9-d2a4-4101-a4a0-a53571550f32',
};

type TestSessionContext = {
	client: NonNullable<(ValueObject)['client']>;
	organization: NonNullable<(ValueObject)['organization']>;
	role: NonNullable<(ValueObject)['role']>;
	warehouse: NonNullable<(ValueObject)['warehouse']>;
};

async function getFeatureFlags(valueObject: ValueObject) {
	return JSON.parse(
		(
			await query(valueObject)({
				query: FeatureFlagsDocument,
			})
		).data!.FeatureFlags as string,
	) as Record<string, boolean>;
}

async function loginAsSystemAdministrator(valueObject: ValueObject) {
	const { client, organization, role, warehouse, user } = valueObject;
	valueObject.logout();
	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: { Credentials: initialLoginData },
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after sign in');
	}

	const clients = (await query(valueObject)({ query: Ad_ClientGetDocument })).data.AD_ClientGet.Results;
	const systemClient = clients.find((availableClient) => availableClient.Name === 'System');
	if (!systemClient) {
		throw new Error('could not find System client');
	}
	const systemOrganization = systemClient.AD_Orgs[0];
	if (!systemOrganization) {
		throw new Error('System client had no organizations');
	}
	const systemAdministratorRole = systemOrganization.AD_Roles?.find(
		(availableRole) => availableRole.Name === 'System Administrator',
	);
	if (!systemAdministratorRole) {
		throw new Error('could not find System Administrator role');
	}

	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: {
			Credentials: {
				...initialLoginData,
				AD_Client_UU: systemClient.UU,
				AD_Org_UU: systemOrganization.UU,
				AD_Role_UU: systemAdministratorRole.UU,
			},
		},
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after system administrator sign in');
	}

	// Keep test client context on the value object for feature flag rules targeting the test client
	valueObject.client = client;
	valueObject.organization = organization;
	valueObject.role = role;
	valueObject.warehouse = warehouse;
	valueObject.user = user;
}

function saveTestContext(valueObject: ValueObject): TestSessionContext {
	if (!valueObject.client || !valueObject.organization || !valueObject.role || !valueObject.warehouse) {
		throw new Error('test session context is incomplete');
	}
	return {
		client: valueObject.client,
		organization: valueObject.organization,
		role: valueObject.role,
		warehouse: valueObject.warehouse,
	};
}

function findRoleByName(client: TestSessionContext['client'], roleName: RoleName) {
	const role = client.AD_Orgs.flatMap((organization) => organization.AD_Roles || []).find((availableRole) =>
		availableRole.Name.endsWith(roleName),
	);
	if (!role) {
		throw new Error(`could not find role ending with ${roleName}`);
	}
	return role;
}

async function createTestUser(valueObject: ValueObject, roleUU: string) {
	const userUuid = uuidv4();
	const userName = `ff_test_${valueObject.random}_${userUuid.slice(0, 8)}`;
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { UU: userUuid, Name: userName, IsActive: true, Password: '123' },
			AD_User_Roles: [{ AD_User: { UU: userUuid }, AD_Role: { UU: roleUU } }],
		},
	});
	const user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: userUuid }) },
		})
	).data.AD_UserGet.Results[0];
	if (!user) {
		throw new Error('could not find created test user');
	}
	return user;
}

async function getServerSystemStatusValue(valueObject: ValueObject) {
	return (
		await query(valueObject)({
			query: Ad_SystemGetDocument,
			variables: { Size: 1 },
		})
	).data.AD_SystemGet.Results[0]?.SystemStatus?.Value;
}

function getMismatchedEnvironmentUuid(serverSystemStatus: string | null | undefined) {
	const mismatchedEntry = Object.entries(FEATURE_FLAG_ENVIRONMENT_UUID_BY_VALUE).find(
		([value]) => value !== serverSystemStatus,
	);
	if (!mismatchedEntry) {
		throw new Error(`could not find environment UUID mismatching server status ${serverSystemStatus}`);
	}
	return mismatchedEntry[1];
}

async function loginAsTestUser(
	valueObject: ValueObject,
	user: { Name: string },
	roleUU: string,
	testContext: TestSessionContext,
) {
	valueObject.logout();
	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: { Credentials: { ...initialLoginData, Username: user.Name, Password: '123' } },
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after test user sign in');
	}
	await mutate(valueObject)({
		mutation: ChangeAccessDocument,
		variables: {
			Access: {
				AD_Client_UU: testContext.client.UU,
				AD_Org_UU: testContext.organization.UU,
				AD_Role_UU: roleUU,
				M_Warehouse_UU: testContext.warehouse.UU,
			},
		},
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after test user change access');
	}
}

/** SuperUser on the test client (logout clears client/org, so valueObject.login() cannot be used after loginAsTestUser). */
async function loginAsSuperUserOnTestClient(valueObject: ValueObject, testContext: TestSessionContext) {
	valueObject.logout();
	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: { Credentials: initialLoginData },
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after SuperUser sign in');
	}
	await mutate(valueObject)({
		mutation: ChangeAccessDocument,
		variables: {
			Access: {
				AD_Client_UU: testContext.client.UU,
				AD_Org_UU: testContext.organization.UU,
				AD_Role_UU: testContext.role.UU,
				M_Warehouse_UU: testContext.warehouse.UU,
			},
		},
	});
	if (!valueObject.sessionToken) {
		throw new Error('no session token after SuperUser change access');
	}
	valueObject.client = testContext.client;
	valueObject.organization = testContext.organization;
	valueObject.role = testContext.role;
	valueObject.warehouse = testContext.warehouse;
}

function buildFeatureFlagEntity(valueObject: ValueObject, flagKey: string) {
	return {
		BH_DefaultEnabled: false,
		BH_FlagType: 'release',
		Description: valueObject.getStepMessageLong(),
		IsActive: true,
		Name: flagKey,
	};
}

function buildFeatureFlagRuleBase(valueObject: ValueObject, seqNo = 10) {
	return {
		BH_SystemAdmin: false,
		IsActive: true,
		Name: valueObject.getStepMessageLong(),
		SeqNo: seqNo,
	};
}

async function expectForbiddenMutation(
	valueObject: ValueObject,
	mutation: Parameters<ReturnType<typeof mutate>>[0],
	expectedMessage: RegExp = /Access denied for table: BH_Feature_Flag/,
) {
	let error: Error | undefined;
	try {
		await mutate(valueObject)(mutation);
		expect(true).toBe(false);
	} catch (caughtError) {
		error = caughtError as Error;
	}
	expect(error).toBeDefined();
	expect(error?.message).toMatch(expectedMessage);
}

test('FeatureFlags returns a JSON object for the current session', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const featureFlags = await getFeatureFlags(valueObject);
	expect(featureFlags).toEqual(expect.any(Object));
});

test('only system administrators can save or delete feature flags', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_auth_forbidden_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: { Entity: buildFeatureFlagEntity(valueObject, flagKey) },
		})
	).data!.BH_Feature_FlagSave.UU;

	try {
		await valueObject.login(RoleName.ClinicAdmin);

		await expectForbiddenMutation(valueObject, {
			mutation: Bh_Feature_FlagSaveDocument,
			variables: { Entity: buildFeatureFlagEntity(valueObject, `${flagKey}_other`) },
		});

		await expectForbiddenMutation(valueObject, {
			mutation: Bh_Feature_FlagDeleteDocument,
			variables: { UUs: [flagUU] },
		});

		await expectForbiddenMutation(valueObject, {
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
				},
			},
		});

		await expectForbiddenMutation(valueObject, {
			mutation: Bh_Feature_Flag_RuleDeleteDocument,
			variables: { UUs: [uuidv4()] },
		});
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('system administrators can save and delete feature flags', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_auth_allowed_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: { Entity: { ...buildFeatureFlagEntity(valueObject, flagKey), BH_DefaultEnabled: true } },
		})
	).data!.BH_Feature_FlagSave.UU;

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
	await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
});

test('feature flag uses default when no rule matches', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_default_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: true,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
					Description: valueObject.getStepMessageLong(),
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	try {
		const featureFlags = await getFeatureFlags(valueObject);
		expect(featureFlags[flagKey]).toBe(true);
	} finally {
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('feature flag rule can enable a flag for the current client', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const testUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_client_rule_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					Description: valueObject.getStepMessageLong(),
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	let ruleUU: string | undefined;
	try {
		await loginAsTestUser(valueObject, testUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);

		await loginAsSystemAdministrator(valueObject);
		ruleUU = (
			await mutate(valueObject)({
				mutation: Bh_Feature_Flag_RuleSaveDocument,
				variables: {
					Entity: {
						...buildFeatureFlagRuleBase(valueObject),
						BH_Feature_Flag: { UU: flagUU },
						BH_IsEnabled: true,
						BH_Rule_Client: { UU: testContext.client.UU },
					},
				},
			})
		).data!.BH_Feature_Flag_RuleSave.UU;

		await loginAsTestUser(valueObject, testUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		if (ruleUU) {
			await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		}
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('more specific rule overrides a general client rule', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const testUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_specificity_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					Description: valueObject.getStepMessageLong(),
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const clientRuleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	const roleRuleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject, 20),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: false,
					BH_Rule_Role: { UU: testContext.role.UU },
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, testUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleDeleteDocument,
			variables: { UUs: [roleRuleUU, clientRuleUU] },
		});
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('environment rule does not apply when rule environment does not match server environment', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const testUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_environment_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const mismatchedEnvironmentUuid = getMismatchedEnvironmentUuid(await getServerSystemStatusValue(valueObject));

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Environment: { UU: mismatchedEnvironmentUuid },
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, testUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('feature flag is disabled for a different role when a role-specific rule exists', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const cashierRole = findRoleByName(testContext.client, RoleName.CashierRegistrationBasic);
	const adminUser = await createTestUser(valueObject, adminRole.UU);
	const cashierUser = await createTestUser(valueObject, cashierRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_role_mismatch_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
					BH_Rule_Client: { UU: testContext.client.UU },
					BH_Rule_Role: { UU: testContext.role.UU },
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, adminUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);

		await loginAsTestUser(valueObject, cashierUser, cashierRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('feature flag is disabled for a different user when a user-specific rule exists', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const targetedUser = await createTestUser(valueObject, adminRole.UU);
	const otherUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_user_mismatch_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
					BH_Rule_Client: { UU: testContext.client.UU },
					BH_Rule_User: { UU: targetedUser.UU },
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, targetedUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);

		await loginAsTestUser(valueObject, otherUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('feature flag system admin rule only applies to system administrators on test client', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const nonAdminUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_system_admin_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
					BH_Rule_Client: { UU: testContext.client.UU },
					BH_SystemAdmin: true,
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, nonAdminUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(false);

		await loginAsSuperUserOnTestClient(valueObject, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});

test('feature flag rule with system admin off applies to non-administrators on test client', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	const testContext = saveTestContext(valueObject);
	const adminRole = findRoleByName(testContext.client, RoleName.Admin);
	const nonAdminUser = await createTestUser(valueObject, adminRole.UU);

	await loginAsSystemAdministrator(valueObject);

	const flagKey = `test_flag_system_admin_off_${valueObject.random}`;
	const flagUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_FlagSaveDocument,
			variables: {
				Entity: {
					BH_DefaultEnabled: false,
					BH_FlagType: 'release',
					IsActive: true,
					Name: flagKey,
				},
			},
		})
	).data!.BH_Feature_FlagSave.UU;

	const ruleUU = (
		await mutate(valueObject)({
			mutation: Bh_Feature_Flag_RuleSaveDocument,
			variables: {
				Entity: {
					...buildFeatureFlagRuleBase(valueObject),
					BH_Feature_Flag: { UU: flagUU },
					BH_IsEnabled: true,
					BH_Rule_Client: { UU: testContext.client.UU },
				},
			},
		})
	).data!.BH_Feature_Flag_RuleSave.UU;

	try {
		await loginAsTestUser(valueObject, nonAdminUser, adminRole.UU, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);

		await loginAsSuperUserOnTestClient(valueObject, testContext);
		expect((await getFeatureFlags(valueObject))[flagKey]).toBe(true);
	} finally {
		await loginAsSystemAdministrator(valueObject);
		await mutate(valueObject)({ mutation: Bh_Feature_Flag_RuleDeleteDocument, variables: { UUs: [ruleUU] } });
		await mutate(valueObject)({ mutation: Bh_Feature_FlagDeleteDocument, variables: { UUs: [flagUU] } });
	}
});
