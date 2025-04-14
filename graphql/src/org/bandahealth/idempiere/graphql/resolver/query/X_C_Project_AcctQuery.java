package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_Project_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Project_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_Project_AcctQuery extends POQuery<X_C_Project_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Project_Acct.Table_Name;
	}

	public CompletableFuture<X_C_Project_Acct> C_Project_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Project_Acct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_Project_AcctDataLoader.DATALOADER_C_Project_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Project_Acct> C_Project_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
