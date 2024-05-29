package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Table_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTableAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Table_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Table_AccessQuery extends POQuery<MTableAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTableAccess.Table_Name;
	}

	public CompletableFuture<MTableAccess> AD_Table_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTableAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Table_AccessDataLoader.DATALOADER_AD_Table_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTableAccess> AD_Table_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
