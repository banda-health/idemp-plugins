import { Event, State } from 'jest-circus';
import { EnvironmentContext, JestEnvironmentConfig } from '@jest/environment';
import NodeEnvironment from 'jest-environment-node';
import axios, { AxiosError } from 'axios';

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
		if (event.name === 'test_fn_failure' && axios.isAxiosError(event.error)) {
			const error = event.error as AxiosError;
			const modifiedAxiosError = new Error(
				`${error.message}${error.response?.data ? ' - ' + error.response.data : ''}\nMethod: ${
					error.config?.method
				}\nURL: ${error.request?.path || error.config?.url}\nData: ${error.config?.data}${
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
