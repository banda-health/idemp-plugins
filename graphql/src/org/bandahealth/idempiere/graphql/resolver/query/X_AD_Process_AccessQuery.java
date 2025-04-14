package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Process_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProcessAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Process_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Process_AccessQuery extends POQuery<MProcessAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProcessAccess.Table_Name;
	}

	public CompletableFuture<MProcessAccess> AD_Process_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProcessAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Process_AccessDataLoader.DATALOADER_AD_Process_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProcessAccess> AD_Process_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
