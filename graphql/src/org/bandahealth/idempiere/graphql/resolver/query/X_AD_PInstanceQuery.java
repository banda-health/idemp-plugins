package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPInstance;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PInstanceQuery extends POQuery<MPInstance> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPInstance.Table_Name;
	}

	public CompletableFuture<MPInstance> AD_PInstance(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPInstance> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPInstance> AD_PInstanceGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
