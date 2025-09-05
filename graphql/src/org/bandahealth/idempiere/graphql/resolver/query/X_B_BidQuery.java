package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_B_BidDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_B_Bid;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for B_Bid - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_B_BidQuery extends POQuery<X_B_Bid> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_B_Bid.Table_Name;
	}

	public CompletableFuture<X_B_Bid> B_Bid(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_B_Bid> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_B_BidDataLoader.DATALOADER_B_Bid_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_B_Bid> B_BidGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
