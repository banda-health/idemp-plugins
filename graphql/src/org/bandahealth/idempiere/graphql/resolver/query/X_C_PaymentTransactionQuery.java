package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_PaymentTransactionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentTransaction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_PaymentTransactionQuery extends POQuery<MPaymentTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentTransaction.Table_Name;
	}

	public CompletableFuture<MPaymentTransaction> C_PaymentTransaction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPaymentTransaction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_PaymentTransactionDataLoader.DATALOADER_C_PaymentTransaction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPaymentTransaction> C_PaymentTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
