import { EnvironmentContext, JestEnvironmentConfig } from '@jest/environment';
import { readFile } from 'fs/promises';
import NodeEnvironment from 'jest-environment-node';
import { tmpdir } from 'os';
import { join } from 'path';
import { ValueObject } from '../models';
import { AuthResponse, Client } from '../types/org.bandahealth.idempiere.rest';

const workingDirectory = join(tmpdir(), 'idemp-rest-global-setup');

export default class IDempRestEnvironment extends NodeEnvironment {
	constructor(config: JestEnvironmentConfig, context: EnvironmentContext) {
		super(config, context);
	}

	async setup() {
		await super.setup();
		// get the wsEndpoint
		const stringifiedLoginInfo = await readFile(join(workingDirectory, 'loginInfo'), 'utf8');
		if (!stringifiedLoginInfo) {
			throw new Error('login info not found');
		}

		// connect to puppeteer
		this.global.__VALUE_OBJECT__ = new ValueObject(
			JSON.parse(stringifiedLoginInfo) as AuthResponse & { client: Client },
		);
	}

	async teardown() {
		await super.teardown();
	}

	getVmContext() {
		return super.getVmContext();
	}
}
