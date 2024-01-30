import { readFileSync } from 'fs';
import path from 'path';
import { PdfData } from 'pdfdataextract';
import { v4 } from 'uuid';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import {
	createBusinessPartner,
	createInvoice,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	runReport,
} from '../../utils';
import {
	Ad_OrgInfoGetDocument,
	Ad_ProcessGetDocument,
	Bh_VisitProcessDocument,
	LogoAndAd_OrgInfoSaveDocument,
} from '../../__generated__/graphql';

const reportUuid = '477cdda4-82ff-4bac-834f-08de384df412';

test('visit invoice report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Set logo image';
	const organizationInformation = (
		await query(valueObject)({
			query: Ad_OrgInfoGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_org: { ad_org_uu: valueObject.organization!.UUID } }) },
		})
	).data.AD_OrgInfoGet.results[0];
	const logoUuid = organizationInformation.Logo?.UUID || v4();
	await mutate(valueObject)({
		mutation: LogoAndAd_OrgInfoSaveDocument,
		variables: {
			logo: {
				UUID: logoUuid,
				Name: 'logo.png',
				ImageURL: 'logo.png',
				BinaryData: readFileSync(path.join(__dirname, '../../assets/logo.png'), 'base64'),
			},
			AD_OrgInfo: {
				UUID: organizationInformation.UUID,
				Logo: {
					UUID: logoUuid,
				},
			},
		},
	});

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

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.results[0];

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UUID;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UUID: process.UUID },
			ParameterName: process.AD_Process_ParaList![0].Name,
			Parameter: valueObject.visit!.UUID,
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});

test(`uploaded PDFs dont's stop the report from running`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Set logo image';
	const organizationInformation = (
		await query(valueObject)({
			query: Ad_OrgInfoGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_org: { ad_org_uu: valueObject.organization!.UUID } }) },
		})
	).data.AD_OrgInfoGet.results[0];
	const logoUuid = organizationInformation.Logo?.UUID || v4();
	await mutate(valueObject)({
		mutation: LogoAndAd_OrgInfoSaveDocument,
		variables: {
			logo: {
				UUID: logoUuid,
				Name: 'logo.pdf',
				ImageURL: 'logo.pdf',
				BinaryData: readFileSync(path.join(__dirname, '../../assets/logo.pdf'), 'base64'),
			},
			AD_OrgInfo: {
				UUID: organizationInformation.UUID,
				Logo: {
					UUID: logoUuid,
				},
			},
		},
	});

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

	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { uuid: valueObject.visit!.UUID, documentAction: documentAction.Complete },
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.results[0];

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UUID;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UUID: process.UUID },
			ParameterName: process.AD_Process_ParaList![0].Name,
			Parameter: valueObject.visit!.UUID,
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
