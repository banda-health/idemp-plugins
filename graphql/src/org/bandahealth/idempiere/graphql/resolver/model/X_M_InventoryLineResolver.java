package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MAttributeSetInstance_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MInventoryLine_BH;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_ListDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_ChargeDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_AttributeSetInstanceDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_InventoryLineDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_LocatorDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.utils.StringUtil;
import org.compiere.model.MInventory;
import org.compiere.model.MLocator;
import org.dataloader.DataLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryLineResolver extends POResolver<MInventoryLine_BH> implements GraphQLResolver<MInventoryLine_BH> {


	public Boolean BH_RequiresExpiration(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_RequiresExpiration();
	}


	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public CompletableFuture<MCharge_BH> C_Charge(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getC_Charge_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MCharge_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_ChargeDataLoader.C_Charge_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getC_Charge_ID());
	}

	static Map<String, String> INVENTORYTYPE_UUIDS_BY_VALUE = new HashMap<>() {
		{
			put("D", "00dad9c4-c001-4ce1-b5df-b0e6709492f4");
			put("C", "3159e11b-bc67-450f-960f-93b2dc5f0c31");
		}
	};
	public CompletableFuture<MRefList_BH> InventoryType(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (StringUtil.isNullOrEmpty(entity.getInventoryType())) {
			return null;
		}
		DataLoader<String, MRefList_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_Ref_ListDataLoader.AD_Ref_List_BY_UUID_DATA_LOADER);
		return dataLoader.load(INVENTORYTYPE_UUIDS_BY_VALUE.get(entity.getInventoryType()));
	}


	/**
	 * Get Attribute Set Instance.
	 *
	 * @return Product Attribute Set Instance
	 */
	public CompletableFuture<MAttributeSetInstance_BH> M_AttributeSetInstance(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_AttributeSetInstance_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MAttributeSetInstance_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_AttributeSetInstanceDataLoader.M_AttributeSetInstance_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_AttributeSetInstance_ID());
	}


	/**
	 * Get Phys.Inventory.
	 *
	 * @return Parameters for a Physical Inventory
	 */
	public CompletableFuture<MInventory> M_Inventory(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Inventory_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInventory> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryDataLoader.M_Inventory_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Inventory_ID());
	}


	/**
	 * Get Locator.
	 *
	 * @return Warehouse Locator
	 */
	public CompletableFuture<MLocator> M_Locator(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Locator_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MLocator> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_LocatorDataLoader.M_Locator_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Locator_ID());
	}


	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	public CompletableFuture<MProduct_BH> M_Product(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getM_Product_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MProduct_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_ProductDataLoader.M_Product_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getM_Product_ID());
	}

	public Boolean Processed(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}


	/**
	 * Get Reversal Line.
	 *
	 * @return Use to keep the reversal line ID for reversing costing purpose
	 */
	public CompletableFuture<MInventoryLine_BH> ReversalLine(MInventoryLine_BH entity, DataFetchingEnvironment environment) {
		if (entity.getReversalLine_ID() <= 0) {
			return null;
		}
		DataLoader<Integer, MInventoryLine_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_M_InventoryLineDataLoader.M_InventoryLine_BY_ID_DATA_LOADER);
		return dataLoader.load(entity.getReversalLine_ID());
	}

}
