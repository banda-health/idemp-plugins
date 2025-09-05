package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_TimeExpenseLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTimeExpenseLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_TimeExpenseLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_S_TimeExpenseLineQuery extends POQuery<MTimeExpenseLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTimeExpenseLine.Table_Name;
	}

	public CompletableFuture<MTimeExpenseLine> S_TimeExpenseLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTimeExpenseLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_TimeExpenseLineDataLoader.DATALOADER_S_TimeExpenseLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTimeExpenseLine> S_TimeExpenseLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
