import { readFileSync } from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';
import { PdfData } from 'pdfdataextract';
import { v4 } from 'uuid';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import {
	createBusinessPartner,
	createInOutFromOrder,
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

const testDir = path.dirname(fileURLToPath(import.meta.url));
const reportUuid = '477cdda4-82ff-4bac-834f-08de384df412';

test('visit invoice report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Set logo image';
	const organizationInformation = (
		await query(valueObject)({
			query: Ad_OrgInfoGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_org: { ad_org_uu: valueObject.organization!.UU } }) },
		})
	).data.AD_OrgInfoGet.Results[0];
	const logoUuid = organizationInformation.Logo?.UU || v4();
	await mutate(valueObject)({
		mutation: LogoAndAd_OrgInfoSaveDocument,
		variables: {
			Logo: {
				UU: logoUuid,
				Name: 'logo.png',
				ImageURL: 'logo.png',
				BinaryData: readFileSync(path.join(testDir, '../../assets/logo.png'), 'base64'),
			},
			AD_OrgInfo: {
				UU: organizationInformation.UU,
				Logo: {
					UU: logoUuid,
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

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: process.AD_Process_ParaList![0].Name,
			Parameter: valueObject.visit!.UU,
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});

test(`uploaded PDFs don't stop the report from running`, async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Set logo image';
	const organizationInformation = (
		await query(valueObject)({
			query: Ad_OrgInfoGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_org: { ad_org_uu: valueObject.organization!.UU } }) },
		})
	).data.AD_OrgInfoGet.Results[0];
	const logoUuid = organizationInformation.Logo?.UU || v4();
	await mutate(valueObject)({
		mutation: LogoAndAd_OrgInfoSaveDocument,
		variables: {
			Logo: {
				UU: logoUuid,
				Name: 'logo.pdf',
				ImageURL: 'logo.pdf',
				BinaryData: readFileSync(path.join(testDir, '../../assets/logo.pdf'), 'base64'),
			},
			AD_OrgInfo: {
				UU: organizationInformation.UU,
				Logo: {
					UU: logoUuid,
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

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: process.AD_Process_ParaList![0].Name,
			Parameter: valueObject.visit!.UU,
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text).toBeTruthy();
});
