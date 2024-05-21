package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserPreferenceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserPreference;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_UserPreference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_UserPreferenceQuery extends POQuery<MUserPreference> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserPreference.Table_Name;
	}

	public CompletableFuture<MUserPreference> AD_UserPreference(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserPreference> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_UserPreferenceDataLoader.DATALOADER_AD_UserPreference_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserPreference> AD_UserPreferenceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
