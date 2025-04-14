package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MCostElement;
import org.compiere.model.MOrderLandedCost;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_OrderLandedCostResolver extends POResolver<MOrderLandedCost> implements GraphQLResolver<MOrderLandedCost> {



	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(MOrderLandedCost entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getC_Order_ID());
	}

	public static Map<String, String> LANDEDCOSTDISTRIBUTION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("Q", "50d100e4-2858-45bd-879a-f5b1d87bd29a"); // Quantity
			put("L", "0ea8969b-c655-4d56-bcfe-5c6aa5f2a60e"); // Line
			put("V", "22944d38-a239-48c2-a16b-07b262313c12"); // Volume
			put("W", "c48079eb-eed7-44c7-9656-136001c30e83"); // Weight
			put("C", "42bd1312-993d-42c1-83ff-4af920699f12"); // Costs
		}
	};
	public CompletableFuture<MRefList_BH> LandedCostDistribution(MOrderLandedCost entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getLandedCostDistribution())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(LANDEDCOSTDISTRIBUTION_UUIDS_BY_VALUE.get(entity.getLandedCostDistribution()));
	}


	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public CompletableFuture<MCostElement> M_CostElement(MOrderLandedCost entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostElement_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MCostElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostElementDataLoader.DATALOADER_M_CostElement_BY_ID);
		return dataLoader.load(entity.getM_CostElement_ID());
	}

	public Boolean Processed(MOrderLandedCost entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

}
