import { PdfData } from 'pdfdataextract';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../../src/models';
import { Ad_ProcessGetDocument, Bh_VisitProcessDocument } from '../../__generated__/graphql';
import { mutate, query } from '../../api';
import {
	createBusinessPartner,
	createInOutFromOrder,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	runReport,
	tomorrow,
	yesterday,
} from '../../utils';

const reportUuid = '4cf22d3f-1fc8-4bdd-83e1-fc5d79537269';

test('report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	const paymentModeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Payment Mode');
	const patientTypeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Patient Type');
	const completedByParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Completed By');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(paymentModeParameter).toBeTruthy();
	expect(patientTypeParameter).toBeTruthy();
	expect(completedByParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().getTime(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: endDateParameter!.Name,
			Parameter: tomorrow().toISOString(),
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test('data visible on report', async () => {
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

	valueObject.stepName = 'Create material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

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

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	const paymentModeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Payment Mode');
	const patientTypeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Patient Type');
	const completedByParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Completed By');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(paymentModeParameter).toBeTruthy();
	expect(patientTypeParameter).toBeTruthy();
	expect(completedByParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().getTime(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: endDateParameter!.Name,
			Parameter: tomorrow().toISOString(),
		},
	];
	await runReport(valueObject);

	expect(
		(await PdfData.extract(new Uint8Array(valueObject.report!))).text
			?.join('')
			.replaceAll('\n', '')
			.replaceAll(' ', ''),
	).toContain(valueObject.businessPartner!.Name.replaceAll(' ', ''));
});
