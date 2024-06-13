package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_RV_WarehousePriceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWarehousePrice;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_RV_WarehousePriceQuery extends POQuery<MWarehousePrice> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWarehousePrice.Table_Name;
	}

	public CompletableFuture<MWarehousePrice> RV_WarehousePrice(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWarehousePrice> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_RV_WarehousePriceDataLoader.DATALOADER_RV_WarehousePrice_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWarehousePrice> RV_WarehousePriceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
