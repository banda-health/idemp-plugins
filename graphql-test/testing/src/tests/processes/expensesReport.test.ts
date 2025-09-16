import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';
import { query } from '../../api';
import { runReport, tomorrow, yesterday } from '../../utils';

const reportUuid = 'bbffd5e1-973a-4d17-9ddf-9ca78a4e140d';

test('expenses report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date')!;
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date')!;
	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

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

	const text = (await PdfData.extract(new Uint8Array(valueObject.report!))).text;
	expect(text).toBeTruthy();
	expect(text?.join('')).toContain('Expenses');
});
