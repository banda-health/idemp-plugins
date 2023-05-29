import { userApi } from '../api';
import { Role, User } from '../types/org.bandahealth.idempiere.rest';


test('save user', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	// test fetch
	const user = (await userApi.get(valueObject, 0, 1, undefined, undefined)).results[0];
	expect(user).toBeTruthy();
	
	const role = {
	    clientId: 1000000,
	    orgId: 0,
	    uuid: '13974ee7-cd56-4083-a58b-987e06f80847',
	    created: '',
	    isActive: true,
	    name: 'Banda Health Clinician/Nurse',
	};

	const userToSave: Partial<User> = {
		...user,
		isActive: false,
		roles: [],	
	};
	
	userToSave.roles?.push(role as Role);

	const savedUser = await userApi.save(valueObject, userToSave as User);

	expect(savedUser.name).toBe(userToSave.name);
	expect(savedUser.isActive).toBe(userToSave.isActive);
	expect(savedUser.roles.length).toBe(userToSave.roles?.length);
});
