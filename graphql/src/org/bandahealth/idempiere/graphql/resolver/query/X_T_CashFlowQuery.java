package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_CashFlowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_CashFlow;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_CashFlow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_T_CashFlowQuery extends POQuery<X_T_CashFlow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_CashFlow.Table_Name;
	}

	public CompletableFuture<X_T_CashFlow> T_CashFlow(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_CashFlow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_CashFlowDataLoader.DATALOADER_T_CashFlow_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_CashFlow> T_CashFlowGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
