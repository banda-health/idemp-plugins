package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_Fact_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFactAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for Fact_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_Fact_AcctQuery extends POQuery<MFactAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFactAcct.Table_Name;
	}

	public CompletableFuture<MFactAcct> Fact_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFactAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_Fact_AcctDataLoader.DATALOADER_Fact_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFactAcct> Fact_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
