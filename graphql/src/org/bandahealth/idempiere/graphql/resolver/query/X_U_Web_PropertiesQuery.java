package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_Web_PropertiesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_U_Web_Properties;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_Web_Properties - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_Web_PropertiesQuery extends POQuery<X_U_Web_Properties> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_U_Web_Properties.Table_Name;
	}

	public CompletableFuture<X_U_Web_Properties> U_Web_Properties(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_U_Web_Properties> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_Web_PropertiesDataLoader.DATALOADER_U_Web_Properties_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_U_Web_Properties> U_Web_PropertiesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
