package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Process;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WF_ProcessQuery extends POQuery<X_AD_WF_Process> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Process.Table_Name;
	}

	public CompletableFuture<X_AD_WF_Process> AD_WF_Process(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_Process> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_ProcessDataLoader.DATALOADER_AD_WF_Process_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_Process> AD_WF_ProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
