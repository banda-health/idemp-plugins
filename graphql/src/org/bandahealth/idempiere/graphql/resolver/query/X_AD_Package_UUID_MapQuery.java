package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Package_UUID_MapDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Package_UUID_Map;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Package_UUID_Map - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Package_UUID_MapQuery extends POQuery<X_AD_Package_UUID_Map> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Package_UUID_Map.Table_Name;
	}

	public CompletableFuture<X_AD_Package_UUID_Map> AD_Package_UUID_Map(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Package_UUID_Map> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Package_UUID_MapDataLoader.DATALOADER_AD_Package_UUID_Map_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Package_UUID_Map> AD_Package_UUID_MapGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
