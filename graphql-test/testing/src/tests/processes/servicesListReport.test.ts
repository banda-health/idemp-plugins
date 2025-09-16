import { PdfData } from 'pdfdataextract';
import { Ad_ProcessGetDocument } from '../../__generated__/graphql';
import { query } from '../../api';
import { runReport } from '../../utils';

const reportUuid = 'fd5b6538-760c-4c8f-b943-115c1f3d2287';

test('services charged report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await query(valueObject)({
			query: Ad_ProcessGetDocument,
			variables: { Size: 1, Filter: JSON.stringify({ ad_process_uu: reportUuid }) },
		})
	).data.AD_ProcessGet.Results[0];
	expect(process.AD_Process_ParaList).toBeFalsy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.UU;
	await runReport(valueObject);

	expect((await PdfData.extract(new Uint8Array(valueObject.report!))).text?.join('')).toContain('Service List');
});
