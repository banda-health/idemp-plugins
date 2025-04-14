package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBPBankAccount;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BP_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BP_BankAccountQuery extends POQuery<MBPBankAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBPBankAccount.Table_Name;
	}

	public CompletableFuture<MBPBankAccount> C_BP_BankAccount(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBPBankAccount> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BP_BankAccountDataLoader.DATALOADER_C_BP_BankAccount_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBPBankAccount> C_BP_BankAccountGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
