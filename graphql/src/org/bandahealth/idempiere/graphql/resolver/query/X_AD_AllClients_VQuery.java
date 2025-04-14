package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllClients_VDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_AllClients_V;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AllClients_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AllClients_VQuery extends POQuery<X_AD_AllClients_V> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_AllClients_V.Table_Name;
	}

	public CompletableFuture<X_AD_AllClients_V> AD_AllClients_V(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_AllClients_V> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AllClients_VDataLoader.DATALOADER_AD_AllClients_V_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_AllClients_V> AD_AllClients_VGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
