package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_Budget;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_Budget - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_GL_BudgetQuery extends POQuery<X_GL_Budget> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_Budget.Table_Name;
	}

	public CompletableFuture<X_GL_Budget> GL_Budget(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_GL_Budget> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_BudgetDataLoader.DATALOADER_GL_Budget_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_GL_Budget> GL_BudgetGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
