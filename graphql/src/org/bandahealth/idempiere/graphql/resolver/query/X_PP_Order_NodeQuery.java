package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_NodeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order_Node;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Order_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_NodeQuery extends POQuery<X_PP_Order_Node> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_Node.Table_Name;
	}

	public CompletableFuture<X_PP_Order_Node> PP_Order_Node(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Order_Node> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_NodeDataLoader.DATALOADER_PP_Order_Node_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Order_Node> PP_Order_NodeGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
