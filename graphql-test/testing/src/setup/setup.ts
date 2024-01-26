import { mkdir, writeFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { graphqlClient, initialLoginData } from '../api';
import { SignInDocument, SignInQuery, SignInQueryVariables } from '../__generated__/graphql';

const workingDirectory = join(tmpdir(), 'rest-global-setup');
const clientName = process.env.IDEMPIERE_GRAPHQL_TEST_CLIENT || 'GraphQL Test Client';

export default async function () {
	let loginInfo: SignInQuery['signIn'] & {
		AD_Client?: SignInQuery['signIn']['AD_Clients'][0];
		clientUuid?: string;
		organizationUuid?: string;
		roleUuid?: string;
		warehouseUuid?: string;
	};
	const {
		data: { signIn: initialLoginInfo },
	} = await graphqlClient.query({
		query: SignInDocument,
		variables: { credentials: initialLoginData },
	});
	loginInfo = { ...initialLoginInfo };
	// Find the client & org we'll use
	const client = initialLoginInfo.AD_Clients.find((client) => client.Name === clientName);
	const organization = client?.AD_Orgs[0];
	const roles = organization?.AD_Roles;
	if (!client) {
		throw new Error(`could not find client "${clientName}"`);
	}
	if (!organization) {
		throw new Error(`client "${client.Name}" didn't have any organizations`);
	}
	if (!roles?.length) {
		throw new Error(`organization "${organization.Name}" didn't come with any roles`);
	}

	// Re-login with the right data as the admin by default so we can get the right session token
	const adminRole = roles.find((role) => role.Name.endsWith('Admin'));
	if (adminRole) {
		const baseLoginData: SignInQueryVariables['credentials'] = {
			...initialLoginData,
			clientUuid: client.UUID,
			organizationUuid: organization.UUID,
			roleUuid: adminRole.UUID,
			warehouseUuid: organization.M_Warehouses?.[0].UUID,
		};
		const {
			data: { signIn: newLoginInfo },
		} = await graphqlClient.query({
			query: SignInDocument,
			variables: { credentials: baseLoginData },
		});
		// Update the session token appropriately
		loginInfo.token = newLoginInfo.token;
		loginInfo.clientUuid = client.UUID;
		loginInfo.organizationUuid = organization.UUID;
		loginInfo.roleUuid = organization.UUID;
		loginInfo.warehouseUuid = organization.M_Warehouses![0].UUID;
	}

	// use the file system to expose the admin login information
	await mkdir(workingDirectory, { recursive: true });
	await writeFile(join(workingDirectory, 'loginInfo'), JSON.stringify({ ...loginInfo, AD_Client: client }));
}
