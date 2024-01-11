package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWarehousePrice;

/**
 * Data Loader for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_WarehousePriceDataLoader extends PODataLoader<MWarehousePrice> {
	public static String RV_WarehousePrice_BY_ID_DATA_LOADER = "RV_WarehousePriceByIdDataLoader";
	public static String RV_WarehousePrice_BY_UUID_DATA_LOADER = "RV_WarehousePriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWarehousePrice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return RV_WarehousePrice_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return RV_WarehousePrice_BY_UUID_DATA_LOADER;
	}
}
