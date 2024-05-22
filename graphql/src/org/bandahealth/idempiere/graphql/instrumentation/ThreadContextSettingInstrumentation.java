package org.bandahealth.idempiere.graphql.instrumentation;

import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.parameters.InstrumentationFieldFetchParameters;
import graphql.schema.DataFetcher;
import org.adempiere.util.ServerContext;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.compiere.util.Env;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * The sole purpose of this instrumentation is to ensure that the context is set correctly for the thread. The
 * context is set up during the
 * {@link org.bandahealth.idempiere.graphql.context.BandaGraphQLContextBuilder#build(HttpServletRequest, HttpServletResponse)}
 * phase and then is parsed and set for the thread here. This will be called before any Query or Mutation resolvers
 * are called and will run on the same thread. The Query or Mutation can pass the context via the
 * DataFetchingEnvironment variable to any alternate threads they spin up.
 */
public class ThreadContextSettingInstrumentation extends DataLoaderDispatcherInstrumentation {
	@Override
	public DataFetcher<?> instrumentDataFetcher(DataFetcher<?> dataFetcher,
			InstrumentationFieldFetchParameters parameters) {
		var parentFetcher = super.instrumentDataFetcher(dataFetcher, parameters);
		return (DataFetcher<Object>) environment -> {
			Properties idempiereContext = BandaGraphQLContext.getCtx(environment);
			ServerContext.setCurrentInstance(idempiereContext);
			Env.setCtx(idempiereContext);
			return parentFetcher.get(environment);
		};
	}
}
