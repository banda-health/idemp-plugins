package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_NextConditionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_NextCondition;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_NextConditionQuery extends POQuery<X_AD_WF_NextCondition> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_NextCondition.Table_Name;
	}

	public CompletableFuture<X_AD_WF_NextCondition> AD_WF_NextCondition(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_NextCondition> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_NextConditionDataLoader.DATALOADER_AD_WF_NextCondition_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_NextCondition> AD_WF_NextConditionGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
