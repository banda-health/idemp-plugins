import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { createBusinessPartner } from '../utils';
import {
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
			variables: { filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UUID } }) },
		})
	).data.AD_UserGet.results[0];
	expect(createdUser).toBeTruthy();

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.results;
	const role = availableRoles.filter(
		(availableRole) =>
			!createdUser.AD_User_Roles?.map((userRole) => userRole.AD_Role.UUID).includes(availableRole.UUID),
	)[0];
	expect(role).toBeTruthy();

	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: {
				UUID: createdUser.UUID,
				IsActive: false,
			},
			AD_User_Roles: [{ AD_Role: { UUID: role.UUID }, AD_User: { UUID: createdUser.UUID } }],
		},
	});

	const savedUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: createdUser.UUID }) },
		})
	).data.AD_UserGet.results[0];

	expect(savedUser.Name).toBe(createdUser.Name);
	expect(savedUser.IsActive).not.toBe(createdUser.IsActive);
	expect(savedUser.AD_User_Roles?.length).toBe(1);
});

test('new user can be created directly without business partner', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user directly';

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.results;
	const cashierRole = availableRoles.filter((role) => role.Name.toLowerCase().includes('cashier'))[0];

	const userUuid = v4();
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { UUID: userUuid, Name: valueObject.getDynamicStepMessage(), IsActive: true },
			AD_User_Roles: [{ AD_User: { UUID: userUuid }, AD_Role: { UUID: cashierRole.UUID } }],
		},
	});
	const createdUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: userUuid }) },
		})
	).data.AD_UserGet.results[0];
	expect(createdUser).toBeTruthy();

	expect(createdUser.Name).toBe(valueObject.getDynamicStepMessage());
	expect(createdUser.UUID).toBeTruthy();
	expect(createdUser.IsActive).toBe(true);
	expect(createdUser.AD_User_Roles?.length).toBe(1);
});

test('getting non-admin users sorting and filtering works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const availableRoles = (await query(valueObject)({ query: Ad_RoleGetDocument })).data.AD_RoleGet.results;
	const cashierRole = availableRoles.filter((role) => role.Name.toLowerCase().includes('cashier'))[0];
	expect(cashierRole).toBeTruthy();

	valueObject.stepName = 'Create first user indirectly';
	await createBusinessPartner(valueObject);
	let firstUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UUID } }) },
		})
	).data.AD_UserGet.results[0];
	expect(firstUser).toBeTruthy();

	valueObject.stepName = 'Assign role to first user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UUID: firstUser.UUID }, AD_Role: { UUID: cashierRole.UUID } }],
		},
	});
	firstUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: firstUser.UUID }) },
		})
	).data.AD_UserGet.results[0];

	valueObject.stepName = 'Create second user indirectly';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);
	let secondUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UUID } }) },
		})
	).data.AD_UserGet.results[0];
	expect(secondUser).toBeTruthy();

	valueObject.stepName = 'Assign role to second user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UUID: secondUser.UUID }, AD_Role: { UUID: cashierRole.UUID } }],
		},
	});
	secondUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: secondUser.UUID }) },
		})
	).data.AD_UserGet.results[0];

	const filterString = JSON.stringify({
		ad_user_uu: { $in: [firstUser.UUID, secondUser.UUID] },
		ad_org: { ad_org_uu: { $neq: '3ef41ffc-8ea9-454a-afa2-22949f402ff5' } },
	});
	expect(
		(await query(valueObject)({ query: Ad_UserGetDocument, variables: { filter: filterString } })).data.AD_UserGet
			.results,
	).toHaveLength(2);
	const ascendingNameUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { sort: JSON.stringify([['name', 'ASC']]), filter: filterString },
		})
	).data.AD_UserGet.results[0];
	const sortedResults = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { sort: JSON.stringify([['name', 'DESC']]), filter: filterString },
		})
	).data.AD_UserGet.results;
	expect(sortedResults[0].UUID).not.toBe(ascendingNameUser.UUID);
	expect(sortedResults[1].UUID).toBe(ascendingNameUser.UUID);
});

test('user can be assigned and removed from roles', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	let user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UUID } }) },
		})
	).data.AD_UserGet.results[0];
	expect(user).toBeTruthy();

	valueObject.stepName = 'Create role 1';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.results;
	let roleUuidToUse = v4();
	await mutate(valueObject)({
		mutation: Ad_RoleWithIncludedSaveDocument,
		variables: {
			AD_Role: {
				UUID: roleUuidToUse,
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
			AD_Role_IncludedList: [
				{
					AD_Role: { UUID: roleUuidToUse },
					Included_Role: { UUID: masterRoles[0].UUID },
					SeqNo: 10,
				},
			],
		},
	});
	const role1 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.results[0];
	expect(role1.UUID).toBeTruthy();

	valueObject.stepName = 'Create role 2';
	roleUuidToUse = v4();
	await mutate(valueObject)({
		mutation: Ad_RoleWithIncludedSaveDocument,
		variables: {
			AD_Role: {
				UUID: roleUuidToUse,
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
			AD_Role_IncludedList: [
				{
					AD_Role: { UUID: roleUuidToUse },
					Included_Role: { UUID: masterRoles[1].UUID },
					SeqNo: 10,
				},
			],
		},
	});
	const role2 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.results[0];
	expect(role2.UUID).toBeTruthy();

	valueObject.stepName = 'Assign role 1 to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: { AD_User_Roles: [{ AD_User: { UUID: user.UUID }, AD_Role: { UUID: role1.UUID } }] },
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: user.UUID }) },
		})
	).data.AD_UserGet.results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(1);
	expect(user.AD_User_Roles?.[0].AD_Role.UUID).toBe(role1.UUID);
	expect(user.AD_User_Roles?.[0].AD_Role.AD_Role_IncludedList?.[0].Included_Role.UUID).toBe(masterRoles[0].UUID);

	valueObject.stepName = 'Assign role 2 to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveAndDeleteManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UUID: user.UUID }, AD_Role: { UUID: role2.UUID } }],
			AD_User_Role_UUIDs_To_Delete: user.AD_User_Roles!.map((userRole) => userRole.UUID),
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: user.UUID }) },
		})
	).data.AD_UserGet.results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(1);
	expect(user.AD_User_Roles?.[0].AD_Role.UUID).toBe(role2.UUID);
	expect(user.AD_User_Roles?.[0].AD_Role.AD_Role_IncludedList?.[0].Included_Role.UUID).toBe(masterRoles[1].UUID);

	valueObject.stepName = 'Assign both roles to user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesSaveManyDocument,
		variables: {
			AD_User_Roles: [{ AD_User: { UUID: user.UUID }, AD_Role: { UUID: role1.UUID } }],
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: user.UUID }) },
		})
	).data.AD_UserGet.results[0];
	expect(user).toBeTruthy();
	expect(user.AD_User_Roles).toHaveLength(2);
	expect(user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UUID === role1.UUID)).toBeTruthy();
	expect(
		user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UUID === role1.UUID)?.AD_Role.AD_Role_IncludedList?.[0]
			.Included_Role.UUID,
	).toBe(masterRoles[0].UUID);
	expect(user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UUID === role2.UUID)).toBeTruthy();
	expect(
		user.AD_User_Roles?.find((userRole) => userRole.AD_Role.UUID === role2.UUID)?.AD_Role.AD_Role_IncludedList?.[0]
			.Included_Role.UUID,
	).toBe(masterRoles[1].UUID);

	valueObject.stepName = 'Remove all roles from user';
	await mutate(valueObject)({
		mutation: Ad_User_RolesDeleteDocument,
		variables: {
			uuids: user.AD_User_Roles!.map((userRole) => userRole.UUID),
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: user.UUID }) },
		})
	).data.AD_UserGet.results[0];
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
			variables: { filter: JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.UUID } }) },
		})
	).data.AD_UserGet.results[0];
	expect(user).toBeTruthy();

	valueObject.stepName = 'Create role';
	const masterRoles = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ismasterrole: true }) },
		})
	).data.AD_RoleGet.results;
	const mustHavesRole = masterRoles.filter((role) => role.UUID === roleUuid.MUST_HAVES)[0];
	const availableRoles = masterRoles.filter((role) => role.UUID !== roleUuid.MUST_HAVES);
	let roleUuidToUse = v4();
	await mutate(valueObject)({
		mutation: Ad_RoleWithIncludedSaveDocument,
		variables: {
			AD_Role: {
				UUID: roleUuidToUse,
				IsMasterRole: false,
				Name: valueObject.getDynamicStepMessage(),
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
			},
			AD_Role_IncludedList: [
				{
					AD_Role: { UUID: roleUuidToUse },
					Included_Role: { UUID: mustHavesRole.UUID },
					SeqNo: 10,
				},
				{
					AD_Role: { UUID: roleUuidToUse },
					Included_Role: { UUID: availableRoles[0].UUID },
					SeqNo: 20,
				},
				{
					AD_Role: { UUID: roleUuidToUse },
					Included_Role: { UUID: availableRoles[1].UUID },
					SeqNo: 30,
				},
			],
		},
	});
	const role1 = (
		await query(valueObject)({
			query: Ad_RoleGetDocument,
			variables: { filter: JSON.stringify({ ad_role_uu: roleUuidToUse }) },
		})
	).data.AD_RoleGet.results[0];
	expect(role1.UUID).toBeTruthy();

	valueObject.stepName = 'Assign role to user';
	await mutate(valueObject)({
		mutation: Ad_UserWithRoleSaveDocument,
		variables: {
			AD_User: { UUID: user.UUID, Password: '123', IsExpired: true },
			AD_User_Roles: { AD_User: { UUID: user.UUID }, AD_Role: { UUID: role1.UUID } },
		},
	});
	user = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { filter: JSON.stringify({ ad_user_uu: user.UUID }) },
		})
	).data.AD_UserGet.results[0];

	valueObject.stepName = 'Log in as user';
	const loginData = (
		await query(valueObject)({
			query: SignInDocument,
			variables: { credentials: { username: user.Name, password: '123' } },
		})
	).data.signIn;
	expect(loginData.token).toBeFalsy();
	expect(loginData.user?.IsExpired).toBeTruthy();
	expect(loginData.AD_Clients).toHaveLength(0);

	const newLoginData = (
		await query(valueObject)({
			query: ChangePasswordDocument,
			variables: { credentials: { username: user.Name, password: '123', newPassword: '1234' } },
		})
	).data.changePassword;
	expect(newLoginData.AD_Clients.length).toBeTruthy();
	expect(newLoginData.AD_Clients[0].AD_Orgs.length).toBeTruthy();
	expect(newLoginData.AD_Clients[0].AD_Orgs[0].AD_Roles?.length).toBeTruthy();
	expect(newLoginData.AD_Clients[0].AD_Orgs[0].M_Warehouses?.length).toBeTruthy();
});
