import { mutate } from '../../api';
import { Ad_ProcessRunDocument } from '../../__generated__/graphql';

const reportUuid = 'e79541fb-9b70-4a10-bfef-7401401b8c56';

test('can be run without any parameters', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	valueObject.stepName = 'Run process';
	expect(
		(
			await mutate(valueObject)({
				mutation: Ad_ProcessRunDocument,
				variables: {
					UUID: reportUuid,
				},
			})
		).data?.AD_ProcessRun,
	).toBe('');
});
