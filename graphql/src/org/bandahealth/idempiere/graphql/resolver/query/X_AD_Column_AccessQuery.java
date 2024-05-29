package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Column_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColumnAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Column_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Column_AccessQuery extends POQuery<MColumnAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColumnAccess.Table_Name;
	}

	public CompletableFuture<MColumnAccess> AD_Column_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MColumnAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Column_AccessDataLoader.DATALOADER_AD_Column_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MColumnAccess> AD_Column_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
