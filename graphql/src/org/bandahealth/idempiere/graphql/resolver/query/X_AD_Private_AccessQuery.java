package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Private_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPrivateAccess;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Private_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Private_AccessQuery extends POQuery<MPrivateAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPrivateAccess.Table_Name;
	}

	public CompletableFuture<MPrivateAccess> AD_Private_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPrivateAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Private_AccessDataLoader.DATALOADER_AD_Private_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPrivateAccess> AD_Private_AccessGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
