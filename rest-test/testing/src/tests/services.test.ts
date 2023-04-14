import { serviceApi } from '../api';
import { Service } from '../types/org.bandahealth.idempiere.rest';

test('can create and fetch services', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	let service: Partial<Service> = {
		orgId: 0,
		description: valueObject.getStepMessageLong(),
		name: valueObject.getDynamicScenarioName(),
		productCategoryUuid: '',
		sellingPrice: 200,
	};
	service = await serviceApi.save(valueObject, service as Service);
	expect(service).toBeTruthy();

	const services = (
		await serviceApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ name: service.name! }))
	).results;
	expect(services).toHaveLength(1);
	expect(services[0].name).toEqual(service.name);
});
