package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ClientInfoDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MClientInfo;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ClientInfoQuery extends POQuery<MClientInfo> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MClientInfo.Table_Name;
	}

	public CompletableFuture<MClientInfo> AD_ClientInfo(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MClientInfo> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ClientInfoDataLoader.DATALOADER_AD_ClientInfo_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MClientInfo> AD_ClientInfoGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
