package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MWarehouse_BH;

/**
 * Data Loader for M_Warehouse - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_WarehouseDataLoader extends PODataLoader<MWarehouse_BH> {
	public static String DATALOADER_M_Warehouse_BY_ID = "M_WarehouseByIdDataLoader";
	public static String DATALOADER_M_Warehouse_BY_UUID = "M_WarehouseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWarehouse_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Warehouse_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Warehouse_BY_UUID;
	}
}
