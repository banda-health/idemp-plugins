package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPriceList;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PriceList - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PriceListQuery extends POQuery<MPriceList> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPriceList.Table_Name;
	}

	public CompletableFuture<MPriceList> M_PriceList(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPriceList> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPriceList> M_PriceListGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
