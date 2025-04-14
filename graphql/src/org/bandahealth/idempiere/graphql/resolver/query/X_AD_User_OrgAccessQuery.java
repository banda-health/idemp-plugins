package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_User_OrgAccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserOrgAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_User_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_User_OrgAccessQuery extends POQuery<MUserOrgAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserOrgAccess.Table_Name;
	}

	public CompletableFuture<MUserOrgAccess> AD_User_OrgAccess(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MUserOrgAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_User_OrgAccessDataLoader.DATALOADER_AD_User_OrgAccess_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MUserOrgAccess> AD_User_OrgAccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
