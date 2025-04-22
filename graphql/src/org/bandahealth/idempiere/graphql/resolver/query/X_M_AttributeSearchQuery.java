package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSearchDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_AttributeSearch;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_AttributeSearch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_AttributeSearchQuery extends POQuery<X_M_AttributeSearch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_AttributeSearch.Table_Name;
	}

	public CompletableFuture<X_M_AttributeSearch> M_AttributeSearch(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_AttributeSearch> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_AttributeSearchDataLoader.DATALOADER_M_AttributeSearch_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_AttributeSearch> M_AttributeSearchGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
