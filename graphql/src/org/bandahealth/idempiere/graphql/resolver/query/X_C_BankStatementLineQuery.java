package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatementLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankStatementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankStatementLineQuery extends POQuery<MBankStatementLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatementLine.Table_Name;
	}

	public CompletableFuture<MBankStatementLine> C_BankStatementLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankStatementLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankStatementLineDataLoader.DATALOADER_C_BankStatementLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankStatementLine> C_BankStatementLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
