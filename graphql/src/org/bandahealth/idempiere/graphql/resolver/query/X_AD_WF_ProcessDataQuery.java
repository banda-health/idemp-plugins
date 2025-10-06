package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ProcessDataDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_ProcessData;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_ProcessDataQuery extends POQuery<X_AD_WF_ProcessData> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_ProcessData.Table_Name;
	}

	public CompletableFuture<X_AD_WF_ProcessData> AD_WF_ProcessData(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_ProcessData> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_ProcessDataDataLoader.DATALOADER_AD_WF_ProcessData_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_ProcessData> AD_WF_ProcessDataGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
