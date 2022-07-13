import { Visit } from '../types/org.bandahealth.idempiere.rest';
import { v4 } from 'uuid';
import { createBusinessPartner, createOrder } from '../utils';

test(`patient open balance updated after visit if complete payment wasn't made`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	const visit: Visit = {
		uuid: v4(),
		newVisit: true,
		clinicalNotes: '',
		labNotes: '',
		patientType: {},
	};
});

test(`patient open balance reverted correctly after visit with partial payment is re-opened`, async () => {
	await globalThis.__VALUE_OBJECT__.login();
	await createBusinessPartner(globalThis.__VALUE_OBJECT__);
	await createOrder(globalThis.__VALUE_OBJECT__);
});
