package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_DemandDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_Demand;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Demand - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DemandQuery extends POQuery<X_M_Demand> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_Demand.Table_Name;
	}

	public CompletableFuture<X_M_Demand> M_Demand(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_Demand> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_DemandDataLoader.DATALOADER_M_Demand_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_Demand> M_DemandGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
