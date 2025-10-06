package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_LanguageDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLanguage;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Language - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_LanguageQuery extends POQuery<MLanguage> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLanguage.Table_Name;
	}

	public CompletableFuture<MLanguage> AD_Language(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLanguage> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_LanguageDataLoader.DATALOADER_AD_Language_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLanguage> AD_LanguageGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
