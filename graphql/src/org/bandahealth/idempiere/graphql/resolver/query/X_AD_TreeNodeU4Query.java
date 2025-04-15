package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeU4DataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TreeNodeU4;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeU4 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeU4Query extends POQuery<X_AD_TreeNodeU4> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU4.Table_Name;
	}

	public CompletableFuture<X_AD_TreeNodeU4> AD_TreeNodeU4(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_TreeNodeU4> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeU4DataLoader.DATALOADER_AD_TreeNodeU4_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_TreeNodeU4> AD_TreeNodeU4Get(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
