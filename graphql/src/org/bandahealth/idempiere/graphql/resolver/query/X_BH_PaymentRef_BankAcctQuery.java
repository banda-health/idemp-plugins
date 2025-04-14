package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHPaymentRefBankAccount;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_PaymentRef_BankAcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_PaymentRef_BankAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_PaymentRef_BankAcctQuery extends POQuery<MBHPaymentRefBankAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHPaymentRefBankAccount.Table_Name;
	}

	public CompletableFuture<MBHPaymentRefBankAccount> BH_PaymentRef_BankAcct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHPaymentRefBankAccount> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_PaymentRef_BankAcctDataLoader.DATALOADER_BH_PaymentRef_BankAcct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHPaymentRefBankAccount> BH_PaymentRef_BankAcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
