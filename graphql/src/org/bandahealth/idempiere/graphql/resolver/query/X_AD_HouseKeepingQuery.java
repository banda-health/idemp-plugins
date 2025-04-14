package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_HouseKeepingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MHouseKeeping;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_HouseKeeping - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_HouseKeepingQuery extends POQuery<MHouseKeeping> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MHouseKeeping.Table_Name;
	}

	public CompletableFuture<MHouseKeeping> AD_HouseKeeping(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MHouseKeeping> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_HouseKeepingDataLoader.DATALOADER_AD_HouseKeeping_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MHouseKeeping> AD_HouseKeepingGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
