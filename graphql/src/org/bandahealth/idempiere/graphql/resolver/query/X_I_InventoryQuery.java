package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_InventoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Inventory;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_InventoryQuery extends POQuery<X_I_Inventory> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Inventory.Table_Name;
	}

	public CompletableFuture<X_I_Inventory> I_Inventory(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_Inventory> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_InventoryDataLoader.DATALOADER_I_Inventory_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_Inventory> I_InventoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
