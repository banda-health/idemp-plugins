import { mkdir, writeFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { Authentication } from '../types/org.bandahealth.idempiere.rest';
import { initialLoginData, login } from '../utils';

const workingDirectory = join(tmpdir(), 'idemp-rest-global-setup');

export default async function () {
	const loginInfo = await login();
	// Find the client & org we'll use
	let client = loginInfo.clients.find(
		(client) => client.name === 'Rest Test Client'
	);
	let org = client?.orgs[0];
	let roles = org?.roles;
	if (!client || !org || !roles?.length) {
		throw new Error('could not find client "Rest Test Client"');
	}

	// Re-login with the right data as the admin by default so we can get the right session token
	const adminRole = roles.find((role) => role.name.endsWith('Admin'));
	if (adminRole) {
		const baseLoginData: Partial<Authentication> = {
			...initialLoginData,
			clientUuid: client.uuid,
			organizationId: org.id,
			roleUuid: adminRole.uuid,
			warehouseUuid: org.warehouses[0].uuid,
		};
		const newLoginInfo = await login(baseLoginData);
		// Update the session token appropriately
		loginInfo.token = newLoginInfo.token;
	}

	// use the file system to expose the wsEndpoint for TestEnvironments
	await mkdir(workingDirectory, { recursive: true });
	await writeFile(
		join(workingDirectory, 'loginInfo'),
		JSON.stringify({ ...loginInfo, client })
	);
}
