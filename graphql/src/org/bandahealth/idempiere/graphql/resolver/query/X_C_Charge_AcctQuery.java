package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Charge_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Charge_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Charge_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Charge_AcctQuery extends POQuery<X_C_Charge_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Charge_Acct.Table_Name;
	}

	public CompletableFuture<X_C_Charge_Acct> C_Charge_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Charge_Acct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Charge_AcctDataLoader.DATALOADER_C_Charge_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Charge_Acct> C_Charge_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
