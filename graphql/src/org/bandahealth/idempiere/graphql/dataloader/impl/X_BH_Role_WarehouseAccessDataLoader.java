package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHRoleWarehouseAccess;

/**
 * Data Loader for BH_Role_WarehouseAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_Role_WarehouseAccessDataLoader extends PODataLoader<MBHRoleWarehouseAccess> {
	public static String BH_Role_WarehouseAccess_BY_ID_DATA_LOADER = "BH_Role_WarehouseAccessByIdDataLoader";
	public static String BH_Role_WarehouseAccess_BY_UUID_DATA_LOADER = "BH_Role_WarehouseAccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHRoleWarehouseAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return BH_Role_WarehouseAccess_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return BH_Role_WarehouseAccess_BY_UUID_DATA_LOADER;
	}
}
