package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSysConfig_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SysConfigDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_SysConfig - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SysConfigQuery extends POQuery<MSysConfig_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSysConfig_BH.Table_Name;
	}

	public CompletableFuture<MSysConfig_BH> AD_SysConfig(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSysConfig_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SysConfigDataLoader.DATALOADER_AD_SysConfig_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSysConfig_BH> AD_SysConfigGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
