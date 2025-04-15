package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_NodeNextDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order_NodeNext;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Order_NodeNext - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_NodeNextQuery extends POQuery<X_PP_Order_NodeNext> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_NodeNext.Table_Name;
	}

	public CompletableFuture<X_PP_Order_NodeNext> PP_Order_NodeNext(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Order_NodeNext> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_NodeNextDataLoader.DATALOADER_PP_Order_NodeNext_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Order_NodeNext> PP_Order_NodeNextGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
