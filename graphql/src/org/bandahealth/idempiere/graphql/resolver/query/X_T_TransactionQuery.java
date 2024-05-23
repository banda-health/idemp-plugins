package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_T_TransactionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_Transaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_TransactionQuery extends POQuery<X_T_Transaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_Transaction.Table_Name;
	}

	public CompletableFuture<X_T_Transaction> T_Transaction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_T_Transaction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_T_TransactionDataLoader.DATALOADER_T_Transaction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_T_Transaction> T_TransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
