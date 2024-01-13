package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWarehousePrice;

/**
 * Data Loader for RV_WarehousePrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_RV_WarehousePriceDataLoader extends PODataLoader<MWarehousePrice> {
	public static String DATALOADER_RV_WarehousePrice_BY_ID = "RV_WarehousePriceByIdDataLoader";
	public static String DATALOADER_RV_WarehousePrice_BY_UUID = "RV_WarehousePriceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWarehousePrice.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_RV_WarehousePrice_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_RV_WarehousePrice_BY_UUID;
	}
}
