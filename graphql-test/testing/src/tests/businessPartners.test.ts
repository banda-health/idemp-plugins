import { v4 } from 'uuid';
import {
	Bh_BPartner_TagsDeleteDocument,
	Bh_BPartner_TagsSaveDocument,
	Bh_TagSaveDocument,
	Bh_VisitProcessDocument,
	C_BPartnerDocument,
	C_BPartnerGetDocument,
	C_BPartnerMergeDocument,
	C_BPartnerSaveDocument,
	C_BPartnerSaveWithLocationDocument,
	C_BPartner_LocationSaveDocument,
	C_Bp_GroupGetDocument,
	C_LocationGetDocument,
	C_LocationSaveDocument,
	C_LocationUpdateWithBPartnerDocument,
} from '../__generated__/graphql';
import { mutate, query } from '../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	formatApiDate,
} from '../utils';

test(`information saved correctly`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	const businessPartnerUuid = v4();
	const locationUuid = v4();
	const businessPartnerName = valueObject.getDynamicStepMessage();
	await mutate(valueObject)({
		mutation: C_BPartnerSaveWithLocationDocument,
		variables: {
			C_BPartner: {
				UU: businessPartnerUuid,
				Name: businessPartnerName,
				Description: valueObject.getStepMessageLong(),
				BH_Birthday: formatApiDate(valueObject.date),
				bh_gender: { UU: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
				IsCustomer: true,
				IsVendor: true,
			},
			C_Location: {
				UU: locationUuid,
				C_Region: valueObject.region
					? {
							UU: valueObject.region.UU,
					  }
					: undefined,
				C_Country: valueObject.country
					? {
							UU: valueObject.country.UU,
					  }
					: undefined,
				City: 'Test',
				Address1: '514 E North Ave',
			},
			C_BPartner_Location: {
				C_BPartner: {
					UU: businessPartnerUuid,
				},
				C_Location: {
					UU: locationUuid,
				},
				Name: valueObject.city + ' ' + valueObject.region?.Name,
			},
		},
	});

	const fetchedBusinessPartner = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { Page: 0, Size: 1, Filter: JSON.stringify({ c_bpartner_uu: businessPartnerUuid }) },
		})
	).data.C_BPartnerGet.Results[0];

	expect(fetchedBusinessPartner.TotalOpenBalance).toBe(0);
	expect(fetchedBusinessPartner.Name).toBe(businessPartnerName);
	expect(fetchedBusinessPartner.C_BPartner_Locations?.[0].C_Location.Address1).toBe('514 E North Ave');
});

test(`get method returns the correct data`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);
	const locationUuid = v4();
	await mutate(valueObject)({
		mutation: C_LocationUpdateWithBPartnerDocument,
		variables: {
			C_BPartner: {
				UU: valueObject.businessPartner!.UU,
				bh_gender: { UU: '73c2b736-830b-430e-bc43-571c6372ba22' }, // male
				NationalID: '156156',
				bh_occupation: 'Programmer',
				NextOfKin_Name: 'Wifey',
				NextOfKin_Contact: '155155',
				C_BP_Group: {
					UU: (
						await query(valueObject)({
							query: C_Bp_GroupGetDocument,
							variables: { Filter: JSON.stringify({ name: 'Patients - DO NOT CHANGE' }) },
						})
					).data.C_BP_GroupGet.Results[0].UU,
				},
			},
			C_Location: {
				UU: locationUuid,
				C_Region: valueObject.region
					? {
							UU: valueObject.region.UU,
					  }
					: undefined,
				C_Country: valueObject.country
					? {
							UU: valueObject.country.UU,
					  }
					: undefined,
				City: 'Test',
				Address1: '514 E North Ave',
			},
			C_BPartner_Location: {
				UU: valueObject.businessPartner!.C_BPartner_Locations?.[0].UU,
				C_BPartner: {
					UU: valueObject.businessPartner!.UU,
				},
				C_Location: {
					UU: locationUuid,
				},
				Name: valueObject.city + ' ' + valueObject.region?.Name,
			},
		},
	});
	valueObject.businessPartner = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: { Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
		})
	).data.C_BPartnerGet.Results[0];

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
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const searchedBusinessPartners = (
		await query(valueObject)({
			query: C_BPartnerGetDocument,
			variables: {
				Page: 0,
				Size: 10,
				Filter: JSON.stringify({
					name: valueObject.businessPartner?.Name,
					c_bp_group: { name: valueObject.businessPartner?.C_BP_Group.Name },
				}),
			},
		})
	).data.C_BPartnerGet.Results;
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
				Page: 0,
				Size: 1,
				Filter: JSON.stringify({
					address1,
					c_region: valueObject.region ? { c_region_uu: valueObject.region.UU } : undefined,
					c_country: valueObject.country ? { c_country_uu: valueObject.country.UU } : undefined,
				}),
			},
		})
	).data.C_LocationGet.Results[0];
	if (!existingLocation) {
		existingLocation = (
			await mutate(valueObject)({
				mutation: C_LocationSaveDocument,
				variables: {
					Entity: {
						C_Region: valueObject.region
							? {
									UU: valueObject.region.UU,
							  }
							: undefined,
						C_Country: valueObject.country
							? {
									UU: valueObject.country.UU,
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
			Entity: {
				UU: specificBusinessPartner.C_BPartner_Locations?.[0].UU,
				C_Location: { UU: existingLocation.UU },
			},
		},
	});
	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Filter: JSON.stringify({ c_bpartner_uu: specificBusinessPartner.UU }) },
			})
		).data.C_BPartnerGet.Results[0].C_BPartner_Locations?.[0].C_Location.Address1,
	).toBe(address1);
});

test(`age not cleared after orders processed`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	const birthday = new Date();
	birthday.setFullYear(birthday.getFullYear() - 12);
	valueObject.date = birthday;
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);
	let savedBusinessPartner = (
		await query(valueObject)({
			query: C_BPartnerDocument,
			variables: {
				UU: valueObject.businessPartner!.UU,
			},
		})
	).data.C_BPartner!;
	expect(savedBusinessPartner).toBeTruthy();
	expect(savedBusinessPartner.BH_Birthday).toBeTruthy();

	valueObject.stepName = 'Create purchase order';
	valueObject.date = new Date();
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);
	savedBusinessPartner = (
		await query(valueObject)({
			query: C_BPartnerDocument,
			variables: {
				UU: valueObject.businessPartner!.UU,
			},
		})
	).data.C_BPartner!;
	expect(savedBusinessPartner).toBeTruthy();
	expect(savedBusinessPartner.BH_Birthday).toBeTruthy();

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.OnCreditOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create partial payment';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.APPayment, null, true, false, false);
	valueObject.paymentAmount = 50;
	await createPayment(valueObject);

	savedBusinessPartner = (
		await query(valueObject)({
			query: C_BPartnerDocument,
			variables: {
				UU: valueObject.businessPartner!.UU,
			},
		})
	).data.C_BPartner!;
	expect(savedBusinessPartner).toBeTruthy();
	expect(savedBusinessPartner.BH_Birthday).toBeTruthy();
});

test(`drafted and re-opened visits don't count in the total visits or affect last visit date`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	let businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })
	).data.C_BPartner!;
	expect(businessPartner.TotalVisits).toBe(0);
	expect(businessPartner.LastVisitDate).toBe(null);

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })
	).data.C_BPartner!;
	expect(businessPartner.TotalVisits).toBe(1);
	expect(businessPartner.LastVisitDate).not.toBe(null);

	valueObject.stepName = 'Re-activate visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.ReActivate },
	});

	businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU } })
	).data.C_BPartner!;
	expect(businessPartner.TotalVisits).toBe(0);
	expect(businessPartner.LastVisitDate).toBe(null);
});

test('can search using an apostrophe', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	const newName = `a'a${valueObject.businessPartner!.Name}`;
	await mutate(valueObject)({
		mutation: C_BPartnerSaveDocument,
		variables: { Entity: { UU: valueObject.businessPartner!.UU, Name: newName } },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Filter: JSON.stringify({ name: { $text: newName } }) },
			})
		).data.C_BPartnerGet.Results,
	).toHaveLength(1);
});

test('merging patients', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner 1';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 1';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order 1';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit 1';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-2);
	await createVisit(valueObject);

	valueObject.stepName = 'Create order 1';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice 1';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment 1';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 23;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit 1';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const businessPartner1 = valueObject.businessPartner!;

	valueObject.clearBusinessPartner();
	valueObject.clearProduct();

	valueObject.stepName = 'Create business partner 2';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product 2';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order 2';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create visit 2';
	valueObject.documentAction = undefined;
	valueObject.setDateOffset(-2);
	await createVisit(valueObject);

	valueObject.stepName = 'Create order 2';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.WarehouseOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create invoice 2';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
	await createInvoice(valueObject);

	valueObject.stepName = 'Create payment 2';
	valueObject.documentAction = undefined;
	valueObject.paymentAmount = 68;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit 2';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const businessPartner2 = valueObject.businessPartner!;

	const result = (
		await mutate(valueObject)({
			mutation: C_BPartnerMergeDocument,
			variables: { OldUU: businessPartner1.UU, NewUU: businessPartner2.UU },
		})
	).data?.C_BPartnerMerge;
	expect(result).toBe(true);

	let businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: businessPartner1.UU } })
	).data.C_BPartner;
	expect(businessPartner).toBeFalsy();
	businessPartner = (await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: businessPartner2.UU } }))
		.data.C_BPartner!;
	expect(businessPartner).toBeTruthy();
	expect(businessPartner.TotalOpenBalance).toBe(109);
	expect(businessPartner.Contacts).toHaveLength(1);
	expect(businessPartner.C_BPartner_Locations).toHaveLength(1);
});

test('business partner be assigned a tag', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create tag 1';
	const tag1UU = v4();
	await mutate(valueObject)({
		mutation: Bh_TagSaveDocument,
		variables: {
			Entity: {
				BH_ColourCode: '#aaaaa',
				Description: valueObject.getStepMessageLong(),
				IsActive: true,
				Name: valueObject.random + valueObject.getStepMessageLong(),
				UU: tag1UU,
			},
		},
	});

	valueObject.stepName = 'Create tag 2';
	const tag2UU = (
		await mutate(valueObject)({
			mutation: Bh_TagSaveDocument,
			variables: {
				Entity: {
					Description: valueObject.getStepMessageLong(),
					IsActive: true,
					Name: valueObject.random + valueObject.getStepMessageLong(),
				},
			},
		})
	).data!.BH_TagSave.UU;

	valueObject.stepName = 'Assign BP Tag';
	await mutate(valueObject)({
		mutation: Bh_BPartner_TagsSaveDocument,
		variables: {
			Entity: {
				BH_Tag: { UU: tag1UU },
				C_BPartner: { UU: valueObject.businessPartner!.UU },
			},
		},
	});
	await mutate(valueObject)({
		mutation: Bh_BPartner_TagsSaveDocument,
		variables: {
			Entity: {
				BH_Tag: { UU: tag2UU },
				C_BPartner: { UU: valueObject.businessPartner!.UU },
			},
		},
	});

	let businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU! } })
	).data.C_BPartner!;

	expect(businessPartner).toBeTruthy();
	expect(businessPartner.BH_BPartner_Tags).toBeTruthy();
	expect(businessPartner.BH_BPartner_Tags).toHaveLength(2);
	expect(businessPartner.BH_BPartner_Tags![0].BH_Tag.UU).toBe(tag1UU);
	expect(businessPartner.BH_BPartner_Tags![1].BH_Tag.UU).toBe(tag2UU);

	await mutate(valueObject)({
		mutation: Bh_BPartner_TagsDeleteDocument,
		variables: {
			UUs: [businessPartner.BH_BPartner_Tags![1].UU],
		},
	});
	businessPartner = (
		await query(valueObject)({ query: C_BPartnerDocument, variables: { UU: valueObject.businessPartner!.UU! } })
	).data.C_BPartner!;

	expect(businessPartner).toBeTruthy();
	expect(businessPartner.BH_BPartner_Tags).toBeTruthy();
	expect(businessPartner.BH_BPartner_Tags).toHaveLength(1);
	expect(businessPartner.BH_BPartner_Tags![0].BH_Tag.UU).toBe(tag1UU);
});
