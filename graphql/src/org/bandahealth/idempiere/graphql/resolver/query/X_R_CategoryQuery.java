package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_CategoryQuery extends POQuery<MRequestCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestCategory.Table_Name;
	}

	public CompletableFuture<MRequestCategory> R_Category(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_CategoryDataLoader.DATALOADER_R_Category_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestCategory> R_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
