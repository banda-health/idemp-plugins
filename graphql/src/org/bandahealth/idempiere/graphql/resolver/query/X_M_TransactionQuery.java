package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_TransactionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_TransactionQuery extends POQuery<MTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTransaction.Table_Name;
	}

	public CompletableFuture<MTransaction> M_Transaction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTransaction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_TransactionDataLoader.DATALOADER_M_Transaction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTransaction> M_TransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
