package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_CommodityShipment;

/**
 * Data Loader for M_CommodityShipment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CommodityShipmentDataLoader extends PODataLoader<X_M_CommodityShipment> {
	public static String DATALOADER_M_CommodityShipment_BY_ID = "M_CommodityShipmentByIdDataLoader";
	public static String DATALOADER_M_CommodityShipment_BY_UUID = "M_CommodityShipmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_CommodityShipment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CommodityShipment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CommodityShipment_BY_UUID;
	}
}
