import { organizationApi } from '../api';
import { Organization, OrganizationInformation } from '../types/org.bandahealth.idempiere.rest';

test('save organization information', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const organization = (await organizationApi.get(valueObject, 0, 1, undefined, undefined)).results[0];
	expect(organization).toBeTruthy();

	const organizationToSave: Partial<Organization> = {
		...organization,
		organizationInformation: {
			...organization.organizationInformation,
			facilityNumber: 'facility Number',
			headerMessage: 'header',
			receiptFooterMessage: 'footer message',
		} as OrganizationInformation,
	};

	const savedOrganization = await organizationApi.save(valueObject, organizationToSave as Organization);

	expect(savedOrganization.name).toBe(organizationToSave.name);
	expect(savedOrganization.organizationInformation.facilityNumber).toBe(
		organizationToSave.organizationInformation!.facilityNumber,
	);
	expect(savedOrganization.organizationInformation.headerMessage).toBe(
		organizationToSave.organizationInformation!.headerMessage,
	);
	expect(savedOrganization.organizationInformation.receiptFooterMessage).toBe(
		organizationToSave.organizationInformation!.receiptFooterMessage,
	);
});
