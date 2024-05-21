package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementMatcherDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatementMatcher;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankStatementMatcher - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BankStatementMatcherQuery extends POQuery<MBankStatementMatcher> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatementMatcher.Table_Name;
	}

	public CompletableFuture<MBankStatementMatcher> C_BankStatementMatcher(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankStatementMatcher> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankStatementMatcherDataLoader.DATALOADER_C_BankStatementMatcher_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankStatementMatcher> C_BankStatementMatcherGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
