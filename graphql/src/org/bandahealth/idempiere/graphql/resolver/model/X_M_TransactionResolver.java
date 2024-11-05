package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Cost_CollectorDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MLocator;
import org.compiere.model.MMovementLine;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MTransaction;
import org.dataloader.DataLoader;
import org.eevolution.model.X_PP_Cost_Collector;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_TransactionResolver extends POResolver<MTransaction> implements GraphQLResolver<MTransaction> {



	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	public CompletableFuture<MProjectIssue> C_ProjectIssue(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectIssue_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProjectIssue> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectIssueDataLoader.DATALOADER_C_ProjectIssue_BY_ID);
		return dataLoader.load(entity.getC_ProjectIssue_ID());
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	public CompletableFuture<MInventoryLine> M_InventoryLine(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInventoryLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_ID);
		return dataLoader.load(entity.getM_InventoryLine_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	public CompletableFuture<MMovementLine> M_MovementLine(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_MovementLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MMovementLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementLineDataLoader.DATALOADER_M_MovementLine_BY_ID);
		return dataLoader.load(entity.getM_MovementLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Production Line.
	 *
	 * @return Document Line representing a production
	 */
	public CompletableFuture<MProductionLine> M_ProductionLine(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductionLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_ID);
		return dataLoader.load(entity.getM_ProductionLine_ID());
	}

	public static Map<String, String> MOVEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C-", "00fd790c-e7d8-4399-8407-ce735e91a3a8"); // Customer Shipment
			put("C+", "65a33af1-d135-4c2d-980c-2c299cb0bb1c"); // Customer Returns
			put("V+", "edfd62f3-f88e-4efe-a2cd-6e24452bf30e"); // Vendor Receipts
			put("V-", "1be42e0f-3096-4796-9c70-d6e40de09a06"); // Vendor Returns
			put("I-", "76be392a-c953-4d09-9ee7-d688dd3fda7d"); // Inventory Out
			put("I+", "ec8fde60-8853-46dc-ab07-2208e7c309c0"); // Inventory In
			put("M-", "eafaee32-9f7a-439b-89d6-3470367fc02b"); // Movement From
			put("M+", "fb18d31f-977e-4b86-9516-84bbb420d830"); // Movement To
			put("P+", "1d7891c4-ff13-46f4-8c9c-c07ae46c214c"); // Production +
			put("P-", "0ae07aaa-5d4a-4cea-9151-cbdf38f3c8e6"); // Production -
			put("W+", "251b4cb0-7d98-4183-9114-6784d48359da"); // Work Order +
			put("W-", "aca9152b-34cb-44fa-8a5b-d519dd804637"); // Work Order -
		}
	};
	public CompletableFuture<MRefList_BH> MovementType(MTransaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMovementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MOVEMENTTYPE_UUIDS_BY_VALUE.get(entity.getMovementType()));
	}


	/**
	 * Get Manufacturing Cost Collector.
	 *
	 * @return Manufacturing Cost Collector
	 */
	public CompletableFuture<X_PP_Cost_Collector> PP_Cost_Collector(MTransaction entity, DataFetchingEnvironment environment) {
		if (entity.getPP_Cost_Collector_ID() < 1) {
			return null;
		}
		DataLoader<Integer, X_PP_Cost_Collector> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_PP_Cost_CollectorDataLoader.DATALOADER_PP_Cost_Collector_BY_ID);
		return dataLoader.load(entity.getPP_Cost_Collector_ID());
	}

}
