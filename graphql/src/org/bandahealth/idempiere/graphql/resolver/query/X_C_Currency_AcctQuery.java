package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Currency_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCurrencyAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Currency_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_Currency_AcctQuery extends POQuery<MCurrencyAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCurrencyAcct.Table_Name;
	}

	public CompletableFuture<MCurrencyAcct> C_Currency_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCurrencyAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Currency_AcctDataLoader.DATALOADER_C_Currency_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCurrencyAcct> C_Currency_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
