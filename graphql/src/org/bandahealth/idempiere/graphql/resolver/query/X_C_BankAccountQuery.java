package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankAccountDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankAccountQuery extends POQuery<MBankAccount_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankAccount_BH.Table_Name;
	}

	public CompletableFuture<MBankAccount_BH> C_BankAccount(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankAccount_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankAccountDataLoader.DATALOADER_C_BankAccount_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankAccount_BH> C_BankAccountGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
