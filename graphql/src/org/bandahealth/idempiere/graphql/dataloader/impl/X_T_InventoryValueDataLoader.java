package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_InventoryValue;

/**
 * Data Loader for T_InventoryValue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_InventoryValueDataLoader extends PODataLoader<X_T_InventoryValue> {
	public static String T_InventoryValue_BY_ID_DATA_LOADER = "T_InventoryValueByIdDataLoader";
	public static String T_InventoryValue_BY_UUID_DATA_LOADER = "T_InventoryValueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_InventoryValue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_InventoryValue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_InventoryValue_BY_UUID_DATA_LOADER;
	}
}
