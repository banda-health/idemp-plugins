package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFontDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintFont;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PrintFont - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintFontQuery extends POQuery<X_AD_PrintFont> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintFont.Table_Name;
	}

	public CompletableFuture<X_AD_PrintFont> AD_PrintFont(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PrintFont> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintFontDataLoader.DATALOADER_AD_PrintFont_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PrintFont> AD_PrintFontGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
