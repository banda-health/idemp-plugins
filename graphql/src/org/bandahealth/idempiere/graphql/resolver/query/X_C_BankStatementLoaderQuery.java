package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementLoaderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatementLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankStatementLoader - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankStatementLoaderQuery extends POQuery<MBankStatementLoader> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatementLoader.Table_Name;
	}

	public CompletableFuture<MBankStatementLoader> C_BankStatementLoader(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankStatementLoader> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankStatementLoaderDataLoader.DATALOADER_C_BankStatementLoader_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankStatementLoader> C_BankStatementLoaderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
