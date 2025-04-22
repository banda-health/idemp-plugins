package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PreferenceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPreference;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Preference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PreferenceQuery extends POQuery<MPreference> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPreference.Table_Name;
	}

	public CompletableFuture<MPreference> AD_Preference(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPreference> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PreferenceDataLoader.DATALOADER_AD_Preference_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPreference> AD_PreferenceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
