package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.bandahealth.idempiere.base.model.MInventory_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MMovement_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_PInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_InvoiceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_OrderDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ProjectIssueDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_MovementLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_TransactionDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MLocator;
import org.compiere.model.MMovementLine;
import org.compiere.model.MPInstance;
import org.compiere.model.MProduction;
import org.compiere.model.MProductionLine;
import org.compiere.model.MProject;
import org.compiere.model.MProjectIssue;
import org.compiere.model.MTransaction;
import org.compiere.model.X_T_Transaction;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for T_Transaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_TransactionResolver extends POResolver<X_T_Transaction> implements GraphQLResolver<X_T_Transaction> {



	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	public CompletableFuture<MPInstance> AD_PInstance(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getAD_PInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MPInstance> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_PInstanceDataLoader.DATALOADER_AD_PInstance_BY_ID);
		return dataLoader.load(entity.getAD_PInstance_ID());
	}


	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public CompletableFuture<MProject> C_Project(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_Project_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProject> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ProjectDataLoader.DATALOADER_C_Project_BY_ID);
		return dataLoader.load(entity.getC_Project_ID());
	}


	/**
	 * Get Project Issue.
	 *
	 * @return Project Issues (Material, Labor)
	 */
	public CompletableFuture<MProjectIssue> C_ProjectIssue(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getC_ProjectIssue_ID() < 0) {
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
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.DATALOADER_M_AttributeSetInstance_BY_ID);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOut_BH> M_InOut(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOut_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInOut_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutDataLoader.DATALOADER_M_InOut_BY_ID);
		return dataLoader.load(entity.getM_InOut_ID());
	}


	/**
	 * Get Shipment/Receipt Line.
	 *
	 * @return Line on Shipment or Receipt document
	 */
	public CompletableFuture<MInOutLine> M_InOutLine(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InOutLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getM_InOutLine_ID());
	}


	/**
	 * Get Phys.Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	public CompletableFuture<MInventory_BH> M_Inventory(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Inventory_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInventory_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryDataLoader.DATALOADER_M_Inventory_BY_ID);
		return dataLoader.load(entity.getM_Inventory_ID());
	}


	/**
	 * Get Phys.Inventory Line.
	 *
	 * @return Unique line in an Inventory document
	 */
	public CompletableFuture<MInventoryLine> M_InventoryLine(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() < 0) {
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
	public CompletableFuture<MLocator> M_Locator(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.DATALOADER_M_Locator_BY_ID);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Inventory Move.
	 *
	 * @return Movement of Inventory
	 */
	public CompletableFuture<MMovement_BH> M_Movement(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Movement_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MMovement_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_MovementDataLoader.DATALOADER_M_Movement_BY_ID);
		return dataLoader.load(entity.getM_Movement_ID());
	}


	/**
	 * Get Move Line.
	 *
	 * @return Inventory Move document Line
	 */
	public CompletableFuture<MMovementLine> M_MovementLine(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_MovementLine_ID() < 0) {
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
	public CompletableFuture<MProduct_BH> M_Product(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_ID);
		return dataLoader.load(entity.getM_Product_ID());
	}


	/**
	 * Get Production.
	 *
	 * @return Plan for producing a product
	 */
	public CompletableFuture<MProduction> M_Production(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Production_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProduction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionDataLoader.DATALOADER_M_Production_BY_ID);
		return dataLoader.load(entity.getM_Production_ID());
	}


	/**
	 * Get Production Line.
	 *
	 * @return Document Line representing a production
	 */
	public CompletableFuture<MProductionLine> M_ProductionLine(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductionLine_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MProductionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_ID);
		return dataLoader.load(entity.getM_ProductionLine_ID());
	}


	/**
	 * Get Inventory Transaction.
	 *
	 * @return Inventory Transaction
	 */
	public CompletableFuture<MTransaction> M_Transaction(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getM_Transaction_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_TransactionDataLoader.DATALOADER_M_Transaction_BY_ID);
		return dataLoader.load(entity.getM_Transaction_ID());
	}

	static Map<String, String> MOVEMENTTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("C-", "00fd790c-e7d8-4399-8407-ce735e91a3a8");
			put("C+", "65a33af1-d135-4c2d-980c-2c299cb0bb1c");
			put("V+", "edfd62f3-f88e-4efe-a2cd-6e24452bf30e");
			put("V-", "1be42e0f-3096-4796-9c70-d6e40de09a06");
			put("I-", "76be392a-c953-4d09-9ee7-d688dd3fda7d");
			put("I+", "ec8fde60-8853-46dc-ab07-2208e7c309c0");
			put("M-", "eafaee32-9f7a-439b-89d6-3470367fc02b");
			put("M+", "fb18d31f-977e-4b86-9516-84bbb420d830");
			put("P+", "1d7891c4-ff13-46f4-8c9c-c07ae46c214c");
			put("P-", "0ae07aaa-5d4a-4cea-9151-cbdf38f3c8e6");
			put("W+", "251b4cb0-7d98-4183-9114-6784d48359da");
			put("W-", "aca9152b-34cb-44fa-8a5b-d519dd804637");
		}
	};
	public CompletableFuture<MRefList_BH> MovementType(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getMovementType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(MOVEMENTTYPE_UUIDS_BY_VALUE.get(entity.getMovementType()));
	}


	/**
	 * Get Search Shipment/Receipt.
	 *
	 * @return Material Shipment Document
	 */
	public CompletableFuture<MInOutLine> Search_InOut(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getSearch_InOut_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getSearch_InOut_ID());
	}


	/**
	 * Get Search Invoice.
	 *
	 * @return Search Invoice Identifier
	 */
	public CompletableFuture<MInvoice_BH> Search_Invoice(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getSearch_Invoice_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MInvoice_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_InvoiceDataLoader.DATALOADER_C_Invoice_BY_ID);
		return dataLoader.load(entity.getSearch_Invoice_ID());
	}


	/**
	 * Get Search Order.
	 *
	 * @return Order Identifier
	 */
	public CompletableFuture<MOrder_BH> Search_Order(X_T_Transaction entity, DataFetchingEnvironment environment) {
		if (entity.getSearch_Order_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MOrder_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_OrderDataLoader.DATALOADER_C_Order_BY_ID);
		return dataLoader.load(entity.getSearch_Order_ID());
	}

}
