package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Reval_IndexDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Reval_Index;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Reval_Index - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Reval_IndexQuery extends POQuery<X_A_Asset_Reval_Index> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_Index.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Reval_Index> A_Asset_Reval_Index(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Reval_Index> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Reval_IndexDataLoader.DATALOADER_A_Asset_Reval_Index_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Reval_Index> A_Asset_Reval_IndexGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
