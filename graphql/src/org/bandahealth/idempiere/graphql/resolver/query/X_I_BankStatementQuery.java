package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_BankStatementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_BankStatement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_BankStatement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_BankStatementQuery extends POQuery<X_I_BankStatement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_BankStatement.Table_Name;
	}

	public CompletableFuture<X_I_BankStatement> I_BankStatement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_BankStatement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_BankStatementDataLoader.DATALOADER_I_BankStatement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_BankStatement> I_BankStatementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
