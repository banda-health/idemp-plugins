import { initialLoginData } from '../api';

const idempiereBase = (process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080').replace(/\/graphql\/?$/, '');
const GRAPHQL_PROXY_ENDPOINT = `${idempiereBase}/graphql/proxy/`;

type ProxyResponse = {
	data?: {
		ok?: boolean;
		echoedUserId?: string;
		echoedUserName?: string;
	};
	extensions?: {
		receivedHeaders?: Record<string, string | null>;
	};
	errors?: Array<{ message?: string }>;
};

async function postToGraphQLProxy(valueObject: { sessionToken?: string }, body: object) {
	return fetch(GRAPHQL_PROXY_ENDPOINT, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
			...(valueObject.sessionToken ? { Cookie: valueObject.sessionToken } : {}),
		},
		body: JSON.stringify(body),
	});
}

test('authenticated graphql proxy forwards to upstream and returns ok', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const response = await postToGraphQLProxy(valueObject, {
		query: 'query ProxyOk { ok }',
	});

	expect(response.status).toBe(200);
	expect(response.headers.get('x-upstream-debug-user-id')).toBeNull();

	const payload = (await response.json()) as ProxyResponse;
	expect(payload.data?.ok).toBe(true);
	expect(payload.extensions).toBeUndefined();
});

test('graphql proxy rejects unauthenticated requests', async () => {
	const response = await postToGraphQLProxy({}, {
		query: 'query ProxyOk { ok }',
	});

	expect(response.status).toBe(401);
	const payload = (await response.json()) as ProxyResponse;
	expect(payload.errors?.[0]?.message).toBe('Unauthorized');
});

test('graphql proxy forwards only user id and user name upstream', async () => {
	const valueObject = globalThis.__VALUE_OBJECT__;
	await valueObject.login();

	const response = await postToGraphQLProxy(valueObject, {
		query: 'query ProxyHeaders { ok }',
	});

	expect(response.status).toBe(200);
	expect(response.headers.get('x-upstream-debug-user-id')).toBeNull();

	const payload = (await response.json()) as ProxyResponse;
	expect(payload.extensions).toBeUndefined();
	expect(payload.data?.echoedUserId).toBeTruthy();
	expect(payload.data?.echoedUserName).toBe(initialLoginData.Username);
});
