package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;

/**
 * Data Loader for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Role_WarehouseAccessDataLoader extends PODataLoader<MBHRoleWarehouseAccess> {
	public static String DATALOADER_BH_Role_WarehouseAccess_BY_ID = "BH_Role_WarehouseAccessByIdDataLoader";
	public static String DATALOADER_BH_Role_WarehouseAccess_BY_UUID = "BH_Role_WarehouseAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHRoleWarehouseAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Role_WarehouseAccess_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Role_WarehouseAccess_BY_UUID;
	}
}
