package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_ProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MIMPProcessorLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for IMP_ProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorLogQuery extends POQuery<MIMPProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MIMPProcessorLog.Table_Name;
	}

	public CompletableFuture<MIMPProcessorLog> IMP_ProcessorLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MIMPProcessorLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_IMP_ProcessorLogDataLoader.DATALOADER_IMP_ProcessorLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MIMPProcessorLog> IMP_ProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
