import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';
import { query } from '../../api';
import { runReport } from '../../utils';

const reportUuid = 'a1b2c3d4-e5f6-7890-abcd-ef1234567890';

test('in-patient report with date range parameters works correctly', async () => {
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

	// Test with a specific date range
	const startDate = new Date();
	startDate.setDate(startDate.getDate() - 7); // 7 days ago
	const endDate = new Date();
	endDate.setDate(endDate.getDate() + 7); // 7 days from now

	valueObject.stepName = 'Run report with custom date range';
	valueObject.processUuid = process.UU;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UU: process.UU },
			ParameterName: beginDateParameter!.Name,
			Parameter: startDate.toISOString(),
		},
		{
			AD_Process: { UU: process.UU },
			ParameterName: endDateParameter!.Name,
			Parameter: endDate.toISOString(),
		},
	];
	await runReport(valueObject);

	const text = (await PdfData.extract(new Uint8Array(valueObject.report!))).text;
	expect(text).toBeTruthy();
	expect(text?.join('')).toContain('In-Patient Report');
});
