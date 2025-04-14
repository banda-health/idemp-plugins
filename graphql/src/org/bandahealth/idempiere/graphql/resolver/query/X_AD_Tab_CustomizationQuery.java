package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Tab_CustomizationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Tab_Customization;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Tab_Customization - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Tab_CustomizationQuery extends POQuery<X_AD_Tab_Customization> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Tab_Customization.Table_Name;
	}

	public CompletableFuture<X_AD_Tab_Customization> AD_Tab_Customization(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_Tab_Customization> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Tab_CustomizationDataLoader.DATALOADER_AD_Tab_Customization_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_Tab_Customization> AD_Tab_CustomizationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
