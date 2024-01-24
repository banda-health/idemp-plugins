package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInventoryLineMA;

/**
 * Data Loader for M_InventoryLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InventoryLineMADataLoader extends PODataLoader<MInventoryLineMA> {
	public static String DATALOADER_M_InventoryLineMA_BY_ID = "M_InventoryLineMAByIdDataLoader";
	public static String DATALOADER_M_InventoryLineMA_BY_UUID = "M_InventoryLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInventoryLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InventoryLineMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InventoryLineMA_BY_UUID;
	}
}
