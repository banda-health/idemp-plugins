import { mutate, query } from '../api';
import { Ad_OrgGetDocument, Ad_OrgInfoSaveDocument } from '../__generated__/graphql';

test('save organization information', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const organization = (await query(valueObject)({ query: Ad_OrgGetDocument, variables: { size: 1 } })).data.AD_OrgGet
		.results[0]!;
	expect(organization).toBeTruthy();
	expect(organization.AD_OrgInfo).toBeTruthy();

	await mutate(valueObject)({
		mutation: Ad_OrgInfoSaveDocument,
		variables: {
			AD_OrgInfo: {
				UUID: organization.AD_OrgInfo!.UUID,
				BH_FacilityNumber: 'facility Number',
				BH_Header: 'header',
				ReceiptFooterMsg: 'footer message',
			},
		},
	});

	const savedOrganization = (await query(valueObject)({ query: Ad_OrgGetDocument, variables: { size: 1 } })).data
		.AD_OrgGet.results[0]!;
	expect(savedOrganization).toBeTruthy();
	expect(savedOrganization.AD_OrgInfo).toBeTruthy();

	expect(savedOrganization.Name).toBe(organization.Name);
	expect(savedOrganization.AD_OrgInfo!.BH_FacilityNumber).toBe('facility Number');
	expect(savedOrganization.AD_OrgInfo!.BH_Header).toBe('header');
	expect(savedOrganization.AD_OrgInfo!.ReceiptFooterMsg).toBe('footer message');
});
