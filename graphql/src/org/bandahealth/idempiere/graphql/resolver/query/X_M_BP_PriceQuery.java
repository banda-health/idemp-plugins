package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BP_PriceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_BP_Price;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_BP_Price - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_BP_PriceQuery extends POQuery<X_M_BP_Price> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_BP_Price.Table_Name;
	}

	public CompletableFuture<X_M_BP_Price> M_BP_Price(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_BP_Price> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_BP_PriceDataLoader.DATALOADER_M_BP_Price_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_BP_Price> M_BP_PriceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
