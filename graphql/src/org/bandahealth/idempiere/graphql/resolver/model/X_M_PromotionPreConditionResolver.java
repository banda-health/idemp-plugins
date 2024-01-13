package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPGroup_BH;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ActivityDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BP_GroupDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PriceListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_PromotionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.compiere.model.MActivity;
import org.compiere.model.MPriceList;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionPreCondition;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_PromotionPreCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionPreConditionResolver extends POResolver<X_M_PromotionPreCondition> implements GraphQLResolver<X_M_PromotionPreCondition> {



	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public CompletableFuture<MActivity> C_Activity(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getC_Activity_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MActivity> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ActivityDataLoader.DATALOADER_C_Activity_BY_ID);
		return dataLoader.load(entity.getC_Activity_ID());
	}


	/**
	 * Get Business Partner Group.
	 *
	 * @return Business Partner Group
	 */
	public CompletableFuture<MBPGroup_BH> C_BP_Group(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getC_BP_Group_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPGroup_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BP_GroupDataLoader.DATALOADER_C_BP_Group_BY_ID);
		return dataLoader.load(entity.getC_BP_Group_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Price List.
	 *
	 * @return Unique identifier of a Price List
	 */
	public CompletableFuture<MPriceList> M_PriceList(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getM_PriceList_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPriceList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PriceListDataLoader.DATALOADER_M_PriceList_BY_ID);
		return dataLoader.load(entity.getM_PriceList_ID());
	}


	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	public CompletableFuture<X_M_Promotion> M_Promotion(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Promotion_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_M_Promotion> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_PromotionDataLoader.DATALOADER_M_Promotion_BY_ID);
		return dataLoader.load(entity.getM_Promotion_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_M_PromotionPreCondition entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

}
