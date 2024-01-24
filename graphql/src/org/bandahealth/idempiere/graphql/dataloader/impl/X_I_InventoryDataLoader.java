package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Inventory;

/**
 * Data Loader for I_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_InventoryDataLoader extends PODataLoader<X_I_Inventory> {
	public static String DATALOADER_I_Inventory_BY_ID = "I_InventoryByIdDataLoader";
	public static String DATALOADER_I_Inventory_BY_UUID = "I_InventoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Inventory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Inventory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Inventory_BY_UUID;
	}
}
