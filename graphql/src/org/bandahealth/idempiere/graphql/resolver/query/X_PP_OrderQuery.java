package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_OrderQuery extends POQuery<X_PP_Order> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order.Table_Name;
	}

	public CompletableFuture<X_PP_Order> PP_Order(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Order> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_OrderDataLoader.DATALOADER_PP_Order_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Order> PP_OrderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
