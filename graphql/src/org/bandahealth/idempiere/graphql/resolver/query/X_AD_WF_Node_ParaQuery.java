package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_Node_ParaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Node_Para;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_Node_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_Node_ParaQuery extends POQuery<X_AD_WF_Node_Para> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Node_Para.Table_Name;
	}

	public CompletableFuture<X_AD_WF_Node_Para> AD_WF_Node_Para(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_Node_Para> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_Node_ParaDataLoader.DATALOADER_AD_WF_Node_Para_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_Node_Para> AD_WF_Node_ParaGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
