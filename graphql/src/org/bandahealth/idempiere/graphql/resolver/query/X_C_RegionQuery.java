package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_RegionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRegion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Region - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RegionQuery extends POQuery<MRegion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRegion.Table_Name;
	}

	public CompletableFuture<MRegion> C_Region(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRegion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_RegionDataLoader.DATALOADER_C_Region_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRegion> C_RegionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
