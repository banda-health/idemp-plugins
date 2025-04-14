package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_S_ResourceTypeQuery extends POQuery<MResourceType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceType.Table_Name;
	}

	public CompletableFuture<MResourceType> S_ResourceType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MResourceType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_S_ResourceTypeDataLoader.DATALOADER_S_ResourceType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MResourceType> S_ResourceTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
