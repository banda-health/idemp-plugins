package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_Web_PropertiesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MWebProperties;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_Web_Properties - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_U_Web_PropertiesQuery extends POQuery<MWebProperties> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWebProperties.Table_Name;
	}

	public CompletableFuture<MWebProperties> U_Web_Properties(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWebProperties> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_Web_PropertiesDataLoader.DATALOADER_U_Web_Properties_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWebProperties> U_Web_PropertiesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
