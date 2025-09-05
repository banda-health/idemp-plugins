package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order_Workflow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PP_Order_WorkflowQuery extends POQuery<X_PP_Order_Workflow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_Workflow.Table_Name;
	}

	public CompletableFuture<X_PP_Order_Workflow> PP_Order_Workflow(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PP_Order_Workflow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Order_WorkflowDataLoader.DATALOADER_PP_Order_Workflow_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PP_Order_Workflow> PP_Order_WorkflowGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
