package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHWarehouseAccess;

/**
 * Data Loader for BH_Warehouse_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Warehouse_AccessDataLoader extends PODataLoader<MBHWarehouseAccess> {
	public static String DATALOADER_BH_Warehouse_Access_BY_ID = "BH_Warehouse_AccessByIdDataLoader";
	public static String DATALOADER_BH_Warehouse_Access_BY_UUID = "BH_Warehouse_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHWarehouseAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Warehouse_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Warehouse_Access_BY_UUID;
	}
}
