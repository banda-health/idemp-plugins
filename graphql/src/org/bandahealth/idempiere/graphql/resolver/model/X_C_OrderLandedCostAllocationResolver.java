package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLandedCostDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.compiere.model.MOrderLandedCost;
import org.compiere.model.MOrderLandedCostAllocation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderLandedCostAllocationResolver extends POResolver<MOrderLandedCostAllocation> implements GraphQLResolver<MOrderLandedCostAllocation> {



	/**
	 * Get Estimated Landed Cost.
	 *
	 * @return Estimated Landed Cost
	 */
	public CompletableFuture<MOrderLandedCost> C_OrderLandedCost(MOrderLandedCostAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLandedCost_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLandedCost> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLandedCostDataLoader.DATALOADER_C_OrderLandedCost_BY_ID);
		return dataLoader.load(entity.getC_OrderLandedCost_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(MOrderLandedCostAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.DATALOADER_C_OrderLine_BY_ID);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}

	public Boolean Processed(MOrderLandedCostAllocation entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
