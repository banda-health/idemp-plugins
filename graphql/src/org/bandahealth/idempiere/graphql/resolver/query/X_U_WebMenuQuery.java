package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_WebMenuDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_U_WebMenu;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_WebMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_WebMenuQuery extends POQuery<X_U_WebMenu> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_U_WebMenu.Table_Name;
	}

	public CompletableFuture<X_U_WebMenu> U_WebMenu(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_U_WebMenu> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_WebMenuDataLoader.DATALOADER_U_WebMenu_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_U_WebMenu> U_WebMenuGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
