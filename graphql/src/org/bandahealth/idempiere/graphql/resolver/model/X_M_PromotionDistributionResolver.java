package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionDistribution;
import org.compiere.model.X_M_PromotionLine;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionDistributionResolver extends POResolver<X_M_PromotionDistribution> implements GraphQLResolver<X_M_PromotionDistribution> {


	static Map<String, String> DISTRIBUTIONSORTING_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("A", "f461440f-bd1c-4273-b040-470ee206d785");
			put("D", "3b112dc7-356a-4c6a-a6b2-fc4dd284ed6d");
		}
	};
	public CompletableFuture<MRefList_BH> DistributionSorting(X_M_PromotionDistribution entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDistributionSorting())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DISTRIBUTIONSORTING_UUIDS_BY_VALUE.get(entity.getDistributionSorting()));
	}

	static Map<String, String> DISTRIBUTIONTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("I", "fa5f2e0e-cd4f-40aa-a5bc-29505c472c9b");
			put("X", "06fdaecc-7420-4571-81b7-6d187494f0f7");
			put("N", "dabb99f2-9c41-43cd-be7e-6e8ece54fee3");
		}
	};
	public CompletableFuture<MRefList_BH> DistributionType(X_M_PromotionDistribution entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDistributionType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DISTRIBUTIONTYPE_UUIDS_BY_VALUE.get(entity.getDistributionType()));
	}


	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	public CompletableFuture<X_M_Promotion> M_Promotion(X_M_PromotionDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getM_Promotion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_Promotion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDataLoader.M_Promotion_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Promotion_ID());
	}


	/**
	 * Get Promotion Line.
	 *
	 * @return Promotion Line
	 */
	public CompletableFuture<X_M_PromotionLine> M_PromotionLine(X_M_PromotionDistribution entity, DataFetchingEnvironment environment) {
		if (entity.getM_PromotionLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_PromotionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionLineDataLoader.M_PromotionLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_PromotionLine_ID());
	}

	static Map<String, String> OPERATION_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put(">=", "515c0104-46a5-40f0-8b4e-4fb57c7dee83");
			put("<=", "092bf206-2888-4392-b432-c3bbb2c6c980");
		}
	};
	public CompletableFuture<MRefList_BH> Operation(X_M_PromotionDistribution entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOperation())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(OPERATION_UUIDS_BY_VALUE.get(entity.getOperation()));
	}

}
