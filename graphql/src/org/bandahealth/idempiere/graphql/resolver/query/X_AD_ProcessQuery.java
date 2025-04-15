package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProcess_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ProcessDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ProcessQuery extends POQuery<MProcess_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProcess_BH.Table_Name;
	}

	public CompletableFuture<MProcess_BH> AD_Process(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProcess_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ProcessDataLoader.DATALOADER_AD_Process_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProcess_BH> AD_ProcessGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
