import { mkdir, writeFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { authenticationApi, initialLoginData } from '../api';
import { Authentication } from '../types/org.bandahealth.idempiere.rest';

const workingDirectory = join(tmpdir(), 'rest-global-setup');
const clientName = process.env.IDEMPIERE_REST_TEST_CLIENT || 'Rest Test Client';

export default async function () {
	const loginInfo = await authenticationApi.login();
	// Find the client & org we'll use
	let client = loginInfo.clients.find((client) => client.name === clientName);
	let organization = client?.organizations[0];
	let roles = organization?.roles;
	if (!client || !organization || !roles?.length) {
		throw new Error(`could not find client "${clientName}"`);
	}

	// Re-login with the right data as the admin by default so we can get the right session token
	const adminRole = roles.find((role) => role.name.endsWith('Admin'));
	if (adminRole) {
		const baseLoginData: Partial<Authentication> = {
			...initialLoginData,
			clientUuid: client.uuid,
			organizationUuid: organization.uuid,
			roleUuid: adminRole.uuid,
			warehouseUuid: organization.warehouses[0].uuid,
		};
		const newLoginInfo = await authenticationApi.login(baseLoginData);
		// Update the session token appropriately
		loginInfo.token = newLoginInfo.token;
		loginInfo.clientUuid = newLoginInfo.clientUuid;
		loginInfo.organizationUuid = newLoginInfo.organizationUuid;
		loginInfo.roleUuid = newLoginInfo.roleUuid;
		loginInfo.warehouseUuid = newLoginInfo.warehouseUuid;
	}

	// use the file system to expose the admin login information
	await mkdir(workingDirectory, { recursive: true });
	await writeFile(join(workingDirectory, 'loginInfo'), JSON.stringify({ ...loginInfo, client }));
}
