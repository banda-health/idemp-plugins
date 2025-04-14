package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_BOMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order_BOM;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Order_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_BOMQuery extends POQuery<X_PP_Order_BOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_BOM.Table_Name;
	}

	public CompletableFuture<X_PP_Order_BOM> PP_Order_BOM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Order_BOM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_BOMDataLoader.DATALOADER_PP_Order_BOM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Order_BOM> PP_Order_BOMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
