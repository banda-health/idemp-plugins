package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintColorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintColor;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PrintColor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PrintColorQuery extends POQuery<X_AD_PrintColor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintColor.Table_Name;
	}

	public CompletableFuture<X_AD_PrintColor> AD_PrintColor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PrintColor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintColorDataLoader.DATALOADER_AD_PrintColor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PrintColor> AD_PrintColorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
