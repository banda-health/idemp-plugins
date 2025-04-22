package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TimeExpenseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTimeExpense;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_TimeExpense - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TimeExpenseQuery extends POQuery<MTimeExpense> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTimeExpense.Table_Name;
	}

	public CompletableFuture<MTimeExpense> S_TimeExpense(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTimeExpense> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_TimeExpenseDataLoader.DATALOADER_S_TimeExpense_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTimeExpense> S_TimeExpenseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
