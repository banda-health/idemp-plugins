package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_JobDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Job;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_JobQuery extends POQuery<X_C_Job> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Job.Table_Name;
	}

	public CompletableFuture<X_C_Job> C_Job(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_C_Job> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_JobDataLoader.DATALOADER_C_Job_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_C_Job> C_JobGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
