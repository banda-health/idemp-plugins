package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_InfoWindowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInfoWindow;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_InfoWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_InfoWindowQuery extends POQuery<MInfoWindow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInfoWindow.Table_Name;
	}

	public CompletableFuture<MInfoWindow> AD_InfoWindow(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInfoWindow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_InfoWindowDataLoader.DATALOADER_AD_InfoWindow_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInfoWindow> AD_InfoWindowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
