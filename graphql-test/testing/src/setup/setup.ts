import { mkdir, writeFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { graphqlClient, initialLoginData } from '../api';
import { SignInDocument, SignInQuery, SignInQueryVariables } from '../__generated__/graphql';

const workingDirectory = join(tmpdir(), 'rest-global-setup');
const clientName = process.env.IDEMPIERE_GRAPHQL_TEST_CLIENT || 'GraphQL Test Client';

export default async function () {
	let loginInfo: SignInQuery['SignIn'] & {
		AD_Client?: SignInQuery['SignIn']['AD_Clients'][0];
		AD_Client_UU?: string;
		AD_Org_UU?: string;
		AD_Role_UU?: string;
		M_Warehouse_UU?: string;
	};
	const {
		data: { SignIn: initialLoginInfo },
	} = await graphqlClient.query({
		query: SignInDocument,
		variables: { Credentials: initialLoginData },
	});
	loginInfo = { ...initialLoginInfo };
	// Find the client & org we'll use
	let client = initialLoginInfo.AD_Clients.find((client) => client.Name === clientName);
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
		const baseLoginData: SignInQueryVariables['Credentials'] = {
			...initialLoginData,
			AD_Client_UU: client.UU,
			AD_Org_UU: organization.UU,
			AD_Role_UU: adminRole.UU,
			M_Warehouse_UU: organization.M_Warehouses?.[0].UU,
		};
		const {
			data: { SignIn: newLoginInfo },
		} = await graphqlClient.query({
			query: SignInDocument,
			variables: { Credentials: baseLoginData },
		});
		// Update the session token appropriately
		loginInfo.Token = newLoginInfo.Token;
		loginInfo.AD_Clients = newLoginInfo.AD_Clients; // Ensure all data is loaded now that a client is selected
		client = newLoginInfo.AD_Clients.find((client) => client.Name === clientName)!;
		loginInfo.AD_Client_UU = client.UU;
		loginInfo.AD_Org_UU = organization.UU;
		loginInfo.AD_Role_UU = organization.UU;
		loginInfo.M_Warehouse_UU = organization.M_Warehouses![0].UU;
	}

	// use the file system to expose the admin login information
	await mkdir(workingDirectory, { recursive: true });
	await writeFile(join(workingDirectory, 'loginInfo'), JSON.stringify({ ...loginInfo, AD_Client: client }));
}
