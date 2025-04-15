package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_OrderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.MDDOrder;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for DD_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_DD_OrderQuery extends POQuery<MDDOrder> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDDOrder.Table_Name;
	}

	public CompletableFuture<MDDOrder> DD_Order(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDDOrder> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_DD_OrderDataLoader.DATALOADER_DD_Order_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDDOrder> DD_OrderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
