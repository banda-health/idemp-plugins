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
