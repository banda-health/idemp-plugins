import { PdfData } from 'pdfdataextract';
import { query } from '../../api';
import { runReport, tomorrow, yesterday } from '../../utils';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';

const reportUuid = '7c29028a-8dd3-4025-a5af-87701748d81f';

test('diagnosis report is runnable', async () => {
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
	const codedDiagnosisParameter = process.AD_Process_ParaList?.find(
		(parameter) => parameter.Name === 'Coded Diagnosis',
	);
	const uncodedDiagnosisParameter = process.AD_Process_ParaList?.find(
		(parameter) => parameter.Name === 'Uncoded Diagnosis',
	);

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(codedDiagnosisParameter).toBeTruthy();
	expect(uncodedDiagnosisParameter).toBeTruthy();

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
