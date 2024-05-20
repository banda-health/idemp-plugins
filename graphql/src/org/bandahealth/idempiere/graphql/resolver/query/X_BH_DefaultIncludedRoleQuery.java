package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHDefaultIncludedRole;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_DefaultIncludedRoleDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_DefaultIncludedRole - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_DefaultIncludedRoleQuery extends POQuery<MBHDefaultIncludedRole> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHDefaultIncludedRole.Table_Name;
	}

	public CompletableFuture<MBHDefaultIncludedRole> BH_DefaultIncludedRole(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHDefaultIncludedRole> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_DefaultIncludedRoleDataLoader.DATALOADER_BH_DefaultIncludedRole_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHDefaultIncludedRole> BH_DefaultIncludedRoleGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
