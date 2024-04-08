package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.MOrderLandedCostAllocationDataLoader;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrderLandedCostAllocation;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MOrderLandedCostResolver extends X_C_OrderLandedCostResolver {

	public CompletableFuture<List<MOrderLandedCostAllocation>> C_OrderLandedCostAllocationList(MOrderLandedCost entity,
			DataFetchingEnvironment environment) {
		DataLoader<String, List<MOrderLandedCostAllocation>> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(
						MOrderLandedCostAllocationDataLoader.DATALOADER_C_OrderLandedCostAllocation_BY_C_OrderLandedCost_ID);
		return dataLoader.load(ModelUtil.getModelKey(entity, entity.getC_OrderLandedCost_ID()));
	}
}
