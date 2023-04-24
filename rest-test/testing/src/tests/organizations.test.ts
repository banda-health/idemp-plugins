import { organizationApi } from '../api';
import { Organization, OrganizationInformation } from '../types/org.bandahealth.idempiere.rest';

test('save organization information', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	let organization = (
		await organizationApi.get(valueObject, 0, 1, undefined, undefined)
	).results[0];
	expect(organization).toBeTruthy();
	
	const organizationInformation: Partial<OrganizationInformation> = {
		facilityNumber: 'facility Number',
		headerMessage: 'header',
		receiptFooterMessage: 'footer message',
	};

	const saveOrganization: Partial<Organization> = {
		name: organization.name,
		description: organization.description,
		organizationInformation: organizationInformation as OrganizationInformation,
	};
	
	const savedOrganization = await organizationApi.save(valueObject, saveOrganization as Organization);

	expect(saveOrganization.name).toBe(saveOrganization.name);
	expect(saveOrganization.organizationInformation!.facilityNumber).toBe(savedOrganization.organizationInformation.facilityNumber);
	expect(saveOrganization.organizationInformation!.headerMessage).toBe(savedOrganization.organizationInformation.headerMessage);
	expect(saveOrganization.organizationInformation!.receiptFooterMessage).toBe(savedOrganization.organizationInformation.receiptFooterMessage);
});
