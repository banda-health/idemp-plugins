package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInventory_BH;

/**
 * Data Loader for M_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryDataLoader extends PODataLoader<MInventory_BH> {
	public static String DATALOADER_M_Inventory_BY_ID = "M_InventoryByIdDataLoader";
	public static String DATALOADER_M_Inventory_BY_UUID = "M_InventoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventory_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Inventory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Inventory_BY_UUID;
	}
}
