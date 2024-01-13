package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_InventoryValue;

/**
 * Data Loader for T_InventoryValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_InventoryValueDataLoader extends PODataLoader<X_T_InventoryValue> {
	public static String DATALOADER_T_InventoryValue_BY_ID = "T_InventoryValueByIdDataLoader";
	public static String DATALOADER_T_InventoryValue_BY_UUID = "T_InventoryValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_InventoryValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_InventoryValue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_InventoryValue_BY_UUID;
	}
}
