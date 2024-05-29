package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_GL_BudgetControlDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_GL_BudgetControl;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for GL_BudgetControl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_GL_BudgetControlQuery extends POQuery<X_GL_BudgetControl> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_GL_BudgetControl.Table_Name;
	}

	public CompletableFuture<X_GL_BudgetControl> GL_BudgetControl(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_GL_BudgetControl> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_GL_BudgetControlDataLoader.DATALOADER_GL_BudgetControl_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_GL_BudgetControl> GL_BudgetControlGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
