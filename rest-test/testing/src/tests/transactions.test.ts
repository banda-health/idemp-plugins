import { transactionApi, orderApi } from '../api';
import { Transaction } from '../types/org.bandahealth.idempiere.rest';
import { documentAction, documentBaseType, documentStatus } from '../models';
import { createOrder, createProduct, createBusinessPartner } from '../utils';

test('fetch transactions', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();
	
	valueObject.stepName = 'Create vendor';
	await createBusinessPartner(valueObject);
	
	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);
	expect(valueObject.order?.docStatus).toBe(documentStatus.Completed);
	try {
		await orderApi.process(valueObject, valueObject.order!.uuid, documentAction.Close);
		expect(true).toBe(false);
	} catch {
		expect(true).toBe(true);
	}

	const transactions = (
		await transactionApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ m_product: { m_product_uu: valueObject.product?.uuid } }))
	).results;
	expect(transactions).toHaveLength(1);
	expect(transactions[0].movementQuantity).toBe(1);
	expect(transactions[0].movementType).toBe('V+');
});
