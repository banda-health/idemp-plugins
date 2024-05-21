package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_WarehouseQuery extends POQuery<MWarehouse_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWarehouse_BH.Table_Name;
	}

	public CompletableFuture<MWarehouse_BH> M_Warehouse(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWarehouse_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWarehouse_BH> M_WarehouseGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
