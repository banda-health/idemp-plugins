package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LandedCostAllocationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLandedCostAllocation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_LandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_LandedCostAllocationQuery extends POQuery<MLandedCostAllocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLandedCostAllocation.Table_Name;
	}

	public CompletableFuture<MLandedCostAllocation> C_LandedCostAllocation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLandedCostAllocation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_LandedCostAllocationDataLoader.DATALOADER_C_LandedCostAllocation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLandedCostAllocation> C_LandedCostAllocationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
