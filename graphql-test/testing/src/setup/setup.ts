import { mkdir, writeFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { graphqlClient, initialLoginData, withRequiredData } from '../api';
import { LoginInfo } from '../types/global';
import {
	Ad_ClientGetDocument,
	Ad_RoleLocationPriceListsCurrencyGetDocument,
	Ad_RoleLocationPriceListsCurrencyGetQuery,
	ChangeAccessDocument,
	ChangeAccessMutationVariables,
	M_DiscountSchemaGetDocument,
	M_DiscountSchemaGetQuery,
	M_PriceListSaveDocument,
	M_PriceListSaveMutation,
	M_PriceList_VersionGetDocument,
	M_PriceList_VersionSaveDocument,
	SignInDocument,
} from '../__generated__/graphql';

const workingDirectory = join(tmpdir(), 'rest-global-setup');
const clientName = process.env.IDEMPIERE_GRAPHQL_TEST_CLIENT || 'GraphQL Test Client';

function formatApiDate(date?: Date): string {
	const [{ value: month }, , { value: day }, , { value: year }] = new Intl.DateTimeFormat('en', {
		year: 'numeric',
		month: '2-digit',
		day: '2-digit',
		hour: 'numeric',
		minute: 'numeric',
		hour12: true,
	}).formatToParts(date || new Date());
	return `${year}/${month}/${day}`;
}

async function createDefaultPriceLists(
	priceLists: Ad_RoleLocationPriceListsCurrencyGetQuery['M_PriceListGet']['Results'],
	loginInfo: LoginInfo,
) {
	const context = { valueObject: { sessionToken: loginInfo.token } };
	priceLists.sort((priceListA, priceListB) =>
		priceListA.Created < priceListB.Created ? -1 : priceListA.Created > priceListB.Created ? 1 : 0,
	);
	let defaultSalesPriceList = priceLists.filter(
		(priceList) => priceList.IsSOPriceList,
	)[0] as M_PriceListSaveMutation['M_PriceListSave'];
	if (!defaultSalesPriceList) {
		defaultSalesPriceList = (
			await graphqlClient.mutate({
				mutation: M_PriceListSaveDocument,
				variables: {
					Entity: {
						Name: 'SO_During: Create Default Prices Lists',
						Description: 'SO_During: Create Default Prices Lists',
						IsSOPriceList: true,
						C_Currency: { UU: loginInfo.C_Currency?.UU! },
						IsDefault: true,
					},
				},
				context,
			})
		).data?.M_PriceListSave!;
	}
	if (!defaultSalesPriceList) {
		throw Error('problem creating default sales price list');
	}
	loginInfo.SalesPriceList = defaultSalesPriceList;

	let defaultPurchasePriceList = priceLists.filter(
		(priceList) => !priceList.IsSOPriceList,
	)[0] as M_PriceListSaveMutation['M_PriceListSave'];
	if (!defaultPurchasePriceList) {
		defaultPurchasePriceList = (
			await graphqlClient.mutate({
				mutation: M_PriceListSaveDocument,
				variables: {
					Entity: {
						Name: 'PO_During: Create Default Prices Lists',
						Description: 'PO_During: Create Default Prices Lists',
						IsSOPriceList: true,
						C_Currency: { UU: loginInfo.C_Currency?.UU! },
						IsDefault: true,
					},
				},
				context,
			})
		).data?.M_PriceListSave!;
	}
	if (!defaultSalesPriceList) {
		throw Error('problem creating default purchase price list');
	}
	loginInfo.PurchasePriceList = defaultPurchasePriceList;

	const priceListDate = new Date();
	priceListDate.setFullYear(priceListDate.getFullYear() - 1);
	const priceListApiDate = formatApiDate(priceListDate);

	let schema: M_DiscountSchemaGetQuery['M_DiscountSchemaGet']['Results'][0] | undefined;
	let priceListVersionCount = withRequiredData(
		await graphqlClient.query({
			query: M_PriceList_VersionGetDocument,
			variables: {
				Filter: JSON.stringify({
					m_pricelist: { m_pricelist_uu: defaultSalesPriceList.UU },
					validfrom: { $lte: priceListApiDate },
				}),
			},
			context,
		}),
	).data.M_PriceList_VersionGet.PagingInfo.TotalCount;
	if (!priceListVersionCount) {
		// get bogus price list schema - required field
		schema = withRequiredData(
			await graphqlClient.query({
				query: M_DiscountSchemaGetDocument,
				variables: { Filter: JSON.stringify({ discounttype: 'P' }) },
				context,
			}),
		).data.M_DiscountSchemaGet.Results[0];
		//
		await graphqlClient.mutate({
			mutation: M_PriceList_VersionSaveDocument,
			variables: {
				Entity: {
					Name: priceListApiDate + '; IsSOTrx=Y; ' + Math.floor(Math.random() * 1000000),
					Description: 'Create sales price list version',
					M_PriceList: { UU: defaultSalesPriceList.UU },
					ValidFrom: priceListApiDate,
					M_DiscountSchema: { UU: schema.UU },
				},
			},
			context,
		});
	}

	priceListVersionCount = withRequiredData(
		await graphqlClient.query({
			query: M_PriceList_VersionGetDocument,
			variables: {
				Filter: JSON.stringify({
					m_pricelist: { m_pricelist_uu: defaultPurchasePriceList.UU },
					validfrom: { $lte: priceListApiDate },
				}),
			},
			context,
		}),
	).data.M_PriceList_VersionGet.PagingInfo.TotalCount;
	if (!priceListVersionCount) {
		// get bogus price list schema - required field
		schema = withRequiredData(
			await graphqlClient.query({
				query: M_DiscountSchemaGetDocument,
				variables: { Filter: JSON.stringify({ discounttype: 'P' }) },
				context,
			}),
		).data.M_DiscountSchemaGet.Results[0];
		//
		await graphqlClient.mutate({
			mutation: M_PriceList_VersionSaveDocument,
			variables: {
				Entity: {
					Name: priceListApiDate + '; IsSOTrx=N; ' + Math.floor(Math.random() * 1000000),
					Description: 'Create sales price list version',
					M_PriceList: { UU: defaultPurchasePriceList.UU },
					ValidFrom: priceListApiDate,
					M_DiscountSchema: { UU: schema.UU },
				},
			},
		});
	}
}

export async function setup() {
	let loginInfo: LoginInfo = {} as LoginInfo;
	const valueObject: { sessionToken?: string } = { sessionToken: undefined };
	loginInfo.AD_User = withRequiredData(
		await graphqlClient.mutate({
			mutation: SignInDocument,
			variables: { Credentials: initialLoginData },
			context: { valueObject },
		}),
	).data.SignIn.AD_User;
	if (!valueObject.sessionToken) {
		throw new Error('no token generated');
	}
	loginInfo.token = valueObject.sessionToken;
	const clients = withRequiredData(
		await graphqlClient.query({
			query: Ad_ClientGetDocument,
			context: { valueObject: { sessionToken: loginInfo.token } },
		}),
	).data.AD_ClientGet.Results;
	loginInfo.AD_Clients = clients;

	// Find the client & org we'll use
	let client = clients.find((client) => client.Name === clientName);
	const organization = client?.AD_Orgs[0];
	const roles = organization?.AD_Roles;
	if (!client) {
		throw new Error(
			`Could not find client "${clientName}". Vitest requires this AD_Client to exist. ` +
				`On a new database, run the GraphQL SOAP data population first ` +
				`(./dev.sh test graphql, or ./runTests.sh in graphql-test/testing). ` +
				`Configure the name with IDEMPIERE_GRAPHQL_TEST_CLIENT (current: "${clientName}").`,
		);
	}
	if (!organization) {
		throw new Error(`client "${client.Name}" didn't have any organizations`);
	}
	if (!roles?.length) {
		throw new Error(`organization "${organization.Name}" didn't come with any roles`);
	}
	loginInfo.AD_Client = client;
	loginInfo.AD_Client_UU = client.UU;
	loginInfo.AD_Org_UU = organization.UU;
	loginInfo.M_Warehouse_UU = organization.M_Warehouses![0].UU;

	// No change access for the admin by default so we can get the right session token
	const adminRole = roles.find((role) => role.Name.endsWith('Admin'));
	if (adminRole) {
		const baseLoginData: ChangeAccessMutationVariables['Access'] = {
			AD_Client_UU: client.UU,
			AD_Org_UU: organization.UU,
			AD_Role_UU: adminRole.UU,
			M_Warehouse_UU: organization.M_Warehouses?.[0].UU!,
		};
		await graphqlClient.query({
			query: ChangeAccessDocument,
			variables: { Access: baseLoginData },
			context: { valueObject },
		});
		// Update the session token appropriately
		loginInfo.token = valueObject.sessionToken;

		// Get some initial data
		const initialData = withRequiredData(
			await graphqlClient.query({
				query: Ad_RoleLocationPriceListsCurrencyGetDocument,
				variables: {
					AD_RoleFilter: JSON.stringify({ ad_role_uu: adminRole.UU }),
					C_LocationFilter: JSON.stringify({ c_bpartner_location: { c_bpartner: { name: 'Standard' } } }),
					M_PriceListFilter: JSON.stringify({ isdefault: true }),
				},
				context: { valueObject },
			}),
		).data;
		loginInfo.AD_Role = initialData.AD_RoleGet.Results[0];
		loginInfo.C_Region = initialData.C_LocationGet.Results[0].C_Region;
		loginInfo.C_Country = initialData.C_LocationGet.Results[0].C_Country;
		loginInfo.C_Currency = initialData.C_AcctSchemaGet.Results[0].C_Currency;
		// Make sure prices lists are ready for the client
		createDefaultPriceLists(initialData.M_PriceListGet.Results, loginInfo);
	}

	// use the file system to expose the admin login information
	await mkdir(workingDirectory, { recursive: true });
	await writeFile(join(workingDirectory, 'loginInfo'), JSON.stringify(loginInfo));
}

export { default as teardown } from './teardown';
