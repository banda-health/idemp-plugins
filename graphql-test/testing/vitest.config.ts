import { defineConfig } from 'vitest/config';

export default defineConfig({
	test: {
		globals: true,
		environment: 'node',
		include: ['src/tests/**/*.test.ts'],
		globalSetup: ['src/setup/setup.ts'],
		setupFiles: ['src/setup/globalConfig.ts'],
		testTimeout: 30_000,
		clearMocks: true,
		// Tests share a live DB and global login state — one file at a time.
		// threads avoids fork worker crashes on loaded CI agents (report tests die with forks).
		pool: 'threads',
		isolate: true,
		maxWorkers: 1,
		fileParallelism: false,
		teardownTimeout: 60_000,
	},
	resolve: {
		alias: {
			// package.json "main" points at core.cjs; use the ESM entry for named imports
			'@apollo/client/core': '@apollo/client/core/index.js',
		},
	},
});
