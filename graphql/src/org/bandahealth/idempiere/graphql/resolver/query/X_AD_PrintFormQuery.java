package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PrintFormDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_PrintForm;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PrintForm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_PrintFormQuery extends POQuery<X_AD_PrintForm> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_PrintForm.Table_Name;
	}

	public CompletableFuture<X_AD_PrintForm> AD_PrintForm(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_PrintForm> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PrintFormDataLoader.DATALOADER_AD_PrintForm_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_PrintForm> AD_PrintFormGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
