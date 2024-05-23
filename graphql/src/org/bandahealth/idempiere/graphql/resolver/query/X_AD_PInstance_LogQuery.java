package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstance_LogDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PInstance_Log;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PInstance_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PInstance_LogQuery extends POQuery<X_AD_PInstance_Log> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PInstance_Log.Table_Name;
	}

	public CompletableFuture<X_AD_PInstance_Log> AD_PInstance_Log(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PInstance_Log> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PInstance_LogDataLoader.DATALOADER_AD_PInstance_Log_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PInstance_Log> AD_PInstance_LogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
