package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InventoryQuery extends POQuery<MInventory_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInventory_BH.Table_Name;
	}

	public CompletableFuture<MInventory_BH> M_Inventory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInventory_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InventoryDataLoader.DATALOADER_M_Inventory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInventory_BH> M_InventoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
