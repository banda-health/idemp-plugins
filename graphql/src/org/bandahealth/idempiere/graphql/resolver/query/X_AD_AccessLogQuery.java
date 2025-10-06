package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AccessLogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAccessLog;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AccessLogQuery extends POQuery<MAccessLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAccessLog.Table_Name;
	}

	public CompletableFuture<MAccessLog> AD_AccessLog(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAccessLog> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AccessLogDataLoader.DATALOADER_AD_AccessLog_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAccessLog> AD_AccessLogGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
