import express from 'express';
import { readFileSync } from 'fs';

const app = express();
const port = process.env.PORT;

const forbiddenIdentityHeaders = [
	'x-ad-client-id',
	'x-ad-role-id',
	'x-ad-org-id',
	'x-ad-session-id',
	'x-ad-language',
	'x-login-name',
];

app.post('/graphql-proxy', express.json({ type: '*/*' }), (request, response) => {
	const userId = request.headers['x-ad-user-id'];
	const userName = request.headers['x-ad-user-name'];

	if (forbiddenIdentityHeaders.some((headerName) => request.headers[headerName])) {
		response.status(400).json({ errors: [{ message: 'unexpected identity header' }] });
		return;
	}

	if (!userId || !userName) {
		response.status(400).json({ errors: [{ message: 'missing identity header' }] });
		return;
	}

	response
		.set('X-Upstream-Debug-User-Id', String(userId))
		.status(200)
		.json({
			data: {
				ok: true,
				echoedUserId: String(userId),
				echoedUserName: String(userName),
			},
			extensions: {
				receivedHeaders: {
					'x-ad-user-id': userId,
					'x-ad-user-name': userName,
				},
			},
		});
});

app.get(
	'/ocl/orgs/:org/sources/:source/concepts/:concept?(/versions)?',
	(request, response) => {
		const concepts = JSON.parse(
			readFileSync(
				`./files/ocl/${request.params.source}-concepts${
					request.params.concept ? '-' + request.params.concept : ''
				}.json`
			).toString()
		);
		response.append('num_found', concepts?.length || 1).json(concepts);
	}
);

app.listen(port, () => {
	console.log(`External mocks listening on port ${port}`);
});
