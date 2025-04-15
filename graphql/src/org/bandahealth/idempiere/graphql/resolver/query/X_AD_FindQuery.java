package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FindDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Find;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Find - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_FindQuery extends POQuery<X_AD_Find> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Find.Table_Name;
	}

	public CompletableFuture<X_AD_Find> AD_Find(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Find> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_FindDataLoader.DATALOADER_AD_Find_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Find> AD_FindGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
