package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInventoryLine_BH;

/**
 * Data Loader for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryLineDataLoader extends PODataLoader<MInventoryLine_BH> {
	public static String M_InventoryLine_BY_ID_DATA_LOADER = "M_InventoryLineByIdDataLoader";
	public static String M_InventoryLine_BY_UUID_DATA_LOADER = "M_InventoryLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventoryLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InventoryLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InventoryLine_BY_UUID_DATA_LOADER;
	}
}
