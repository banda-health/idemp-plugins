package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertProcessorLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertProcessorLog;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AlertProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AlertProcessorLogQuery extends POQuery<MAlertProcessorLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertProcessorLog.Table_Name;
	}

	public CompletableFuture<MAlertProcessorLog> AD_AlertProcessorLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAlertProcessorLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AlertProcessorLogDataLoader.DATALOADER_AD_AlertProcessorLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAlertProcessorLog> AD_AlertProcessorLogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
