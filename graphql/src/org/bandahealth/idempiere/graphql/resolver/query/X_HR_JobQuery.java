package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_JobDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Job;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Job - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_HR_JobQuery extends POQuery<X_HR_Job> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Job.Table_Name;
	}

	public CompletableFuture<X_HR_Job> HR_Job(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Job> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_JobDataLoader.DATALOADER_HR_Job_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Job> HR_JobGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
