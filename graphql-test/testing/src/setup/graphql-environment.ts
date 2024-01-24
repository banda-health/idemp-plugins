import { ApolloError, DocumentNode } from '@apollo/client/core';
import { EnvironmentContext, JestEnvironmentConfig } from '@jest/environment';
import { Event, State } from 'jest-circus';
import NodeEnvironment from 'jest-environment-node';

export default class IDempRestEnvironment extends NodeEnvironment {
	constructor(config: JestEnvironmentConfig, context: EnvironmentContext) {
		super(config, context);
	}

	async setup() {
		await super.setup();
	}

	async teardown() {
		await super.teardown();
	}

	getVmContext() {
		return super.getVmContext();
	}

	async handleTestEvent(event: Event, state: State) {
		// We want to handle Axios errors to provide more useful information for the user
		if (event.name === 'test_fn_failure' && event.error.methodParameters) {
			const error = event.error as ApolloError & { methodParameters?: any[] };
			const query: DocumentNode | undefined = error.methodParameters?.[0].query;
			const mutation: DocumentNode | undefined = error.methodParameters?.[0].mutation;
			const variables: object | undefined = error.methodParameters?.[0].variables;
			const modifiedAxiosError = new Error(
				`ApolloError: ${error.message}${query ? '\nQuery: ' + (query?.definitions[0] as any)?.name?.value : ''}${
					mutation ? '\nMutation: ' + (mutation?.definitions[0] as any)?.name?.value : ''
				}${variables ? '\nVariables: ' + JSON.stringify(variables) : ''}${
					error.stack ? '\n\n' + error.stack : undefined
				}`,
			);
			// Replace the last error in the array with ours
			event.test.errors.pop();
			event.test.errors.push(modifiedAxiosError);
			event.test.asyncError = modifiedAxiosError;
		}
	}
}
