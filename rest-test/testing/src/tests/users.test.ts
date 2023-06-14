import { roleApi, userApi } from '../api';
import { User } from '../types/org.bandahealth.idempiere.rest';
import { createBusinessPartner } from '../utils';

test('save user', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

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
