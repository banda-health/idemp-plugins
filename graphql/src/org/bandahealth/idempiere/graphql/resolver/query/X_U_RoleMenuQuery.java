package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_U_RoleMenuDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRoleMenu;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for U_RoleMenu - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_U_RoleMenuQuery extends POQuery<MRoleMenu> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRoleMenu.Table_Name;
	}

	public CompletableFuture<MRoleMenu> U_RoleMenu(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRoleMenu> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_U_RoleMenuDataLoader.DATALOADER_U_RoleMenu_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRoleMenu> U_RoleMenuGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
