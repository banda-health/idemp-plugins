package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintPaperDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintPaper;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PrintPaper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_PrintPaperQuery extends POQuery<X_AD_PrintPaper> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintPaper.Table_Name;
	}

	public CompletableFuture<X_AD_PrintPaper> AD_PrintPaper(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PrintPaper> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintPaperDataLoader.DATALOADER_AD_PrintPaper_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PrintPaper> AD_PrintPaperGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
