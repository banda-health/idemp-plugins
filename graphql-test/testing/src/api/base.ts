import { ApolloClient, ApolloLink, createHttpLink, from, InMemoryCache } from '@apollo/client/core';
import { ValueObject } from '../models';
import { SignInMutationVariables } from '../__generated__/graphql';

export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/graphql/`;

export const initialLoginData: SignInMutationVariables['Credentials'] = {
	Username: process.env.IDEMPIERE_USER || 'SuperUser',
	Password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	AD_Language: 'en_US',
} as const;

const httpLink = createHttpLink({
	uri: IDEMPIERE_ENDPOINT,
});

// Since cookies aren't handled in Node, we need to handle them ourselves
const authLink = new ApolloLink((operation, forward) => {
	const { valueObject } = operation.getContext() as { valueObject?: ValueObject };
	// If a session cookies is present, set it appropriately
	if (valueObject?.sessionToken) {
		operation.setContext(({ headers = {} }) => ({
			headers: {
				...headers,
				Cookie: valueObject.sessionToken,
			},
		}));
	}
	return forward(operation).map((response) => {
		// If this was a login/change access request, we'll get a cookie back - set it
		if (valueObject && operation.getContext().response.headers.getSetCookie()[0]) {
			valueObject.sessionToken = operation.getContext().response.headers.getSetCookie()[0];
		}
		return response;
	});
});

export const graphqlClient = new ApolloClient({
	link: from([authLink, httpLink]),
	cache: new InMemoryCache(),
	defaultOptions: {
		watchQuery: {
			fetchPolicy: 'no-cache',
		},
		query: {
			fetchPolicy: 'no-cache',
		},
	},
});

/**
 * Apollo does a poor job showing where errors are thrown. This is an attempt to allow the stack trace
 * to be as close to the call as possible. We'll log a new error per request URL (meaning we can have
 * issues if we have tests running in parallel, which they aren't in the CI pipeline) and, if an error
 * was thrown by the request, we'll use the stack trace of the error for that call.
 */
export const query =
	(valueObject: ValueObject): (typeof graphqlClient)['query'] =>
	async (...args) => {
		const originalError = new Error();
		const [options, ...rest] = args;
		try {
			return await graphqlClient.query({ ...options, context: { ...options.context, valueObject } }, ...rest);
		} catch (error: any) {
			error.stack = originalError.stack;
			error.methodParameters = args;
			throw error;
		}
	};
export const mutate =
	(valueObject: ValueObject): (typeof graphqlClient)['mutate'] =>
	async (...args) => {
		const [options, ...rest] = args;
		const originalError = new Error();
		try {
			return await graphqlClient.mutate({ ...options, context: { ...options.context, valueObject } as any }, ...rest);
		} catch (error: any) {
			error.stack = originalError.stack;
			error.methodParameters = args;
			throw error;
		}
	};
