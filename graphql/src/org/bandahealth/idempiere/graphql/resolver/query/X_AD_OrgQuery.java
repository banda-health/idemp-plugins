package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Org - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgQuery extends POQuery<MOrg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrg.Table_Name;
	}

	public CompletableFuture<MOrg> AD_Org(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrg> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_OrgDataLoader.DATALOADER_AD_Org_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrg> AD_OrgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
