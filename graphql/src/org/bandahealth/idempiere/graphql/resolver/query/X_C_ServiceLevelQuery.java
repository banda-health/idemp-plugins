package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ServiceLevelDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_ServiceLevel;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ServiceLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ServiceLevelQuery extends POQuery<X_C_ServiceLevel> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_ServiceLevel.Table_Name;
	}

	public CompletableFuture<X_C_ServiceLevel> C_ServiceLevel(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_ServiceLevel> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ServiceLevelDataLoader.DATALOADER_C_ServiceLevel_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_ServiceLevel> C_ServiceLevelGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
