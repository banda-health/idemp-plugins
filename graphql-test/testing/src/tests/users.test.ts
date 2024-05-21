import { v4 } from 'uuid';
import { initialLoginData, mutate, query } from '../api';
import { createBusinessPartner } from '../utils';
import {
	Ad_ClientGetDocument,
	Ad_RoleGetDocument,
	Ad_RoleWithIncludedSaveDocument,
	Ad_UserGetDocument,
	Ad_UserWithRoleSaveDocument,
	Ad_User_RolesDeleteDocument,
	Ad_User_RolesSaveAndDeleteManyDocument,
	Ad_User_RolesSaveManyDocument,
	ChangePasswordDocument,
	SignInDocument,
} from '../__generated__/graphql';
import { roleUuid } from './roles.test';

test('save user', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	const createdUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];
	expect(createdUser).toBeTruthy();

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.Results;
	const role = availableRoles.filter(
		(availableRole) => !createdUser.AD_User_Roles?.map((userRole) => userRole.AD_Role.UU).includes(availableRole.UU),
	)[0];
	expect(role).toBeTruthy();

	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: {
				UU: createdUser.UU,
				IsActive: false,
			},
			AD_User_Roles: [{ AD_Role: { UU: role.UU }, AD_User: { UU: createdUser.UU } }],
		},
	});

	const savedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: createdUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	expect(savedUser.Name).toBe(createdUser.Name);
	expect(savedUser.IsActive).not.toBe(createdUser.IsActive);
	expect(savedUser.AD_User_Roles?.length).toBe(1);
});

test('new user can be created directly without business partner', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user directly';

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.Results;
	const cashierRole = availableRoles.filter((role) => role.Name.toLowerCase().includes('cashier'))[0];

	const userUuid = v4();
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { UU: userUuid, Name: valueObject.getDynamicStepMessage(), IsActive: true },
			AD_User_Roles: [{ AD_User: { UU: userUuid }, AD_Role: { UU: cashierRole.UU } }],
		},
	});
	const createdUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: userUuid }) },
		})
	).data.AD_UserGet.Results[0];
	expect(createdUser).toBeTruthy();

	expect(createdUser.Name).toBe(valueObject.getDynamicStepMessage());
	expect(createdUser.UU).toBeTruthy();
	expect(createdUser.IsActive).toBe(true);
	expect(createdUser.AD_User_Roles?.length).toBe(1);
});

test('getting non-admin users sorting and filtering works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.Results;
	const cashierRole = availableRoles.filter((role) => role.Name.toLowerCase().includes('cashier'))[0];
	expect(cashierRole).toBeTruthy();

	valueObject.stepName = 'Create first user indirectly';
	await createBusinessPartner(valueObject);
	let firstUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];
	expect(firstUser).toBeTruthy();

	valueObject.stepName = 'Assign role to first user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UU: firstUser.UU }, AD_Role: { UU: cashierRole.UU } }],
		},
	});
	firstUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: firstUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	valueObject.stepName = 'Create second user indirectly';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);
	let secondUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];
	expect(secondUser).toBeTruthy();

	valueObject.stepName = 'Assign role to second user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UU: secondUser.UU }, AD_Role: { UU: cashierRole.UU } }],
		},
	});
	secondUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: secondUser.UU }) },
		})
	).data.AD_UserGet.Results[0];

	const filterString = JSON.stringify({
		ad_user_uu: { $in: [firstUser.UU, secondUser.UU] },
		ad_org: { ad_org_uu: { $neq: '3ef41ffc-8ea9-454a-afa2-22949f402ff5' } },
	});
	expect(
		(await query(valueObject)({ query: Ad_UserGetDocument, variables: { Filter: filterString } })).data.AD_UserGet
			.Results,
	).toHaveLength(2);
	const ascendingNameUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Sort: JSON.stringify([['name', 'ASC']]), Filter: filterString },
		})
	).data.AD_UserGet.Results[0];
	const sortedResults = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Sort: JSON.stringify([['name', 'DESC']]), Filter: filterString },
		})
	).data.AD_UserGet.Results;
	expect(sortedResults[0].UU).not.toBe(ascendingNameUser.UU);
	expect(sortedResults[1].UU).toBe(ascendingNameUser.UU);
});

test('user can be assigned and removed from roles', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	let user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();

	valueObject.stepName = 'Create role 1';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.Results;
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
					Included_Role: { UU: masterRoles[0].UU },
					SeqNo: 10,
				},
			],
		},
	});
	const role1 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.Results[0];
	expect(role1.UU).toBeTruthy();

	valueObject.stepName = 'Create role 2';
	roleUuidToUse = v4();
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
					Included_Role: { UU: masterRoles[1].UU },
					SeqNo: 10,
				},
			],
		},
	});
	const role2 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.Results[0];
	expect(role2.UU).toBeTruthy();

	valueObject.stepName = 'Assign role 1 to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: { AD_User_Roles: [{ AD_User: { UU: user.UU }, AD_Role: { UU: role1.UU } }] },
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: user.UU }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(1);
	expect(user.AD_User_Roles?.[0].AD_Role.UU).toBe(role1.UU);
	expect(user.AD_User_Roles?.[0].AD_Role.AD_Role_IncludedList?.[0].Included_Role.UU).toBe(masterRoles[0].UU);

	valueObject.stepName = 'Assign role 2 to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveAndDeleteManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UU: user.UU }, AD_Role: { UU: role2.UU } }],
			AD_User_Role_UUs_To_Delete: user.AD_User_Roles!.map((userRole) => userRole.UU),
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: user.UU }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(1);
	expect(user.AD_User_Roles?.[0].AD_Role.UU).toBe(role2.UU);
	expect(user.AD_User_Roles?.[0].AD_Role.AD_Role_IncludedList?.[0].Included_Role.UU).toBe(masterRoles[1].UU);

	valueObject.stepName = 'Assign both roles to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UU: user.UU }, AD_Role: { UU: role1.UU } }],
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: user.UU }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(2);
	expect(user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UU === role1.UU)).toBeTruthy();
	expect(
		user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UU === role1.UU)?.AD_Role.AD_Role_IncludedList?.[0]
			.Included_Role.UU,
	).toBe(masterRoles[0].UU);
	expect(user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UU === role2.UU)).toBeTruthy();
	expect(
		user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UU === role2.UU)?.AD_Role.AD_Role_IncludedList?.[0]
			.Included_Role.UU,
	).toBe(masterRoles[1].UU);

	valueObject.stepName = 'Remove all roles from user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesDeleteDocument,
		variables: {
			UUs: user.AD_User_Roles!.map((userRole) => userRole.UU),
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: user.UU }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toBeFalsy();
});

test('user can login with created role', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	let user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UU } }) },
		})
	).data.AD_UserGet.Results[0];
	expect(user).toBeTruthy();

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
				{
					AD_Role: { UU: roleUuidToUse },
					Included_Role: { UU: availableRoles[1].UU },
					SeqNo: 30,
				},
			],
		},
	});
	const role1 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { Filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.Results[0];
	expect(role1.UU).toBeTruthy();

	valueObject.stepName = 'Assign role to user';
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { UU: user.UU, Password: '123', IsExpired: true },
			AD_User_Roles: { AD_User: { UU: user.UU }, AD_Role: { UU: role1.UU } },
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: user.UU }) },
		})
	).data.AD_UserGet.Results[0];

	valueObject.stepName = 'Log out';
	await valueObject.logout();

	valueObject.stepName = 'Log in as user';
	const loginData = (
		await query(valueObject)({
			query: SignInDocument,
			variables: { Credentials: { ...initialLoginData, Username: user.Name, Password: '123' } },
		})
	).data.SignIn;
	expect(valueObject.sessionToken).toBeFalsy();
	expect(loginData.AD_User?.IsExpired).toBeTruthy();

	await mutate(valueObject)({
		mutation: ChangePasswordDocument,
		variables: { PasswordInfo: { Username: user.Name, Password: '123', NewPassword: '1234' } },
	});
	const clients = (await query(valueObject)({ query: Ad_ClientGetDocument })).data.AD_ClientGet.Results;
	expect(valueObject.sessionToken).toBeTruthy();
	expect(clients.length).toBeTruthy();
	expect(clients[0].AD_Orgs.length).toBeTruthy();
	expect(clients[0].AD_Orgs[0].AD_Roles?.length).toBeTruthy();
	expect(clients[0].AD_Orgs[0].M_Warehouses?.length).toBeTruthy();
});
