package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_NetworkDistributionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_PlanningDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MForecast;
import org.compiere.model.MForecastLine;
import org.compiere.model.MResource;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductPlanning;
import org.eevolution.model.X_DD_NetworkDistribution;
import org.eevolution.model.X_I_ProductPlanning;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_ProductPlanningResolver extends POResolver<X_I_ProductPlanning> implements GraphQLResolver<X_I_ProductPlanning> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.AD_Workflow_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Network Distribution.
	 *
	 * @return Network Distribution
	 */
	public CompletableFuture<X_DD_NetworkDistribution> DD_NetworkDistribution(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getDD_NetworkDistribution_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_DD_NetworkDistribution> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_NetworkDistributionDataLoader.DD_NetworkDistribution_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDD_NetworkDistribution_ID());
	}

	public Boolean I_IsImported(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isI_IsImported();
	}

	public Boolean IsCreatePlan(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isCreatePlan();
	}

	public Boolean IsMPS(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isMPS();
	}

	public Boolean IsPhantom(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isPhantom();
	}


	/**
	 * Get Forecast.
	 *
	 * @return Material Forecast
	 */
	public CompletableFuture<MForecast> M_Forecast(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getM_Forecast_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MForecast> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ForecastDataLoader.M_Forecast_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Forecast_ID());
	}


	/**
	 * Get Forecast Line.
	 *
	 * @return Forecast Line
	 */
	public CompletableFuture<MForecastLine> M_ForecastLine(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getM_ForecastLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MForecastLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ForecastLineDataLoader.M_ForecastLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_ForecastLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	static Map<String, String> ORDER_POLICY_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FOQ", "23800f29-d1b6-448a-aa21-2e4673ff6cd5");
			put("LFL", "e28144cc-6e05-4848-8b12-98d45ddc36da");
			put("POQ", "15ee1e1f-267a-49fb-97c5-109589058690");
		}
	};
	public CompletableFuture<MRefList_BH> Order_Policy(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOrder_Policy())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ORDER_POLICY_UUIDS_BY_VALUE.get(entity.getOrder_Policy()));
	}


	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	public CompletableFuture<MUser_BH> Planner(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getPlanner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPlanner_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.PP_Product_BOM_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}


	/**
	 * Get Product Planning.
	 *
	 * @return Product Planning
	 */
	public CompletableFuture<MPPProductPlanning> PP_Product_Planning(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_Planning_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductPlanning> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_PlanningDataLoader.PP_Product_Planning_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Product_Planning_ID());
	}

	public Boolean Processed(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.S_Resource_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_Resource_ID());
	}


	/**
	 * Get Sales Representative.
	 *
	 * @return Sales Representative or Company Agent
	 */
	public CompletableFuture<MUser_BH> SalesRep(X_I_ProductPlanning entity, DataFetchingEnvironment environment) {
		if (entity.getSalesRep_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getSalesRep_ID());
	}

}
