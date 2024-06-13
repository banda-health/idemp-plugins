package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindow_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInfoWindowAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_InfoWindow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_InfoWindow_AccessQuery extends POQuery<MInfoWindowAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInfoWindowAccess.Table_Name;
	}

	public CompletableFuture<MInfoWindowAccess> AD_InfoWindow_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInfoWindowAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoWindow_AccessDataLoader.DATALOADER_AD_InfoWindow_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInfoWindowAccess> AD_InfoWindow_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
