package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineMADataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInventoryLineMA;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryLineMAQuery extends POQuery<MInventoryLineMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInventoryLineMA.Table_Name;
	}

	public CompletableFuture<MInventoryLineMA> M_InventoryLineMA(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInventoryLineMA> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InventoryLineMADataLoader.DATALOADER_M_InventoryLineMA_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInventoryLineMA> M_InventoryLineMAGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
