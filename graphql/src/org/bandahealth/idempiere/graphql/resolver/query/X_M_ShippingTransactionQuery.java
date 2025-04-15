package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingTransactionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShippingTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShippingTransactionQuery extends POQuery<MShippingTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingTransaction.Table_Name;
	}

	public CompletableFuture<MShippingTransaction> M_ShippingTransaction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShippingTransaction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShippingTransactionDataLoader.DATALOADER_M_ShippingTransaction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShippingTransaction> M_ShippingTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
