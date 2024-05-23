package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_BuyerFundsDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_BuyerFunds;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_BuyerFunds - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_B_BuyerFundsQuery extends POQuery<X_B_BuyerFunds> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_BuyerFunds.Table_Name;
	}

	public CompletableFuture<X_B_BuyerFunds> B_BuyerFunds(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_BuyerFunds> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_BuyerFundsDataLoader.DATALOADER_B_BuyerFunds_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_BuyerFunds> B_BuyerFundsGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
