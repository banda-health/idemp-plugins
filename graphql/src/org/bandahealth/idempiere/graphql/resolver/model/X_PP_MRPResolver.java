package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_DD_OrderLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ForecastLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RequisitionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RequisitionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_WarehouseDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Order_BOMLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_S_ResourceDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MForecast;
import org.compiere.model.MForecastLine;
import org.compiere.model.MRequisition;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.MResource;
import org.dataloader.DataLoader;
import org.eevolution.model.MDDOrder;
import org.eevolution.model.MDDOrderLine;
import org.eevolution.model.X_PP_MRP;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_BOMLine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_MRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_MRPResolver extends POResolver<X_PP_MRP> implements GraphQLResolver<X_PP_MRP> {



	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.C_BPartner_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_BPartner_ID());
	}


	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public CompletableFuture<MOrder_BH> C_Order(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getC_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.C_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Order_ID());
	}


	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	public CompletableFuture<MOrderLine_BH> C_OrderLine(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getC_OrderLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MOrderLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderLineDataLoader.C_OrderLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_OrderLine_ID());
	}


	/**
	 * Get Distribution Order.
	 *
	 * @return Distribution Order
	 */
	public CompletableFuture<MDDOrder> DD_Order(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getDD_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDDOrder> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_OrderDataLoader.DD_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDD_Order_ID());
	}


	/**
	 * Get Distribution Order Line.
	 *
	 * @return Distribution Order Line
	 */
	public CompletableFuture<MDDOrderLine> DD_OrderLine(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getDD_OrderLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MDDOrderLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_DD_OrderLineDataLoader.DD_OrderLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getDD_OrderLine_ID());
	}

	static Map<String, String> DOCSTATUS_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("DR", "d27f8a6b-e8b5-4fea-a6b2-3e7049c473ec");
			put("CO", "50702660-bbfc-422a-8acc-5ed3a2dce204");
			put("AP", "a838dad1-b7fc-4b26-9d80-d45f2d8484c5");
			put("NA", "c8c414ee-3e4e-480b-aa0e-bc6c1d100bd2");
			put("VO", "d35dfd1d-1eb2-46ef-ab2f-23973d68a570");
			put("IN", "c2d506ba-1916-4ca2-abde-da3127c11d77");
			put("RE", "029a78cf-d45c-4fb2-a6c9-fb92c2311af6");
			put("CL", "ab9df095-8aa8-4338-98b6-4b09ab9d459e");
			put("??", "0b6ed143-fad9-4ba2-824c-b3a89b9bb2d2");
			put("IP", "9f864275-6135-452f-a5a7-9377d9ed32bc");
			put("WP", "4a9871d9-ec70-489f-aca5-05adb7e61df9");
			put("WC", "56264c44-b530-4a53-b07b-6fb203ff61a6");
		}
	};
	public CompletableFuture<MRefList_BH> DocStatus(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getDocStatus())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(DOCSTATUS_UUIDS_BY_VALUE.get(entity.getDocStatus()));
	}

	public Boolean IsAvailable(X_PP_MRP entity, DataFetchingEnvironment environment) {
		return entity.isAvailable();
	}


	/**
	 * Get Forecast.
	 *
	 * @return Material Forecast
	 */
	public CompletableFuture<MForecast> M_Forecast(X_PP_MRP entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MForecastLine> M_ForecastLine(X_PP_MRP entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MProduct_BH> M_Product(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Requisition.
	 *
	 * @return Material Requisition
	 */
	public CompletableFuture<MRequisition> M_Requisition(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getM_Requisition_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequisition> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RequisitionDataLoader.M_Requisition_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Requisition_ID());
	}


	/**
	 * Get Requisition Line.
	 *
	 * @return Material Requisition Line
	 */
	public CompletableFuture<MRequisitionLine> M_RequisitionLine(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getM_RequisitionLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MRequisitionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_RequisitionLineDataLoader.M_RequisitionLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_RequisitionLine_ID());
	}


	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	public CompletableFuture<MWarehouse_BH> M_Warehouse(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getM_Warehouse_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MWarehouse_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_WarehouseDataLoader.M_Warehouse_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Warehouse_ID());
	}

	static Map<String, String> ORDERTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("FCT", "89fc8a10-ca1e-4d83-9bc8-3f2cbde3479c");
			put("MOP", "71a77f9c-7c20-4e99-af37-26b10c8fa482");
			put("POO", "fe0b9a43-5c0d-4032-b287-cb83b570896a");
			put("POR", "c14bf0e3-cfdc-4628-a11d-a1d06e5c88ad");
			put("SOO", "b002cd70-86c6-496a-9002-ec9fbe1d043e");
			put("DOO", "4dccb229-24a2-497f-a613-51cea968d0ba");
			put("STK", "3a805770-c160-4ee9-aab1-c6f7ca119cd1");
		}
	};
	public CompletableFuture<MRefList_BH> OrderType(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getOrderType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(ORDERTYPE_UUIDS_BY_VALUE.get(entity.getOrderType()));
	}


	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	public CompletableFuture<MUser_BH> Planner(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getPlanner_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.AD_User_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPlanner_ID());
	}


	/**
	 * Get Manufacturing Order BOM Line.
	 *
	 * @return Manufacturing Order BOM Line
	 */
	public CompletableFuture<X_PP_Order_BOMLine> PP_Order_BOMLine(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_BOMLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order_BOMLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Order_BOMLineDataLoader.PP_Order_BOMLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_BOMLine_ID());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.PP_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_ID());
	}


	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	public CompletableFuture<MResource> S_Resource(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (entity.getS_Resource_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MResource> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_S_ResourceDataLoader.S_Resource_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getS_Resource_ID());
	}

	static Map<String, String> TYPEMRP_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "1c236b83-d0f3-4b27-b3f0-3aa9ddb1e306");
			put("S", "18210d24-3d48-4a9a-aa82-1401ba94304a");
		}
	};
	public CompletableFuture<MRefList_BH> TypeMRP(X_PP_MRP entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getTypeMRP())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(TYPEMRP_UUIDS_BY_VALUE.get(entity.getTypeMRP()));
	}

}
