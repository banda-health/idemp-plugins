import xlsx from 'node-xlsx';
import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument, Ad_UserGetDocument, Bh_VisitProcessDocument, Bh_VisitSaveAndProcessWithOrdersDocument, Bh_Voided_ReasonGetDocument, C_BPartnerGetDocument, ReportOutput } from '../../__generated__/graphql';
import { mutate, query } from '../../api';
import { documentAction, documentBaseType, documentSubTypeSalesOrder } from '../../models';
import { RoleName } from '../../types/roleName';
import { createBusinessPartner, createInOutFromOrder, createInvoice, createOrder, createPayment, createProduct, createVisit, runReport, tomorrow, yesterday } from '../../utils';

const reportUuid = '20a623fb-e127-4c26-98d5-3604a6d100b2';

test('voided transactions report is runnable', async () => {
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

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().toISOString(),
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

test('voided visits without payments appear correctly on the report', async () => {

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


	valueObject.stepName = 'Complete visit';
	await mutate(valueObject)({
		mutation: Bh_VisitProcessDocument,
		variables: { UU: valueObject.visit!.UU, DocumentAction: documentAction.Complete },
	});

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
			})
		).data.C_BPartnerGet.Results[0].TotalOpenBalance,
	).toBe(100);

	
	valueObject.stepName = 'Void visit';
	const voidingReason = (await query(valueObject)({ query: Bh_Voided_ReasonGetDocument, variables: { Size: 1 } })).data
		.BH_Voided_ReasonGet.Results[0];
	await mutate(valueObject)({
		mutation: Bh_VisitSaveAndProcessWithOrdersDocument,
		variables: {
			BH_Visit: { UU: valueObject.visit!.UU, BH_Voided_Reason: { UU: voidingReason.UU } },
			C_Orders: [{ UU: valueObject.order!.UU, BH_Voided_Reason: { UU: voidingReason.UU } }],
			UU: valueObject.visit!.UU,
			DocumentAction: documentAction.Void,
		},
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];

	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run the report';
	valueObject.processUuid = process.UU;
	valueObject.reportType = ReportOutput.Xlsx;
	valueObject.processInformationParameters = [
		{ AD_Process: { UU: process.UU }, ParameterName: beginDateParameter!.Name, Parameter: yesterday().toISOString() },
		{ AD_Process: { UU: process.UU }, ParameterName: endDateParameter!.Name, Parameter: tomorrow().toISOString() },
	];
	await runReport(valueObject);

	const excelFile = xlsx.parse(valueObject.report!);
	const voidedVisitRow = excelFile[0].data.filter((row) =>
		(row[1]?.toString() as string | undefined)?.includes(valueObject.businessPartner!.Name.substring(0, 30)),
	)?.[0];
	expect(voidedVisitRow).toBeTruthy();
	expect(voidedVisitRow[2]).toBe(0);
	expect(voidedVisitRow[4]).toBe(voidingReason.Name);
});

test('visit voided by a different user appears correctly on the report', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login(RoleName.CashierRegistrationAdvanced);

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

	expect(
		(
			await query(valueObject)({
				query: C_BPartnerGetDocument,
				variables: { Filter: JSON.stringify({ c_bpartner_uu: valueObject.businessPartner!.UU }) },
			})
		).data.C_BPartnerGet.Results[0].TotalOpenBalance,
	).toBe(0);

	valueObject.stepName = 'Login as different user';
	await valueObject.login(RoleName.Admin);
	const adminUser = (
		await query(valueObject)({
			query: Ad_UserGetDocument,
			variables: { Filter: JSON.stringify({ ad_user_uu: valueObject.user?.UU }) },
		})
	).data.AD_UserGet.Results[0];
	const adminUserName = adminUser.Name;

	valueObject.stepName = 'Void visit';
	const voidingReason = (await query(valueObject)({ query: Bh_Voided_ReasonGetDocument, variables: { Size: 1 } })).data
		.BH_Voided_ReasonGet.Results[0];
	await mutate(valueObject)({
		mutation: Bh_VisitSaveAndProcessWithOrdersDocument,
		variables: {
			BH_Visit: { UU: valueObject.visit!.UU, BH_Voided_Reason: { UU: voidingReason.UU } },
			C_Orders: [{ UU: valueObject.order!.UU, BH_Voided_Reason: { UU: voidingReason.UU } }],
			UU: valueObject.visit!.UU,
			DocumentAction: documentAction.Void,
		},
	});

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];

	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run the report';
	valueObject.processUuid = process.UU;
	valueObject.reportType = ReportOutput.Xlsx;
	valueObject.processInformationParameters = [
		{ AD_Process: { UU: process.UU }, ParameterName: beginDateParameter!.Name, Parameter: yesterday().toISOString() },
		{ AD_Process: { UU: process.UU }, ParameterName: endDateParameter!.Name, Parameter: tomorrow().toISOString() },
	];
	await runReport(valueObject);

	const excelFile = xlsx.parse(valueObject.report!);
	const voidedVisitRow = excelFile[0].data.filter((row) =>
		(row[1]?.toString() as string | undefined)?.includes(valueObject.businessPartner!.Name.substring(0, 30)),
	)?.[0];
	expect(voidedVisitRow).toBeTruthy();
	expect(voidedVisitRow[3]).toBe(adminUserName);
	expect(voidedVisitRow[4]).toBe(voidingReason.Name);
});