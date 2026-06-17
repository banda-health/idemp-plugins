import { PdfData } from 'pdfdataextract';
import { initialLoginData, mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import {
	createBusinessPartner,
	createInOutFromOrder,
	createOrder,
	createPayment,
	createProduct,
	createVisit,
	runReport,
} from '../../utils';
import { Ad_LanguageGetDocument, ChangeAccessDocument, SignInDocument } from '../../__generated__/graphql';

const visitReceiptReportUuid = '30dd7243-11c1-4584-af26-5d977d117c84';

test('visit receipt report generates PDF content in foreign language', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Create business partner';
	await createBusinessPartner(valueObject);

	valueObject.stepName = 'Create product';
	valueObject.salesStandardPrice = 100;
	await createProduct(valueObject);

	valueObject.stepName = 'Create purchase order';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 200;
	await valueObject.setDocumentBaseType(documentBaseType.PurchaseOrder, null, false, false, false);
	await createOrder(valueObject);

	valueObject.stepName = 'Create material receipt';
	valueObject.documentAction = documentAction.Complete;
	await valueObject.setDocumentBaseType(documentBaseType.MaterialReceipt, null, false, false, false);
	await createInOutFromOrder(valueObject);

	valueObject.stepName = 'Create visit';
	valueObject.documentAction = undefined;
	await createVisit(valueObject);

	valueObject.stepName = 'Create sales order';
	valueObject.documentAction = documentAction.Complete;
	valueObject.quantity = 30;
	await valueObject.setDocumentBaseType(
		documentBaseType.SalesOrder,
		{ sales: documentSubTypeSalesOrder.POSOrder },
		true,
		false,
		false,
	);
	await createOrder(valueObject);

	valueObject.stepName = 'Create payment';
	valueObject.documentAction = documentAction.Complete;
	valueObject.paymentAmount = 19;
	await valueObject.setDocumentBaseType(documentBaseType.ARReceipt, null, true, false, false);
	await createPayment(valueObject);

	valueObject.stepName = 'Sign in with French language';
	const french = (
		await query(valueObject)({
			query: Ad_LanguageGetDocument,
			variables: { Filter: JSON.stringify({ ad_language: 'fr_FR' }) },
		})
	).data.AD_LanguageGet.Results[0];
	expect(french).toBeTruthy();
	expect(french.IsLoginLocale).toBe(true);

	await mutate(valueObject)({
		mutation: SignInDocument,
		variables: { Credentials: { ...initialLoginData, AD_Language: french.AD_Language } },
	});
	await mutate(valueObject)({
		mutation: ChangeAccessDocument,
		variables: {
			Access: {
				AD_Client_UU: valueObject.client!.UU,
				AD_Org_UU: valueObject.organization!.UU,
				AD_Role_UU: valueObject.role!.UU,
				M_Warehouse_UU: valueObject.warehouse!.UU,
			},
		},
	});

	valueObject.stepName = 'Run visit receipt report';
	valueObject.processUuid = visitReceiptReportUuid;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: visitReceiptReportUuid },
			ParameterName: 'billId',
			Parameter: valueObject.visit!.UU,
		},
	];
	await runReport(valueObject);

	const pdfContent = (await PdfData.extract(new Uint8Array(valueObject.report!))).text?.join('');
	expect(pdfContent).toBeTruthy();
	expect(pdfContent).toContain(valueObject.businessPartner!.Name.substring(0, 15));
});
