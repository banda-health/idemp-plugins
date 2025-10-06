package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectTaskDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTask;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectTaskQuery extends POQuery<MProjectTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTask.Table_Name;
	}

	public CompletableFuture<MProjectTask> C_ProjectTask(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectTask> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_ProjectTaskDataLoader.DATALOADER_C_ProjectTask_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectTask> C_ProjectTaskGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
