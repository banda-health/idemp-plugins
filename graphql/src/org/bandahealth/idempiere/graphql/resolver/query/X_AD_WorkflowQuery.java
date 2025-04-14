package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WorkflowQuery extends POQuery<X_AD_Workflow> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Workflow.Table_Name;
	}

	public CompletableFuture<X_AD_Workflow> AD_Workflow(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Workflow> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Workflow> AD_WorkflowGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
