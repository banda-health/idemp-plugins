package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Activity;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_Activity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_ActivityQuery extends POQuery<X_AD_WF_Activity> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Activity.Table_Name;
	}

	public CompletableFuture<X_AD_WF_Activity> AD_WF_Activity(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_Activity> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_ActivityDataLoader.DATALOADER_AD_WF_Activity_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_Activity> AD_WF_ActivityGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
