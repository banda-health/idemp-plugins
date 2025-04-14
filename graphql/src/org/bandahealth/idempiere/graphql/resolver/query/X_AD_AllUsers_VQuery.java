package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AllUsers_VDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_AllUsers_V;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AllUsers_V - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AllUsers_VQuery extends POQuery<X_AD_AllUsers_V> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_AllUsers_V.Table_Name;
	}

	public CompletableFuture<X_AD_AllUsers_V> AD_AllUsers_V(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_AllUsers_V> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AllUsers_VDataLoader.DATALOADER_AD_AllUsers_V_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_AllUsers_V> AD_AllUsers_VGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
