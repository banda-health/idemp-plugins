package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_SubAcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_SubAcct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_SubAcct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_SubAcctQuery extends POQuery<X_C_SubAcct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_SubAcct.Table_Name;
	}

	public CompletableFuture<X_C_SubAcct> C_SubAcct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_SubAcct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_SubAcctDataLoader.DATALOADER_C_SubAcct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_SubAcct> C_SubAcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
