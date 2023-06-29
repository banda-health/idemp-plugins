import { readFileSync } from 'fs';
import path from 'path';
import { PdfData } from 'pdfdataextract';
import { organizationApi, processApi, visitApi } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import { Image, ProcessInfoParameter } from '../../types/org.bandahealth.idempiere.rest';
import {
	createOrder,
	createPatient,
	createPayment,
	createProduct,
	createPurchaseOrder,
	createVendor,
	createVisit,
	runReport,
} from '../../utils';

const reportUuid = '477cdda4-82ff-4bac-834f-08de384df412';

test('voided transactions report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Set logo image';
	const organization = (await organizationApi.get(valueObject)).results[0];
	organization.organizationInformation.logo = {
		...(organization.organizationInformation.logo || {}),
		name: 'logo.png',
		imageUrl: 'logo.png',
		binaryData: readFileSync(path.join(__dirname, '../../assets/logo.png'), 'base64'),
	} as Image;
	await organizationApi.save(valueObject, organization);

	valueObject.stepName = 'Create business partner';
	await createVendor(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	await createPurchaseOrder(valueObject);

	valueObject.stepName = 'Create patient';
	valueObject.businessPartner = undefined;
	await createPatient(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create order';
	valueObject.documentAction = undefined;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		documentSubTypeSalesOrder.OnCreditOrder,
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = undefined;
	await createPayment(valueObject);

	valueObject.stepName = 'Complete visit';
	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

	const process = (
		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
	).results[0];

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.uuid;
	valueObject.processInformationParameters = [
		{ processParameterUuid: process.parameters[0].uuid, parameter: valueObject.visit!.uuid } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
