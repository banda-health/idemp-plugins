package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_StatusCategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MStatusCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_StatusCategory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_StatusCategoryQuery extends POQuery<MStatusCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MStatusCategory.Table_Name;
	}

	public CompletableFuture<MStatusCategory> R_StatusCategory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MStatusCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_StatusCategoryDataLoader.DATALOADER_R_StatusCategory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MStatusCategory> R_StatusCategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
