package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_AcctDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Product_Acct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_Product_AcctQuery extends POQuery<X_M_Product_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Product_Acct.Table_Name;
	}

	public CompletableFuture<X_M_Product_Acct> M_Product_Acct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_Product_Acct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_AcctDataLoader.DATALOADER_M_Product_Acct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_Product_Acct> M_Product_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
