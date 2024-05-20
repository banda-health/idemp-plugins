package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_EntityTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEntityType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_EntityType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_EntityTypeQuery extends POQuery<MEntityType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEntityType.Table_Name;
	}

	public CompletableFuture<MEntityType> AD_EntityType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEntityType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_EntityTypeDataLoader.DATALOADER_AD_EntityType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEntityType> AD_EntityTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
