package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WF_ResponsibleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_WF_Responsible;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_WF_Responsible - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_ResponsibleQuery extends POQuery<X_AD_WF_Responsible> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_WF_Responsible.Table_Name;
	}

	public CompletableFuture<X_AD_WF_Responsible> AD_WF_Responsible(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_WF_Responsible> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_WF_ResponsibleDataLoader.DATALOADER_AD_WF_Responsible_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_WF_Responsible> AD_WF_ResponsibleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
