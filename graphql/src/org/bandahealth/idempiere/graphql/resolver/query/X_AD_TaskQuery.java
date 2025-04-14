package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TaskDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTask;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_TaskQuery extends POQuery<MTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTask.Table_Name;
	}

	public CompletableFuture<MTask> AD_Task(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTask> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TaskDataLoader.DATALOADER_AD_Task_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTask> AD_TaskGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
