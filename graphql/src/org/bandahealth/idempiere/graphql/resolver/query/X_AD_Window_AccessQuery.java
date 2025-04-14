package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MWindowAccess_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Window_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Window_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Window_AccessQuery extends POQuery<MWindowAccess_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MWindowAccess_BH.Table_Name;
	}

	public CompletableFuture<MWindowAccess_BH> AD_Window_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MWindowAccess_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Window_AccessDataLoader.DATALOADER_AD_Window_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MWindowAccess_BH> AD_Window_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
