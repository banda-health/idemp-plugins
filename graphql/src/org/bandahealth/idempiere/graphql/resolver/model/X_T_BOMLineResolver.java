package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AcctSchemaDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostTypeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMLineDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostElement;
import org.compiere.model.MCostType;
import org.compiere.model.MPInstance;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;
import org.eevolution.model.X_T_BOMLine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BOMLineResolver extends POResolver<X_T_BOMLine> implements GraphQLResolver<X_T_BOMLine> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public CompletableFuture<MAcctSchema> C_AcctSchema(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getC_AcctSchema_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAcctSchema> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_AcctSchemaDataLoader.DATALOADER_C_AcctSchema_BY_ID);
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
	public CompletableFuture<MRefList_BH> CostingMethod(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getCostingMethod())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_ID);
		return dataLoader.load(COSTINGMETHOD_UUIDS_BY_VALUE.get(entity.getCostingMethod()));
	}

	public Boolean Implosion(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		return entity.isImplosion();
	}

	public Boolean IsCostFrozen(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		return entity.isCostFrozen();
	}


	/**
	 * Get Cost Element.
	 *
	 * @return Product Cost Element
	 */
	public CompletableFuture<MCostElement> M_CostElement(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostElement_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostElement> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostElementDataLoader.DATALOADER_M_CostElement_BY_ID);
		return dataLoader.load(entity.getM_CostElement_ID());
	}


	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public CompletableFuture<MCostType> M_CostType(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_CostType_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCostType> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_CostTypeDataLoader.DATALOADER_M_CostType_BY_ID);
		return dataLoader.load(entity.getM_CostType_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	public CompletableFuture<MPPProductBOM> PP_Product_BOM(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOM_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductBOM> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOM_ID());
	}


	/**
	 * Get BOM Line.
	 *
	 * @return BOM Line
	 */
	public CompletableFuture<MPPProductBOMLine> PP_Product_BOMLine(X_T_BOMLine entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Product_BOMLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MPPProductBOMLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Product_BOMLineDataLoader.DATALOADER_PP_Product_BOMLine_BY_ID);
		return dataLoader.load(entity.getPP_Product_BOMLine_ID());
	}

}
