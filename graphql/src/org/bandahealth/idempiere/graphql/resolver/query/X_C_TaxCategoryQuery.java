package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaxCategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaxCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_TaxCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_TaxCategoryQuery extends POQuery<MTaxCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaxCategory.Table_Name;
	}

	public CompletableFuture<MTaxCategory> C_TaxCategory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaxCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaxCategoryDataLoader.DATALOADER_C_TaxCategory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaxCategory> C_TaxCategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
