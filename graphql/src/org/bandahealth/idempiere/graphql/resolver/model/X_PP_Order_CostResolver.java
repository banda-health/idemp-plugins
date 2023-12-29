package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_WorkflowDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_OrderDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostType;
import org.compiere.model.MRefList;
import org.compiere.model.X_AD_Workflow;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Order;
import org.eevolution.model.X_PP_Order_Cost;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_CostResolver extends POResolver<X_PP_Order_Cost> implements GraphQLResolver<X_PP_Order_Cost> {



	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	public CompletableFuture<X_AD_Workflow> AD_Workflow(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Workflow_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_AD_Workflow> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_WorkflowDataLoader.AD_Workflow_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getAD_Workflow_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.C_AcctSchema_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_AcctSchema_ID());
	}

	static Map<String, String> COSTINGMETHOD_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("S", "d3ba6803-5479-4b30-ba20-6b40e658c5d8");
			put("A", "29b356c5-1757-4bab-a331-a01b9415f4e6");
			put("L", "fb47834b-767e-4ffe-b7ea-f690279d4345");
			put("F", "835a19ab-521e-406c-b0b2-f3e4c64c44b7");
			put("p", "01741faf-094c-46ed-9266-2d3adac2c504");
			put("I", "9127a623-4d9b-4a1a-8462-b31d8ddb24ed");
			put("i", "f4296d4f-761c-4545-a2ec-ca5c86e1b741");
			put("U", "10ca122c-b77e-410e-8755-5033f17405d4");
			put("x", "c788f7ef-7cf6-479e-85fc-7212ae0a9f9b");
		}
	};
	public CompletableFuture<MRefList> CostingMethod_RL(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public CompletableFuture<MCostElement> M_CostElement(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostElement_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostElementDataLoader.M_CostElement_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_CostElement_ID());
	}


	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public CompletableFuture<MCostType> M_CostType(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostTypeDataLoader.M_CostType_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_CostType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Manufacturing Order.
	 *
	 * @return Manufacturing Order
	 */
	public CompletableFuture<X_PP_Order> PP_Order(X_PP_Order_Cost entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Order_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, X_PP_Order> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_OrderDataLoader.PP_Order_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getPP_Order_ID());
	}

}
