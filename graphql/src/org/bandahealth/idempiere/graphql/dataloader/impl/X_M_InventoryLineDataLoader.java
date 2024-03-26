package org.bandahealth.idempiere.graphql.dataloader.impl;

/**
 * Data Loader for M_InventoryLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InventoryLineDataLoader extends PODataLoader<MInventoryLine_BH> {
	public static String DATALOADER_M_InventoryLine_BY_ID = "M_InventoryLineByIdDataLoader";
	public static String DATALOADER_M_InventoryLine_BY_UUID = "M_InventoryLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventoryLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InventoryLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InventoryLine_BY_UUID;
	}
}
