import { beforeAll, beforeEach, expect } from 'vitest';
import { readFile } from 'fs/promises';
import { tmpdir } from 'os';
import { join } from 'path';
import { ValueObject } from '../models';
import { toCamelCase } from '../utils';

const workingDirectory = join(tmpdir(), 'rest-global-setup');

// Since we're dealing with APIs and processing documents, calls may take a while
// depending on the DB. So, increase the test timeout to handle it (also set in vitest.config.ts).
beforeAll(async () => {
	// get the admin login information
	const stringifiedLoginInfo = await readFile(join(workingDirectory, 'loginInfo'), 'utf8');
	if (!stringifiedLoginInfo) {
		throw new Error('login info not found');
	}

	// Initialize the value object with the base login info of an Admin
	globalThis.__VALUE_OBJECT__ = new ValueObject(JSON.parse(stringifiedLoginInfo));
	globalThis.__VALUE_OBJECT__.scenarioName = toCamelCase(expect.getState().testPath + ' Prepare');
});

// Set the scenario name for each test since it's used when creating entities
beforeEach(async () => {
	// get the admin login information
	const stringifiedLoginInfo = await readFile(join(workingDirectory, 'loginInfo'), 'utf8');
	if (!stringifiedLoginInfo) {
		throw new Error('login info not found');
	}

	// Initialize the value object with the base login info of an Admin
	globalThis.__VALUE_OBJECT__ = new ValueObject(JSON.parse(stringifiedLoginInfo));
	globalThis.__VALUE_OBJECT__.scenarioName = toCamelCase(expect.getState().currentTestName || 'No test name');
});
