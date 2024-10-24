package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_DocTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MPInstance;
import org.compiere.model.X_T_Replenish;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_ReplenishResolver extends POResolver<X_T_Replenish> implements GraphQLResolver<X_T_Replenish> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public CompletableFuture<MDocType_BH> C_DocType(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getC_DocType_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MDocType_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_DocTypeDataLoader.DATALOADER_C_DocType_BY_ID);
		return dataLoader.load(entity.getC_DocType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}


	/**
	 * Get Source Warehouse.
	 *
	 * @return Optional Warehouse to replenish from
	 */
	public CompletableFuture<MWarehouse_BH> M_WarehouseSource(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (entity.getM_WarehouseSource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_WarehouseSource_ID());
	}

	public static Map<String, String> REPLENISHMENTCREATE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("POO", "b3daba11-9275-44c0-89f3-f296e5402cfa"); // Purchase Order
			put("POR", "32478382-1f8e-4ed4-9d64-98112e01ee15"); // Requisition
			put("MMM", "8ef00caf-c49a-44c1-97f9-392d7dd45062"); // Inventory Move
			put("DOO", "9ac1fdd2-dfb4-4da0-82c6-4193c23b6364"); // Distribution Order
		}
	};
	public CompletableFuture<MRefList_BH> ReplenishmentCreate(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReplenishmentCreate())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPLENISHMENTCREATE_UUIDS_BY_VALUE.get(entity.getReplenishmentCreate()));
	}

	public static Map<String, String> REPLENISHTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("2", "ffd6c420-3c4d-496e-9aa2-6b8233df56d8"); // Maintain Maximum Level
			put("0", "e41e99de-d51a-4bc7-b3ae-7562ba8896c4"); // Manual
			put("1", "1f3b5c0e-491a-4356-89fb-90b6cfd18252"); // Reorder below Minimum Level
			put("9", "d32a0909-824f-4d2e-a7ce-c066af987363"); // Custom
		}
	};
	public CompletableFuture<MRefList_BH> ReplenishType(X_T_Replenish entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getReplenishType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(REPLENISHTYPE_UUIDS_BY_VALUE.get(entity.getReplenishType()));
	}

}
