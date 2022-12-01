import { EnvironmentContext, JestEnvironmentConfig } from '@jest/environment';
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
}
