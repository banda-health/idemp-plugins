import { PdfData } from 'pdfdataextract';
import { processApi } from '../../api';
import { ProcessInfoParameter } from '../../types/org.bandahealth.idempiere.rest';
import { runReport, tomorrow, yesterday } from '../../utils';

const reportUuid = '226cdf47-9cde-43e8-b7ef-87b28d7ef2e2';

test('report is runnable', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const process = (
		await processApi.get(valueObject, undefined, undefined, undefined, JSON.stringify({ ad_process_uu: reportUuid }))
	).results[0];
	const beginDateParameter = process.parameters.find((parameter) => parameter.name === 'Begin Date');
	const endDateParameter = process.parameters.find((parameter) => parameter.name === 'End Date');
	const patientTypeParameter = process.parameters.find((parameter) => parameter.name === 'Patient Type');
	const paymentModeParameter = process.parameters.find((parameter) => parameter.name === 'Payment Mode');

	expect(beginDateParameter).toBeTruthy();
	expect(endDateParameter).toBeTruthy();
	expect(patientTypeParameter).toBeTruthy();
	expect(paymentModeParameter).toBeTruthy();

	valueObject.stepName = 'Run report';
	valueObject.processUuid = process.uuid;
	valueObject.processInformationParameters = [
		{ processParameterUuid: beginDateParameter!.uuid, parameter: yesterday().toISOString() } as ProcessInfoParameter,
		{ processParameterUuid: endDateParameter!.uuid, parameter: tomorrow().toISOString() } as ProcessInfoParameter,
	];
	await runReport(valueObject);

	expect((await PdfData.extract(valueObject.report!)).text).toBeTruthy();
});
