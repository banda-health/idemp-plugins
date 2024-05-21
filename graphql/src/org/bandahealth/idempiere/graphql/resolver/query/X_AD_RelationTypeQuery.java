package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_RelationTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_RelationType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_RelationType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RelationTypeQuery extends POQuery<X_AD_RelationType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_RelationType.Table_Name;
	}

	public CompletableFuture<X_AD_RelationType> AD_RelationType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_AD_RelationType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_RelationTypeDataLoader.DATALOADER_AD_RelationType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_AD_RelationType> AD_RelationTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
