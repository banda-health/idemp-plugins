package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_CtxHelpSuggestionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCtxHelpSuggestion;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_CtxHelpSuggestion - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_CtxHelpSuggestionQuery extends POQuery<MCtxHelpSuggestion> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCtxHelpSuggestion.Table_Name;
	}

	public CompletableFuture<MCtxHelpSuggestion> AD_CtxHelpSuggestion(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCtxHelpSuggestion> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_CtxHelpSuggestionDataLoader.DATALOADER_AD_CtxHelpSuggestion_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCtxHelpSuggestion> AD_CtxHelpSuggestionGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
