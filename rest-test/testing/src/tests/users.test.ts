import { roleApi, userApi } from '../api';
import { User } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner } from '../utils';

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
