package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MInventoryLine;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_InventoryLineQuery extends POQuery<MInventoryLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MInventoryLine.Table_Name;
	}

	public CompletableFuture<MInventoryLine> M_InventoryLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MInventoryLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MInventoryLine> M_InventoryLineGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
