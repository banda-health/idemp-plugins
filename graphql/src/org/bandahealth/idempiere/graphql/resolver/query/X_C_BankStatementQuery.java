package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BankStatementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBankStatement;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_BankStatementQuery extends POQuery<MBankStatement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBankStatement.Table_Name;
	}

	public CompletableFuture<MBankStatement> C_BankStatement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBankStatement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_BankStatementDataLoader.DATALOADER_C_BankStatement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBankStatement> C_BankStatementGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
