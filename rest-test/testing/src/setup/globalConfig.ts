import axios from 'axios';
import { readFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { ValueObject } from '../models';
import { AuthResponse, Client } from '../types/org.bandahealth.idempiere.rest';
import { toCamelCase } from '../utils';

const workingDirectory = join(tmpdir(), 'idemp-rest-global-setup');

// Since we're dealing with APIs and processing documents, calls may take a while
// depending on the DB. So, increase the test timeout to handle it
jest.setTimeout(30000); // 30 seconds

// Set the scenario name for each test since it's used when creating entities
beforeEach(async () => {
	// get the admin login information
	const stringifiedLoginInfo = await readFile(join(workingDirectory, 'loginInfo'), 'utf8');
	if (!stringifiedLoginInfo) {
		throw new Error('login info not found');
	}

	// Initialize the value object with the base login info of an Admin
	globalThis.__VALUE_OBJECT__ = new ValueObject(JSON.parse(stringifiedLoginInfo) as AuthResponse & { client: Client });
	globalThis.__VALUE_OBJECT__.scenarioName = toCamelCase(expect.getState().currentTestName || 'No test name');
});

axios.defaults.headers.common['Content-Type'] = 'application/json';
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.headers.put['Content-Type'] = 'application/json';
