package org.bandahealth.idempiere.graphql;

import graphql.analysis.MaxQueryDepthInstrumentation;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentationOptions;
import graphql.execution.preparsed.PreparsedDocumentEntry;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import graphql.kickstart.execution.GraphQLObjectMapper;
import graphql.kickstart.execution.GraphQLQueryInvoker;
import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.servlet.input.GraphQLInvocationInputFactory;
import graphql.kickstart.tools.SchemaParser;
import graphql.kickstart.tools.SchemaParserBuilder;
import graphql.schema.GraphQLSchema;
import org.bandahealth.idempiere.graphql.cache.BandaCache;
import org.bandahealth.idempiere.graphql.cache.CacheFactory;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContextBuilder;
import org.bandahealth.idempiere.graphql.directive.BandaDirectiveComposer;
import org.bandahealth.idempiere.graphql.error.ErrorHandler;
import org.bandahealth.idempiere.graphql.instrumentation.LoggingInstrumentation;
import org.bandahealth.idempiere.graphql.resolver.model.BandaResolverComposer;
import org.bandahealth.idempiere.graphql.resolver.mutation.BandaMutationComposer;
import org.bandahealth.idempiere.graphql.resolver.query.BandaQueryComposer;
import org.bandahealth.idempiere.graphql.scalar.BandaScalarComposer;
import org.compiere.util.CLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * The endpoint that contains all the GraphQL setup and configuration. All GraphQL calls are routed through this class
 */
public class GraphQLEndpoint extends GraphQLHttpServlet {
	/**
	 * This is the singleton instance for the cache factory so any classes that need the cache can access a single,
	 * shared instance
	 */
	private static final CacheFactory cacheFactory = new CacheFactory();
	private final CLogger logger = CLogger.getCLogger(GraphQLEndpoint.class);

	/**
	 * Get a cache specific to the class requested
	 *
	 * @param clazz The class to fetch a cache for
	 * @return The cache specific to the class
	 */
	public static BandaCache<Object, Object> getCache(Class<?> clazz) {
		return cacheFactory.getCache(clazz);
	}

	/**
	 * The method called when the GraphQL endpoint is initialized
	 *
	 * @return The configuration for GraphQL
	 */
	@Override
	protected GraphQLConfiguration getConfiguration() {
		logger.fine("Getting GraphQL endpoint config");
		return GraphQLConfiguration.with(createContext()).with(createObjectMapper()).with(getInvoker()).build();
	}

	/**
	 * Allows for the invoked queries to return timing information for debugging and performance-tuning.
	 *
	 * @return The configured query invoker
	 */
	private GraphQLQueryInvoker getInvoker() {
		DataLoaderDispatcherInstrumentationOptions options = DataLoaderDispatcherInstrumentationOptions
				.newOptions().includeStatistics(true);

		// Set up the cache so, if a GraphQL query has been passed in before, it doesn't have to be parsed
		// again before heading to the DB (note, this cache doesn't store DB query results)
		PreparsedDocumentProvider preparsedCache = (executionInput, computeFunction) -> {
			BandaCache<Object, Object> cache = GraphQLEndpoint.getCache(PreparsedDocumentEntry.class);
			PreparsedDocumentEntry preparsedDocumentEntry = (PreparsedDocumentEntry) cache.get(executionInput.getQuery());
			if (preparsedDocumentEntry == null) {
				preparsedDocumentEntry = computeFunction.apply(executionInput);
				cache.set(executionInput.getQuery(), preparsedDocumentEntry);
			}
			return preparsedDocumentEntry;
		};

		Instrumentation dispatcherInstrumentation
				= new DataLoaderDispatcherInstrumentation(options);
		List<Instrumentation> instrumentationList = new ArrayList<>();
		instrumentationList.add(new MaxQueryDepthInstrumentation(13));
		instrumentationList.add(new LoggingInstrumentation());
		// TODO: Uncomment for localized instrumentation figures
//		instrumentationList.add(new TracingInstrumentation());
//		instrumentationList.add(dispatcherInstrumentation);

		return GraphQLQueryInvoker.newBuilder()
				.withPreparsedDocumentProvider(preparsedCache)
				.withInstrumentation(new ChainedInstrumentation(instrumentationList))
				.build();
	}

	/**
	 * Generates the schema from the appropriate SDL files, then adds the appropriate resolvers, scalars, and directives
	 *
	 * @return The schema to use in this GraphQL plugin
	 */
	private GraphQLSchema createSchema() {
		SchemaParserBuilder builder = SchemaParser.newParser();
		BandaSchemaFileComposer.addAll(builder);
		BandaQueryComposer.addAll(builder);
		BandaMutationComposer.addAll(builder);
		BandaResolverComposer.addAll(builder);
		BandaDirectiveComposer.addAll(builder);
		BandaScalarComposer.addAll(builder);
		return builder
				.build()
				.makeExecutableSchema();
	}

	/**
	 * Generates the right object and ensures the custom context builder is used
	 *
	 * @return The object to use in the GraphQL configuration
	 */
	private GraphQLInvocationInputFactory createContext() {
		return GraphQLInvocationInputFactory.newBuilder(createSchema())
				.withGraphQLContextBuilder(BandaGraphQLContextBuilder::new)
				.build();
	}

	/**
	 * Ensure we provide some error handling of our own
	 *
	 * @return The object mapper to use in the GraphQL configuration
	 */
	private GraphQLObjectMapper createObjectMapper() {
		return GraphQLObjectMapper.newBuilder()
				.withGraphQLErrorHandler(new ErrorHandler())
				.build();
	}
}
