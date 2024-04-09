import { mutate, query } from '../api';
import { getDefaultProductCategory, getDefaultTaxCategory } from '../utils';
import { C_UomGetDefaultDocument, M_ProductGetDocument, M_ProductSaveDocument } from '../__generated__/graphql';

test('can create and fetch services', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const service = (
		await mutate(valueObject)({
			mutation: M_ProductSaveDocument,
			variables: {
				Entity: {
					AD_Org: { UU: valueObject.organization!.UU },
					Description: valueObject.getStepMessageLong(),
					Name: valueObject.getDynamicScenarioName(),
					C_TaxCategory: { UU: (await getDefaultTaxCategory(valueObject)).UU },
					M_Product_Category: { UU: (await getDefaultProductCategory(valueObject)).UU },
					C_UOM: { UU: (await query(valueObject)({ query: C_UomGetDefaultDocument })).data.C_UOMGetDefault.UU },
					ProductType: { UU: '265e0369-47e4-4be9-b6d5-e344230f5588' }, // Service
					BH_SellPrice: 200,
				},
			},
		})
	).data!.M_ProductSave!;
	expect(service).toBeTruthy();

	const services = (
		await query(valueObject)({
			query: M_ProductGetDocument,
			variables: { Filter: JSON.stringify({ name: service.Name! }) },
		})
	).data.M_ProductGet.Results;
	expect(services).toHaveLength(1);
	expect(services[0].Name).toEqual(service.Name);
});
