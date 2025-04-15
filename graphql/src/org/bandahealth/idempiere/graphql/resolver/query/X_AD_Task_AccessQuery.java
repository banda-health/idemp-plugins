package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Task_AccessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTaskAccess;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Task_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Task_AccessQuery extends POQuery<MTaskAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTaskAccess.Table_Name;
	}

	public CompletableFuture<MTaskAccess> AD_Task_Access(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTaskAccess> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Task_AccessDataLoader.DATALOADER_AD_Task_Access_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTaskAccess> AD_Task_AccessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
