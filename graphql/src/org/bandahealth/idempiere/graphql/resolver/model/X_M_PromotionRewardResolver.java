package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDistributionDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionDistribution;
import org.compiere.model.X_M_PromotionReward;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionRewardResolver extends POResolver<X_M_PromotionReward> implements GraphQLResolver<X_M_PromotionReward> {



	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.DATALOADER_C_Charge_BY_ID);
		return dataLoader.load(entity.getC_Charge_ID());
	}

	static Map<String, String> DISTRIBUTIONSORTING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f461440f-bd1c-4273-b040-470ee206d785");
			put("D", "3b112dc7-356a-4c6a-a6b2-fc4dd284ed6d");
		}
	};
	public CompletableFuture<MRefList_BH> DistributionSorting(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDistributionSorting())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(DISTRIBUTIONSORTING_UUIDS_BY_VALUE.get(entity.getDistributionSorting()));
	}

	public Boolean IsForAllDistribution(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		return entity.isForAllDistribution();
	}

	public Boolean IsSameDistribution(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		return entity.isSameDistribution();
	}


	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	public CompletableFuture<X_M_Promotion> M_Promotion(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (entity.getM_Promotion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_Promotion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDataLoader.DATALOADER_M_Promotion_BY_ID);
		return dataLoader.load(entity.getM_Promotion_ID());
	}


	/**
	 * Get Promotion Distribution.
	 *
	 * @return Promotion Distribution
	 */
	public CompletableFuture<X_M_PromotionDistribution> M_PromotionDistribution(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (entity.getM_PromotionDistribution_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PromotionDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDistributionDataLoader.DATALOADER_M_PromotionDistribution_BY_ID);
		return dataLoader.load(entity.getM_PromotionDistribution_ID());
	}


	/**
	 * Get Target distribution.
	 *
	 * @return Get product from target distribution to apply the promotion reward
	 */
	public CompletableFuture<X_M_PromotionDistribution> M_TargetDistribution(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (entity.getM_TargetDistribution_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PromotionDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDistributionDataLoader.DATALOADER_M_PromotionDistribution_BY_ID);
		return dataLoader.load(entity.getM_TargetDistribution_ID());
	}

	static Map<String, String> REWARDTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("P", "2ba1e9ad-85b2-4e28-b3eb-e154cdbf6b96");
			put("F", "1686a650-9428-47a9-8131-841178d93ff0");
			put("A", "eb105cf3-9a20-4425-834c-a64e45a60555");
		}
	};
	public CompletableFuture<MRefList_BH> RewardType(X_M_PromotionReward entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getRewardType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REWARDTYPE_UUIDS_BY_VALUE.get(entity.getRewardType()));
	}

}
