package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TreeNodeU2DataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TreeNodeU2;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_TreeNodeU2 - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TreeNodeU2Query extends POQuery<X_AD_TreeNodeU2> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TreeNodeU2.Table_Name;
	}

	public CompletableFuture<X_AD_TreeNodeU2> AD_TreeNodeU2(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_TreeNodeU2> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TreeNodeU2DataLoader.DATALOADER_AD_TreeNodeU2_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_TreeNodeU2> AD_TreeNodeU2Get(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
