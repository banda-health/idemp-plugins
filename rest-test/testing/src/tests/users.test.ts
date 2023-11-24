import { authenticationApi, roleApi, userApi } from '../api';
import { Role, User } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner } from '../utils';
import { roleUuid } from './roles.test';

test('save user', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	const createdUser = (
		await userApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.uuid } }),
		)
	).results[0];
	expect(createdUser).toBeTruthy();

	const availableRoles = (await roleApi.get(valueObject)).results;
	const role = availableRoles.filter(
		(availableRole) => !createdUser.roles.map((role) => role.uuid).includes(availableRole.uuid),
	)[0];
	expect(role).toBeTruthy();

	const userToSave: User = {
		...createdUser,
		isActive: false,
		roles: [role],
	};

	const savedUser = await userApi.save(valueObject, userToSave);

	expect(savedUser.name).toBe(userToSave.name);
	expect(savedUser.isActive).toBe(userToSave.isActive);
	expect(savedUser.roles.length).toBe(userToSave.roles?.length);
});

test('new user can be created directly without business partner', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user directly';

	const availableRoles = (await roleApi.get(valueObject)).results;
	const cashierRole = availableRoles.filter((role) => role.name.toLowerCase().includes('cashier'))[0];

	const userToCreate: Partial<User> = {
		name: valueObject.getDynamicStepMessage(),
		isActive: true,
		roles: [cashierRole]
	};
	const createdUser = await userApi.save(valueObject, userToCreate as User);

	expect(createdUser.name).toBe(userToCreate.name);
	expect(createdUser.uuid).toBeTruthy();
	expect(createdUser.isActive).toBe(userToCreate.isActive);
	expect(createdUser.roles.length).toBe(userToCreate.roles?.length);
});

test('getting non-admin users sorting and filtering works', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const availableRoles = (await roleApi.get(valueObject)).results;
	const cashierRole = availableRoles.filter((role) => role.name.toLowerCase().includes('cashier'))[0];
	expect(cashierRole).toBeTruthy();

	valueObject.stepName = 'Create first user indirectly';
	await createBusinessPartner(valueObject);
	let firstUser = (
		await userApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.uuid } }),
		)
	).results[0];
	expect(firstUser).toBeTruthy();

	valueObject.stepName = 'Assign role to first user';
	firstUser = await userApi.save(valueObject, {
		...firstUser,
		roles: [cashierRole],
	});

	valueObject.stepName = 'Create second user indirectly';
	valueObject.businessPartner = undefined;
	await createBusinessPartner(valueObject);
	let secondUser = (
		await userApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.uuid } }),
		)
	).results[0];
	expect(secondUser).toBeTruthy();

	valueObject.stepName = 'Assign role to second user';
	secondUser = await userApi.save(valueObject, {
		...secondUser,
		roles: [cashierRole],
	});

	const filterString = JSON.stringify({ ad_user_uu: { $in: [firstUser.uuid, secondUser.uuid] } });
	expect((await userApi.getNonAdmins(valueObject, undefined, undefined, undefined, filterString)).results).toHaveLength(
		2,
	);
	const ascendingNameUser = (
		await userApi.getNonAdmins(valueObject, undefined, undefined, JSON.stringify([['name', 'ASC']]), filterString)
	).results[0];
	const sortedResults = (
		await userApi.getNonAdmins(valueObject, undefined, undefined, JSON.stringify([['name', 'DESC']]), filterString)
	).results;
	expect(sortedResults[0].uuid).not.toBe(ascendingNameUser.uuid);
	expect(sortedResults[1].uuid).toBe(ascendingNameUser.uuid);
});

test('user can be assigned and removed from roles', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	let user = (
		await userApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.uuid } }),
		)
	).results[0];
	expect(user).toBeTruthy();

	valueObject.stepName = 'Create role 1';
	const masterRoles = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ismasterrole: true }))
	).results;
	const role1 = await roleApi.save(valueObject, {
		includedRoles: [masterRoles[0]],
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);
	expect(role1.uuid).toBeTruthy();

	valueObject.stepName = 'Create role 2';
	const role2 = await roleApi.save(valueObject, {
		includedRoles: [masterRoles[1]],
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);

	valueObject.stepName = 'Assign role 1 to user';
	user = await userApi.save(valueObject, { ...user, roles: [role1] });
	expect(user).toBeTruthy();
	expect(user.roles).toHaveLength(1);
	expect(user.roles[0].uuid).toBe(role1.uuid);
	expect(user.roles[0].includedRoles[0].uuid).toBe(masterRoles[0].uuid);

	valueObject.stepName = 'Assign role 2 to user';
	user = await userApi.save(valueObject, { ...user, roles: [role2] });
	expect(user).toBeTruthy();
	expect(user.roles).toHaveLength(1);
	expect(user.roles[0].uuid).toBe(role2.uuid);
	expect(user.roles[0].includedRoles[0].uuid).toBe(masterRoles[1].uuid);

	valueObject.stepName = 'Assign both roles to user';
	user = await userApi.save(valueObject, { ...user, roles: [role1, role2] });
	expect(user).toBeTruthy();
	expect(user.roles).toHaveLength(2);
	expect(user.roles.find((role) => role.uuid === role1.uuid)).toBeTruthy();
	expect(user.roles.find((role) => role.uuid === role1.uuid)!.includedRoles[0].uuid).toBe(masterRoles[0].uuid);
	expect(user.roles.find((role) => role.uuid === role2.uuid)).toBeTruthy();
	expect(user.roles.find((role) => role.uuid === role2.uuid)!.includedRoles[0].uuid).toBe(masterRoles[1].uuid);

	valueObject.stepName = 'Remove all roles from user';
	user = await userApi.save(valueObject, { ...user, roles: [] });
	expect(user).toBeTruthy();
	expect(user.roles).toHaveLength(0);
});

test('user can login with created role', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create user indirectly';
	await createBusinessPartner(valueObject);
	let user = (
		await userApi.get(
			valueObject,
			undefined,
			undefined,
			undefined,
			JSON.stringify({ c_bpartner: { c_bpartner_uu: valueObject.businessPartner!.uuid } }),
		)
	).results[0];
	expect(user).toBeTruthy();

	valueObject.stepName = 'Create role';
	const masterRoles = (
		await roleApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ismasterrole: true }))
	).results;
	const mustHavesRole = masterRoles.filter((role) => role.uuid === roleUuid.MUST_HAVES)[0];
	const availableRoles = masterRoles.filter((role) => role.uuid !== roleUuid.MUST_HAVES);
	const role1 = await roleApi.save(valueObject, {
		includedRoles: [mustHavesRole, availableRoles[0], availableRoles[1]],
		isMasterRole: false,
		name: valueObject.getDynamicStepMessage(),
		description: valueObject.getStepMessageLong(),
		isActive: true,
	} as Partial<Role> as Role);
	expect(role1.uuid).toBeTruthy();

	valueObject.stepName = 'Assign role to user';
	user = await userApi.save(valueObject, { ...user, resetPassword: '123', roles: [role1] });

	valueObject.stepName = 'Log in as user';
	const loginData = await authenticationApi.login({
		username: user.name,
		password: '123',
	});
	expect(loginData.needsToResetPassword).toBeTruthy();
	expect(loginData.clients).toHaveLength(0);

	const newLoginData = await authenticationApi.changePassword({
		username: user.name,
		password: '123',
		newPassword: '1234',
	});
	expect(newLoginData.clients.length).toBeTruthy();
	expect(newLoginData.clients[0].organizations.length).toBeTruthy();
	expect(newLoginData.clients[0].organizations[0].roles.length).toBeTruthy();
	expect(newLoginData.clients[0].organizations[0].warehouses.length).toBeTruthy();
});
