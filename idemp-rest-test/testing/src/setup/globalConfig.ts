import { toCamelCase } from '../utils';

// Since we're dealing with APIs and processing documents, calls may take a while
// depending on the DB. So, increase the test timeout to handle it
jest.setTimeout(30000); // 30 seconds

// Set the scenario name for each test since it's used when creating entities
beforeEach(() => {
	globalThis.__VALUE_OBJECT__.scenarioName = toCamelCase(expect.getState().currentTestName);
});
