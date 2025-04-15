package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobCategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_JobCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_JobCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_JobCategoryQuery extends POQuery<X_C_JobCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_JobCategory.Table_Name;
	}

	public CompletableFuture<X_C_JobCategory> C_JobCategory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_JobCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_JobCategoryDataLoader.DATALOADER_C_JobCategory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_JobCategory> C_JobCategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
