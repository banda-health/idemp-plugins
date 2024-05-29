package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGLCategory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_CategoryQuery extends POQuery<MGLCategory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGLCategory.Table_Name;
	}

	public CompletableFuture<MGLCategory> GL_Category(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MGLCategory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_CategoryDataLoader.DATALOADER_GL_Category_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MGLCategory> GL_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
