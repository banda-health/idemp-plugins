package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_DashboardPreferenceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDashboardPreference;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_DashboardPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_DashboardPreferenceQuery extends POQuery<MDashboardPreference> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDashboardPreference.Table_Name;
	}

	public CompletableFuture<MDashboardPreference> PA_DashboardPreference(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDashboardPreference> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_DashboardPreferenceDataLoader.DATALOADER_PA_DashboardPreference_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDashboardPreference> PA_DashboardPreferenceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
