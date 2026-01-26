import {
	DashboardFinancialHistoricalGetDocument,
	DashboardFinancialVisitChargesGetDocument,
	DashboardInventoryHistoricalChargeEarningGetDocument,
	DashboardInventoryHistoricalValueGetDocument,
} from '../__generated__/graphql';
import { query } from '../api';

test('six-month time range always returned for historical finances', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardFinancialHistoricalGetDocument })).data
		.DashboardFinancialHistoricalGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());

	
});

test('six-month time range always returned for historical visit charges', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardFinancialVisitChargesGetDocument })).data
		.DashboardFinancialVisitChargesGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('six-month time range always returned for historical inventory values', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardInventoryHistoricalValueGetDocument })).data
		.DashboardInventoryHistoricalValueGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});

test('six-month time range always returned for historical inventory charges and earnings', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const data = (await query(valueObject)({ query: DashboardInventoryHistoricalChargeEarningGetDocument })).data
		.DashboardInventoryHistoricalChargeEarningGet;
	expect(data).toHaveLength(6);
	expect(new Date(data[0]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 5 + 12) % 12);
	expect(new Date(data[1]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 4 + 12) % 12);
	expect(new Date(data[2]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 3 + 12) % 12);
	expect(new Date(data[3]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 2 + 12) % 12);
	expect(new Date(data[4]?.BucketValue || new Date()).getMonth()).toBe((new Date().getMonth() - 1 + 12) % 12);
	expect(new Date(data[5]?.BucketValue || new Date()).getMonth()).toBe(new Date().getMonth());
});
