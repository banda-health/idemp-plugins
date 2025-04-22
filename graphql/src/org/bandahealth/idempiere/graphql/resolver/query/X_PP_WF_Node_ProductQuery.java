package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_WF_Node_ProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_WF_Node_Product;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_WF_Node_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_WF_Node_ProductQuery extends POQuery<X_PP_WF_Node_Product> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_WF_Node_Product.Table_Name;
	}

	public CompletableFuture<X_PP_WF_Node_Product> PP_WF_Node_Product(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_WF_Node_Product> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_WF_Node_ProductDataLoader.DATALOADER_PP_WF_Node_Product_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_WF_Node_Product> PP_WF_Node_ProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
