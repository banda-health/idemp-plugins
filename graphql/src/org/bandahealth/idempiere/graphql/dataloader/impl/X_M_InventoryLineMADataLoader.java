package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInventoryLineMA;

/**
 * Data Loader for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InventoryLineMADataLoader extends PODataLoader<MInventoryLineMA> {
	public static String M_InventoryLineMA_BY_ID_DATA_LOADER = "M_InventoryLineMAByIdDataLoader";
	public static String M_InventoryLineMA_BY_UUID_DATA_LOADER = "M_InventoryLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventoryLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InventoryLineMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InventoryLineMA_BY_UUID_DATA_LOADER;
	}
}
