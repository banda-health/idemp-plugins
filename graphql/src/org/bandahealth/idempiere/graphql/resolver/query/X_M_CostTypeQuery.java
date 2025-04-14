package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostType;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CostType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_CostTypeQuery extends POQuery<MCostType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostType.Table_Name;
	}

	public CompletableFuture<MCostType> M_CostType(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCostType> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostTypeDataLoader.DATALOADER_M_CostType_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCostType> M_CostTypeGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
