package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Role_WarehouseAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Role_WarehouseAccessQuery extends POQuery<MBHRoleWarehouseAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHRoleWarehouseAccess.Table_Name;
	}

	public CompletableFuture<MBHRoleWarehouseAccess> BH_Role_WarehouseAccess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHRoleWarehouseAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Role_WarehouseAccessDataLoader.DATALOADER_BH_Role_WarehouseAccess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHRoleWarehouseAccess> BH_Role_WarehouseAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
