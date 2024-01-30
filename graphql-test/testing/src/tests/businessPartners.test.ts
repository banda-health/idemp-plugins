import { v4 } from 'uuid';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import { createBusinessPartner, createOrder, createProduct, createVisit, loadRegionAndCountry } from '../utils';
import {
	Bh_VisitProcessDocument,
	C_BPartnerGetDocument,
	C_BPartnerSaveWithLocationDocument,
	C_BPartner_LocationSaveDocument,
	C_Bp_GroupGetDocument,
	C_LocationGetDocument,
	C_LocationSaveDocument,
	C_LocationUpdateWithBPartnerDocument,
} from '../__generated__/graphql';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	await loadRegionAndCountry(valueObject);

	valueObject.stepName = 'Create business partner';
	const businessPartnerUuid = v4();
	const locationUuid = v4();
	const savedBusinessPartner = (
		await mutate(valueObject)({
			mutation: C_BPartnerSaveWithLocationDocument,
			variables: {
				C_BPartner: {
					UUID: businessPartnerUuid,
					Name: valueObject.getDynamicStepMessage(),
					Description: valueObject.getStepMessageLong(),
					BH_Birthday: valueObject.date?.getTime(),
					bh_gender: { UUID: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
					IsCustomer: true,
					IsVendor: true,
				},
				C_Location: {
					UUID: locationUuid,
					C_Region: valueObject.region
						? {
								UUID: valueObject.region.UUID,
						  }
						: undefined,
					C_Country: valueObject.country
						? {
								UUID: valueObject.country.UUID,
						  }
						: undefined,
					City: 'Test',
					Address1: '514 E North Ave',
				},
				C_BPartner_Location: {
					C_BPartner: {
						UUID: businessPartnerUuid,
					},
					C_Location: {
						UUID: locationUuid,
					},
					Name: valueObject.city + ' ' + valueObject.region?.Name,
				},
			},
		})
	).data?.C_BPartnerSave;

	const fetchedBusinessPartner = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { page: 0, size: 1, filter: JSON.stringify({ c_bpartner_uu: businessPartnerUuid }) },
		})
	).data.C_BPartnerGet.results[0];

	expect(fetchedBusinessPartner.TotalOpenBalance).toBe(0);
	expect(fetchedBusinessPartner.Name).toBe(savedBusinessPartner?.Name);
	expect(fetchedBusinessPartner.C_BPartner_Locations?.[0].C_Location.Address1).toBe('514 E North Ave');
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);
	const locationUuid = v4();
	valueObject.businessPartner = (
		await mutate(valueObject)({
			mutation: C_LocationUpdateWithBPartnerDocument,
			variables: {
				C_BPartner: {
					UUID: valueObject.businessPartner!.UUID,
					bh_gender: { UUID: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
					NationalID: '156156',
					bh_occupation: 'Programmer',
					NextOfKin_Name: 'Wifey',
					NextOfKin_Contact: '155155',
					C_BP_Group: {
						UUID: (
							await query(valueObject)({
								query: C_Bp_GroupGetDocument,
								variables: { filter: JSON.stringify({ name: 'Patients - DO NOT CHANGE' }) },
							})
						).data.C_BP_GroupGet.results[0].UUID,
					},
				},
				C_Location: {
					UUID: locationUuid,
					C_Region: valueObject.region
						? {
								UUID: valueObject.region.UUID,
						  }
						: undefined,
					C_Country: valueObject.country
						? {
								UUID: valueObject.country.UUID,
						  }
						: undefined,
					City: 'Test',
					Address1: '514 E North Ave',
				},
				C_BPartner_Location: {
					UUID: valueObject.businessPartner!.C_BPartner_Locations?.[0].UUID,
					C_BPartner: {
						UUID: valueObject.businessPartner!.UUID,
					},
					C_Location: {
						UUID: locationUuid,
					},
					Name: valueObject.city + ' ' + valueObject.region?.Name,
				},
			},
		})
	).data?.C_BPartnerSave;

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	const twoDaysAgo = new Date();
	twoDaysAgo.setDate(twoDaysAgo.getDate() - 2);
	twoDaysAgo.setUTCHours(12);
	valueObject.date = twoDaysAgo;
	await createVisit(valueObject);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	const searchedBusinessPartners = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: {
				page: 0,
				size: 10,
				filter: JSON.stringify({
					name: valueObject.businessPartner?.Name,
					c_bp_group: { name: valueObject.businessPartner?.C_BP_Group.Name },
				}),
			},
		})
	).data.C_BPartnerGet.results;
	expect(searchedBusinessPartners).toHaveLength(1);

	const specificBusinessPartner = searchedBusinessPartners[0];
	expect(specificBusinessPartner.LastVisitDate).toBe(twoDaysAgo.getTime());
	expect(specificBusinessPartner.TotalVisits).toBe(1);
	expect(specificBusinessPartner.NationalID).toBe(valueObject.businessPartner?.NationalID);
	expect(specificBusinessPartner.bh_occupation).toBe(valueObject.businessPartner?.bh_occupation);
	expect(specificBusinessPartner.NextOfKin_Name).toBe(valueObject.businessPartner?.NextOfKin_Name);
	expect(specificBusinessPartner.NextOfKin_Contact).toBe(valueObject.businessPartner?.NextOfKin_Contact);
	expect(specificBusinessPartner.C_BPartner_Locations?.[0].C_Location.Address1).toBe(
		valueObject.businessPartner?.C_BPartner_Locations?.[0].C_Location.Address1,
	);

	const address1 = 'Cool New Place';
	let existingLocation = (
		await query(valueObject)({
			query: C_LocationGetDocument,
			variables: {
				page: 0,
				size: 1,
				filter: JSON.stringify({
					address1,
					c_region: valueObject.region ? { c_region_uu: valueObject.region.UUID } : undefined,
					c_country: valueObject.country ? { c_country_uu: valueObject.country.UUID } : undefined,
				}),
			},
		})
	).data.C_LocationGet.results[0];
	if (!existingLocation) {
		existingLocation = (
			await mutate(valueObject)({
				mutation: C_LocationSaveDocument,
				variables: {
					entity: {
						C_Region: valueObject.region
							? {
									UUID: valueObject.region.UUID,
							  }
							: undefined,
						C_Country: valueObject.country
							? {
									UUID: valueObject.country.UUID,
							  }
							: undefined,
						City: 'Test',
						Address1: address1,
					},
				},
			})
		).data!.C_LocationSave;
	}
	await mutate(valueObject)({
		mutation: C_BPartner_LocationSaveDocument,
		variables: {
			entity: {
				UUID: specificBusinessPartner.C_BPartner_Locations?.[0].UUID,
				C_Location: { UUID: existingLocation.UUID },
			},
		},
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { filter: JSON.stringify({ c_bpartner_uu: specificBusinessPartner.UUID }) },
			})
		).data.C_BPartnerGet.results[0].C_BPartner_Locations?.[0].C_Location.Address1,
	).toBe(address1);
});
