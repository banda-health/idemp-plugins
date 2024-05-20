package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderQuery extends POQuery<MOrder_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrder_BH.Table_Name;
	}

	public CompletableFuture<MOrder_BH> C_Order(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrder_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrder_BH> C_OrderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
