import { PdfData } from 'pdfdataextract';
import { processApi } from '../../api';
import { ProcessInfoParameter } from '../../types/org.bandahealth.idempiere.rest';
import { runReport, tomorrow, yesterday } from '../../utils';

const reportUuid = 'f777f042-3907-4293-94c4-49fe6eb58780';

test('income and expense report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
	).results[0];
	const beginDateParameter = process.parameters.find((parameter) => parameter.name === 'Begin Date');
	const endDateParameter = process.parameters.find((parameter) => parameter.name === 'End Date');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.uuid;
	valueObject.processInformationParameters = [
		{ processParameterUuid: beginDateParameter!.uuid, parameter: yesterday().toISOString() } as ProcessInfoParameter,
		{ processParameterUuid: endDateParameter!.uuid, parameter: tomorrow().toISOString() } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
