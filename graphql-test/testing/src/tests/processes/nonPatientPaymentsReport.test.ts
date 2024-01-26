import { PdfData } from 'pdfdataextract';
import { query } from '../../api';
import { runReport, tomorrow, yesterday } from '../../utils';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';

const reportUuid = '19464274-e2bc-4dbe-ad69-ae48b9f7778c';

test('report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { size: 1, filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.results[0];
	const beginDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Begin Date');
	const endDateParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'End Date');
	const modeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Mode');
	const insuranceTypeParameter = process.AD_Process_ParaList?.find((parameter) => parameter.Name === 'Insurance Type');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(modeParameter).toBeTruthy();
	expect(insuranceTypeParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UUID;
	valueObject.processInformationParameters = [
		{
			AD_Process: { UUID: process.UUID },
			ParameterName: beginDateParameter!.Name,
			Parameter: yesterday().toISOString(),
		},
		{
			AD_Process: { UUID: process.UUID },
			ParameterName: endDateParameter!.Name,
			Parameter: tomorrow().toISOString(),
		},
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
