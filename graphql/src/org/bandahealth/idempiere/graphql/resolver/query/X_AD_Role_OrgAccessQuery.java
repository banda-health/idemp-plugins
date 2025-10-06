package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Role_OrgAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRoleOrgAccess;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Role_OrgAccessQuery extends POQuery<MRoleOrgAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRoleOrgAccess.Table_Name;
	}

	public CompletableFuture<MRoleOrgAccess> AD_Role_OrgAccess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRoleOrgAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Role_OrgAccessDataLoader.DATALOADER_AD_Role_OrgAccess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRoleOrgAccess> AD_Role_OrgAccessGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
