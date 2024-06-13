package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_FieldSuggestionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MFieldSuggestion;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_FieldSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_FieldSuggestionQuery extends POQuery<MFieldSuggestion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MFieldSuggestion.Table_Name;
	}

	public CompletableFuture<MFieldSuggestion> AD_FieldSuggestion(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MFieldSuggestion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_FieldSuggestionDataLoader.DATALOADER_AD_FieldSuggestion_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MFieldSuggestion> AD_FieldSuggestionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
