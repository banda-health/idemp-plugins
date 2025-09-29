package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLandedCostAllocationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MOrderLandedCostAllocation;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderLandedCostAllocationQuery extends POQuery<MOrderLandedCostAllocation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MOrderLandedCostAllocation.Table_Name;
	}

	public CompletableFuture<MOrderLandedCostAllocation> C_OrderLandedCostAllocation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MOrderLandedCostAllocation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_OrderLandedCostAllocationDataLoader.DATALOADER_C_OrderLandedCostAllocation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MOrderLandedCostAllocation> C_OrderLandedCostAllocationGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
