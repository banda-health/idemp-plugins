package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_User_RolesDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserRoles;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_User_RolesQuery extends POQuery<MUserRoles> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserRoles.Table_Name;
	}

	public CompletableFuture<MUserRoles> AD_User_Roles(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserRoles> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_User_RolesDataLoader.DATALOADER_AD_User_Roles_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserRoles> AD_User_RolesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
