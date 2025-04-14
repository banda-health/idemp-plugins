package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ImpFormatDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_ImpFormat;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ImpFormat - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImpFormatQuery extends POQuery<X_AD_ImpFormat> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_ImpFormat.Table_Name;
	}

	public CompletableFuture<X_AD_ImpFormat> AD_ImpFormat(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_ImpFormat> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ImpFormatDataLoader.DATALOADER_AD_ImpFormat_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_ImpFormat> AD_ImpFormatGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
