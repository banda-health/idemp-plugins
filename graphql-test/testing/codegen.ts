import { CodegenConfig } from '@graphql-codegen/cli';

const config: CodegenConfig = {
	schema: `${process.env.IDEMPIERE_ENDPOINT || 'http://localhost:9877'}/graphql/`,
	documents: ['src/**/*.gql'],
	generates: {
		'./src/__generated__/': {
			preset: 'client',
			presetConfig: {
				fragmentMasking: false,
			},
			config: {
				scalars: {
					BigDecimal: { input: 'number', output: 'number' },
					Binary: { input: 'string', output: 'string' },
					Date: { input: 'string', output: 'string' },
					DateTime: { input: 'number', output: 'number' },
					File: { input: 'string', output: 'string' },
					Object: { input: 'any', output: 'any' },
				},
			},
		},
	},
};

export default config;
