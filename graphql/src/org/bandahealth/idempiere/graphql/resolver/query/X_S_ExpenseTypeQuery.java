package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ExpenseTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MExpenseType;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_ExpenseType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_ExpenseTypeQuery extends POQuery<MExpenseType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MExpenseType.Table_Name;
	}

	public CompletableFuture<MExpenseType> S_ExpenseType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MExpenseType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_ExpenseTypeDataLoader.DATALOADER_S_ExpenseType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MExpenseType> S_ExpenseTypeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
