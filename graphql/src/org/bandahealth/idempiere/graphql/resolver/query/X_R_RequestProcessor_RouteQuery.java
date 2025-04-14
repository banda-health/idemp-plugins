package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestProcessor_RouteDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestProcessorRoute;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestProcessor_Route - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_RequestProcessor_RouteQuery extends POQuery<MRequestProcessorRoute> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestProcessorRoute.Table_Name;
	}

	public CompletableFuture<MRequestProcessorRoute> R_RequestProcessor_Route(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestProcessorRoute> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestProcessor_RouteDataLoader.DATALOADER_R_RequestProcessor_Route_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestProcessorRoute> R_RequestProcessor_RouteGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
