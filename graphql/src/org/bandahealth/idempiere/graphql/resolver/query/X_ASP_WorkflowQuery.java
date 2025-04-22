package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_ASP_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_ASP_Workflow;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_ASP_WorkflowQuery extends POQuery<X_ASP_Workflow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_ASP_Workflow.Table_Name;
	}

	public CompletableFuture<X_ASP_Workflow> ASP_Workflow(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_ASP_Workflow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_ASP_WorkflowDataLoader.DATALOADER_ASP_Workflow_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_ASP_Workflow> ASP_WorkflowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
