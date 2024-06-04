package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_TaskDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTypeTask;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaskQuery extends POQuery<MProjectTypeTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTypeTask.Table_Name;
	}

	public CompletableFuture<MProjectTypeTask> C_Task(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProjectTypeTask> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_TaskDataLoader.DATALOADER_C_Task_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProjectTypeTask> C_TaskGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
