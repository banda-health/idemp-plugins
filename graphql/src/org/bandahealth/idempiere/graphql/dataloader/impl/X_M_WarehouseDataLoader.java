package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;

/**
 * Data Loader for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_WarehouseDataLoader extends PODataLoader<MWarehouse_BH> {
	public static String M_Warehouse_BY_ID_DATA_LOADER = "M_WarehouseByIdDataLoader";
	public static String M_Warehouse_BY_UUID_DATA_LOADER = "M_WarehouseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWarehouse_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Warehouse_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Warehouse_BY_UUID_DATA_LOADER;
	}
}
