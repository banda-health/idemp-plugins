import type { Config } from 'jest';

export default {
	preset: 'ts-jest/presets/default-esm',
	// @apollo/client/core's package.json "main" points at core.cjs; force the ESM entry for named imports
	moduleNameMapper: {
		'^@apollo/client/core$': '@apollo/client/core/index.js',
	},
	transform: {
		'^.+\\.m?tsx?$': [
			'ts-jest',
			{
				useESM: true,
				diagnostics: {
					ignoreCodes: ['TS151001'],
				},
			},
		],
	},
	clearMocks: true,
	globalSetup: './setup/setup.ts',
	globalTeardown: './setup/teardown.ts',
	rootDir: 'src',
	setupFilesAfterEnv: ['./setup/globalConfig.ts'],
	testEnvironment: './setup/graphql-environment.ts',
} satisfies Config;
