// import { readFileSync } from 'fs';
// import path from 'path';
// import { PdfData } from 'pdfdataextract';
// import { organizationApi, processApi, visitApi } from '../../api';
// import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
// import { Image, ProcessInfoParameter } from '../../types/org.bandahealth.idempiere.rest';
// import {
// 	createBusinessPartner,
// 	createInvoice,
// 	createOrder,
// 	createPayment,
// 	createProduct,
// 	createVisit,
// 	runReport,
// } from '../../utils';

// const reportUuid = '477cdda4-82ff-4bac-834f-08de384df412';

// test('visit invoice report is runnable', async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Set logo image';
// 	const organization = (await organizationApi.get(valueObject)).results[0];
// 	organization.organizationInformation.logo = {
// 		...(organization.organizationInformation.logo || {}),
// 		name: 'logo.png',
// 		imageUrl: 'logo.png',
// 		binaryData: readFileSync(path.join(__dirname, '../../assets/logo.png'), 'base64'),
// 	} as Image;
// 	await organizationApi.save(valueObject, organization);

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	valueObject.stepName = 'Create visit';
// 	valueObject.documentAction = undefined;
// 	await createVisit(valueObject);

// 	valueObject.stepName = 'Create order';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(
// 		documentBaseType.SalesOrder,
// 		documentSubTypeSalesOrder.WarehouseOrder,
// 		true,
// 		false,
// 		false,
// 	);
// 	await createOrder(valueObject);

// 	valueObject.stepName = 'Create invoice';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
// 	await createInvoice(valueObject);

// 	valueObject.stepName = 'Create payment';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	valueObject.stepName = 'Complete visit';
// 	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

// 	const process = (
// 		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
// 	).results[0];

// 	valueObject.stepName = 'Run report';
// 	valueObject.processUuid = process.uuid;
// 	valueObject.processInformationParameters = [
// 		{ processParameterUuid: process.parameters[0].uuid, parameter: valueObject.visit!.uuid } as ProcessInfoParameter,
// 	];
// 	await runReport(valueObject);

// 	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
// });

// test(`uploaded PDFs dont's stop the report from running`, async () => {
// 	const valueObject = globalThis.__VALUE_OBJECT__;
// 	await valueObject.login();

// 	valueObject.stepName = 'Set logo image';
// 	const organization = (await organizationApi.get(valueObject)).results[0];
// 	organization.organizationInformation.logo = {
// 		...(organization.organizationInformation.logo || {}),
// 		name: 'logo.png',
// 		imageUrl: 'logo.png',
// 		binaryData: readFileSync(path.join(__dirname, '../../assets/logo.pdf'), 'base64'),
// 	} as Image;
// 	await organizationApi.save(valueObject, organization);

// 	valueObject.stepName = 'Create business partner';
// 	await createBusinessPartner(valueObject);

// 	valueObject.stepName = 'Create product';
// 	valueObject.salesStandardPrice = 100;
// 	await createProduct(valueObject);

// 	valueObject.stepName = 'Create purchase order';
// 	valueObject.documentAction = documentAction.Complete;
// 	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
// 	await createOrder(valueObject);

// 	valueObject.stepName = 'Create visit';
// 	valueObject.documentAction = undefined;
// 	await createVisit(valueObject);

// 	valueObject.stepName = 'Create order';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(
// 		documentBaseType.SalesOrder,
// 		documentSubTypeSalesOrder.WarehouseOrder,
// 		true,
// 		false,
// 		false,
// 	);
// 	await createOrder(valueObject);

// 	valueObject.stepName = 'Create invoice';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARInvoice, null, true, false, false);
// 	await createInvoice(valueObject);

// 	valueObject.stepName = 'Create payment';
// 	valueObject.documentAction = undefined;
// 	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
// 	await createPayment(valueObject);

// 	valueObject.stepName = 'Complete visit';
// 	valueObject.visit = await visitApi.saveAndProcess(valueObject, valueObject.visit!, documentAction.Complete);

// 	const process = (
// 		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
// 	).results[0];

// 	valueObject.stepName = 'Run report';
// 	valueObject.processUuid = process.uuid;
// 	valueObject.processInformationParameters = [
// 		{ processParameterUuid: process.parameters[0].uuid, parameter: valueObject.visit!.uuid } as ProcessInfoParameter,
// 	];
// 	await runReport(valueObject);

// 	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
// });

export {};
