package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceQuery extends POQuery<MResource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResource.Table_Name;
	}

	public CompletableFuture<MResource> S_Resource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MResource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MResource> S_ResourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
