import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';
import { query } from '../../api';
import { runReport } from '../../utils';

const reportUuid = 'feaa97fb-b424-4dce-8790-035ba80ca023';

test('patients report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	expect(
		process.AD_Process_ParaList?.find((processParameter) => processParameter.Name === 'Patient Tags'),
	).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	await runReport(valueObject);

	const text = (await PdfData.extract(new Uint8Array(valueObject.report!))).text;
	expect(text).toBeTruthy();
	expect(text?.join('')).toContain('Patient Report');
});
