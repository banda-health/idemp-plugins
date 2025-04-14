package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_NetworkDistributionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MResource;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductPlanning;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Product_PlanningResolver extends POResolver<MPPProductPlanning> implements GraphQLResolver<MPPProductPlanning> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.DATALOADER_AD_Workflow_BY_ID);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Network Distribution.
	 *
	 * @return Network Distribution
	 */
	public CompletableFuture<X_DD_NetworkDistribution> DD_NetworkDistribution(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getDD_NetworkDistribution_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_DD_NetworkDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_NetworkDistributionDataLoader.DATALOADER_DD_NetworkDistribution_BY_ID);
		return dataLoader.load(entity.getDD_NetworkDistribution_ID());
	}

	public Boolean IsCreatePlan(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isCreatePlan();
	}

	public Boolean IsMPS(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isMPS();
	}

	public Boolean IsPhantom(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isPhantom();
	}

	public Boolean IsRequiredDRP(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isRequiredDRP();
	}

	public Boolean IsRequiredMRP(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isRequiredMRP();
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MPPProductPlanning entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MWarehouse_BH> M_Warehouse(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.DATALOADER_M_Warehouse_BY_ID);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	public static Map<String, String> ORDER_POLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FOQ", "23800f29-d1b6-448a-aa21-2e4673ff6cd5"); // Fixed Order Quantity
			put("LFL", "e28144cc-6e05-4848-8b12-98d45ddc36da"); // Lot-for-Lot
			put("POQ", "15ee1e1f-267a-49fb-97c5-109589058690"); // Period Order Quantity
		}
	};
	public CompletableFuture<MRefList_BH> Order_Policy(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOrder_Policy())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ORDER_POLICY_UUIDS_BY_VALUE.get(entity.getOrder_Policy()));
	}


	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	public CompletableFuture<MUser_BH> Planner(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getPlanner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getPlanner_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(MPPProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.DATALOADER_S_Resource_BY_ID);
		return dataLoader.load(entity.getS_Resource_ID());
	}

}
