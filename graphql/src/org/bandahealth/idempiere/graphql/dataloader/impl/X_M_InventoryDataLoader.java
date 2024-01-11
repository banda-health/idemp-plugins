package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInventory_BH;

/**
 * Data Loader for M_Inventory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryDataLoader extends PODataLoader<MInventory_BH> {
	public static String M_Inventory_BY_ID_DATA_LOADER = "M_InventoryByIdDataLoader";
	public static String M_Inventory_BY_UUID_DATA_LOADER = "M_InventoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventory_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Inventory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Inventory_BY_UUID_DATA_LOADER;
	}
}
