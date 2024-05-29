package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SalesRegionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSalesRegion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_SalesRegion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_SalesRegionQuery extends POQuery<MSalesRegion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSalesRegion.Table_Name;
	}

	public CompletableFuture<MSalesRegion> C_SalesRegion(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSalesRegion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_SalesRegionDataLoader.DATALOADER_C_SalesRegion_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSalesRegion> C_SalesRegionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
