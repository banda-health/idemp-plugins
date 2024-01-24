import {
	ApolloClient,
	ApolloLink,
	createHttpLink,
	defaultDataIdFromObject,
	from,
	InMemoryCache,
} from '@apollo/client/core';
import { ValueObject } from '../models';
import { SignInQueryVariables } from '../__generated__/graphql';

// export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/BHGO/services/rs/auth`;
export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/graphql/`;

export const initialLoginData: SignInQueryVariables['credentials'] = {
	username: process.env.IDEMPIERE_USER || 'SuperUser',
	password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	language: 'en_US',
} as const;

const httpLink = createHttpLink({
	uri: IDEMPIERE_ENDPOINT,
});

const authLink = new ApolloLink((operation, forward) => {
	const token = (operation.getContext() as { valueObject?: ValueObject }).valueObject?.sessionToken || '';
	operation.setContext({
		headers: {
			authorization: token ? `Bearer ${token}` : '',
		},
	});
	return forward(operation);
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
