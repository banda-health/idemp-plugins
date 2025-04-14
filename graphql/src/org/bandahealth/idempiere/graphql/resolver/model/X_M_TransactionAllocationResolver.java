package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InOutLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_TransactionDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInventoryLine;
import org.compiere.model.MProductionLine;
import org.compiere.model.MTransaction;
import org.compiere.model.X_M_TransactionAllocation;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_TransactionAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_TransactionAllocationResolver extends POResolver<X_M_TransactionAllocation> implements GraphQLResolver<X_M_TransactionAllocation> {


	public static Map<String, String> ALLOCATIONSTRATEGYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("L", "e717816c-9a66-4eea-b14e-34662cb43fd0"); // LiFo
			put("F", "f9fbe7ec-09e3-43a6-a438-4ec5778ee496"); // FiFo
		}
	};
	public CompletableFuture<MRefList_BH> AllocationStrategyType(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getAllocationStrategyType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.DATALOADER_AD_Ref_List_BY_UUID);
		return dataLoader.load(ALLOCATIONSTRATEGYTYPE_UUIDS_BY_VALUE.get(entity.getAllocationStrategyType()));
	}

	public Boolean IsAllocated(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		return entity.isAllocated();
	}

	public Boolean IsManual(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		return entity.isManual();
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MInOutLine> M_InOutLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MInventoryLine> M_InventoryLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getM_InventoryLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInventoryLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_ID);
		return dataLoader.load(entity.getM_InventoryLine_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
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
	public CompletableFuture<MProductionLine> M_ProductionLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getM_ProductionLine_ID() < 1) {
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
	public CompletableFuture<MTransaction> M_Transaction(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getM_Transaction_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_TransactionDataLoader.DATALOADER_M_Transaction_BY_ID);
		return dataLoader.load(entity.getM_Transaction_ID());
	}


	/**
	 * Get Out Shipment Line.
	 *
	 * @return Outgoing Shipment/Receipt
	 */
	public CompletableFuture<MInOutLine> Out_M_InOutLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getOut_M_InOutLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInOutLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InOutLineDataLoader.DATALOADER_M_InOutLine_BY_ID);
		return dataLoader.load(entity.getOut_M_InOutLine_ID());
	}


	/**
	 * Get Out Inventory Line.
	 *
	 * @return Outgoing Inventory Line
	 */
	public CompletableFuture<MInventoryLine> Out_M_InventoryLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getOut_M_InventoryLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MInventoryLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.DATALOADER_M_InventoryLine_BY_ID);
		return dataLoader.load(entity.getOut_M_InventoryLine_ID());
	}


	/**
	 * Get Out Production Line.
	 *
	 * @return Outgoing Production Line
	 */
	public CompletableFuture<MProductionLine> Out_M_ProductionLine(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getOut_M_ProductionLine_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MProductionLine> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductionLineDataLoader.DATALOADER_M_ProductionLine_BY_ID);
		return dataLoader.load(entity.getOut_M_ProductionLine_ID());
	}


	/**
	 * Get Out Transaction.
	 *
	 * @return Outgoing Transaction
	 */
	public CompletableFuture<MTransaction> Out_M_Transaction(X_M_TransactionAllocation entity, DataFetchingEnvironment environment) {
		if (entity.getOut_M_Transaction_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MTransaction> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_TransactionDataLoader.DATALOADER_M_Transaction_BY_ID);
		return dataLoader.load(entity.getOut_M_Transaction_ID());
	}

}
