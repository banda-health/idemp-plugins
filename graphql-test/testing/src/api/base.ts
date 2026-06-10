import {
	ApolloClient,
	ApolloLink,
	DocumentNode,
	HttpLink,
	InMemoryCache,
	type OperationVariables,
	type TypedDocumentNode,
} from '@apollo/client/core';
import { map } from 'rxjs';
import { ValueObject } from '../models';
import { SignInMutationVariables } from '../__generated__/graphql';

export const IDEMPIERE_ENDPOINT = `${process.env.IDEMPIERE_ENDPOINT || 'http://idempiere:8080'}/graphql/`;

export const initialLoginData: SignInMutationVariables['Credentials'] = {
	Username: process.env.IDEMPIERE_USER || 'SuperUser',
	Password: process.env.IDEMPIERE_USER_PASSWORD || 'System',
	AD_Language: 'en_US',
} as const;

const httpLink = new HttpLink({
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
	return forward(operation).pipe(
		map((response) => {
			// If this was a login/change access request, we'll get a cookie back - set it
			if (valueObject && operation.getContext().response.headers.getSetCookie()[0]) {
				valueObject.sessionToken = operation.getContext().response.headers.getSetCookie()[0];
			}
			return response;
		}),
	);
});

export const graphqlClient = new ApolloClient({
	link: ApolloLink.from([authLink, httpLink]),
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

export type ResultWithData<TResult extends { data?: unknown }> = Omit<TResult, 'data'> & {
	data: NonNullable<TResult['data']>;
};

/** Apollo Client 4 types `data` as optional; tests assume a successful response includes it. */
export function withRequiredData<TResult extends { data?: unknown }>(result: TResult): ResultWithData<TResult> {
	if (result.data == null) {
		throw new Error('GraphQL request returned no data');
	}
	return result as ResultWithData<TResult>;
}

function formatApolloRequestError(
	message: string,
	stack: string | undefined,
	options: { query?: DocumentNode; mutation?: DocumentNode; variables?: object },
): Error {
	const query = options.query;
	const mutation = options.mutation;
	const variables = options.variables;
	return new Error(
		`ApolloError: ${message}${query ? '\nQuery: ' + (query.definitions[0] as { name?: { value?: string } })?.name?.value : ''}${
			mutation ? '\nMutation: ' + (mutation.definitions[0] as { name?: { value?: string } })?.name?.value : ''
		}${variables ? '\nVariables: ' + JSON.stringify(variables) : ''}${stack ? '\n\n' + stack : ''}`,
	);
}

/**
 * Apollo does a poor job showing where errors are thrown. This is an attempt to allow the stack trace
 * to be as close to the call as possible. We'll log a new error per request URL (meaning we can have
 * issues if we have tests running in parallel, which they aren't in the CI pipeline) and, if an error
 * was thrown by the request, we'll use the stack trace of the error for that call.
 */
export const query =
	(valueObject: ValueObject) =>
	async <TData, TVariables extends OperationVariables>(
		options: ApolloClient.QueryOptions<TData, TVariables> & {
			query: TypedDocumentNode<TData, TVariables>;
		},
	): Promise<ResultWithData<ApolloClient.QueryResult<TData>>> => {
		const originalError = new Error();
		try {
			return withRequiredData(
				await graphqlClient.query({
					...options,
					context: { ...(options.context ?? {}), valueObject },
				}),
			);
		} catch (error: unknown) {
			const err = error as Error;
			throw formatApolloRequestError(err.message, originalError.stack, options);
		}
	};
export const mutate =
	(valueObject: ValueObject) =>
	async <TData, TVariables extends OperationVariables>(
		options: ApolloClient.MutateOptions<TData, TVariables> & {
			mutation: TypedDocumentNode<TData, TVariables>;
		},
	): Promise<ResultWithData<ApolloClient.MutateResult<TData>>> => {
		const originalError = new Error();
		try {
			return withRequiredData(
				await graphqlClient.mutate({
					...options,
					context: { ...(options.context ?? {}), valueObject } as ApolloClient.MutateOptions<TData, TVariables>['context'],
				}),
			);
		} catch (error: unknown) {
			const err = error as Error;
			throw formatApolloRequestError(err.message, originalError.stack, options);
		}
	};
