package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_PriceList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_PriceListQuery extends POQuery<X_I_PriceList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_PriceList.Table_Name;
	}

	public CompletableFuture<X_I_PriceList> I_PriceList(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_PriceList> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_PriceListDataLoader.DATALOADER_I_PriceList_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_PriceList> I_PriceListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
