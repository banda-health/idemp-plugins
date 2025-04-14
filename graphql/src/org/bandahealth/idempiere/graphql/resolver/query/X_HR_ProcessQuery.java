package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_HR_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_HR_Process;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for HR_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_HR_ProcessQuery extends POQuery<X_HR_Process> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_HR_Process.Table_Name;
	}

	public CompletableFuture<X_HR_Process> HR_Process(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_HR_Process> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_HR_ProcessDataLoader.DATALOADER_HR_Process_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_HR_Process> HR_ProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
