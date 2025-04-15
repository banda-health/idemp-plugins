package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_SystemDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSystem;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_System - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_SystemQuery extends POQuery<MSystem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSystem.Table_Name;
	}

	public CompletableFuture<MSystem> AD_System(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSystem> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_SystemDataLoader.DATALOADER_AD_System_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSystem> AD_SystemGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
