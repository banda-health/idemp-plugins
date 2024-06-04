package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrgInfo_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_OrgInfoDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_OrgInfoQuery extends POQuery<MOrgInfo_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrgInfo_BH.Table_Name;
	}

	public CompletableFuture<MOrgInfo_BH> AD_OrgInfo(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrgInfo_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_OrgInfoDataLoader.DATALOADER_AD_OrgInfo_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrgInfo_BH> AD_OrgInfoGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
