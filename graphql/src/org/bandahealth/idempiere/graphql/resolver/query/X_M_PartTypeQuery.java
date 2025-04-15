package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PartTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_PartType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_PartType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_PartTypeQuery extends POQuery<X_M_PartType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_PartType.Table_Name;
	}

	public CompletableFuture<X_M_PartType> M_PartType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_PartType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_PartTypeDataLoader.DATALOADER_M_PartType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_PartType> M_PartTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
