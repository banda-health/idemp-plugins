package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardContent_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardContentAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_DashboardContent_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardContent_AccessQuery extends POQuery<MDashboardContentAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardContentAccess.Table_Name;
	}

	public CompletableFuture<MDashboardContentAccess> PA_DashboardContent_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDashboardContentAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardContent_AccessDataLoader.DATALOADER_PA_DashboardContent_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDashboardContentAccess> PA_DashboardContent_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
