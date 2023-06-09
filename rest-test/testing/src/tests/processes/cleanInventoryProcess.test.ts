import { processApi } from '../../api';

const reportUuid = 'e79541fb-9b70-4a10-bfef-7401401b8c56';

test('can be run without any parameters', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Run process';
	valueObject.processUuid = reportUuid;
	valueObject.processInformationParameters = undefined;
	await expect(processApi.run(valueObject)).resolves.toBe('');
});
