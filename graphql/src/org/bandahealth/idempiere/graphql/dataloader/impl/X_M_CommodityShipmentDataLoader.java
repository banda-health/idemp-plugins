package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_CommodityShipment;

/**
 * Data Loader for M_CommodityShipment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CommodityShipmentDataLoader extends PODataLoader<X_M_CommodityShipment> {
	public static String M_CommodityShipment_BY_ID_DATA_LOADER = "M_CommodityShipmentByIdDataLoader";
	public static String M_CommodityShipment_BY_UUID_DATA_LOADER = "M_CommodityShipmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_CommodityShipment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CommodityShipment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CommodityShipment_BY_UUID_DATA_LOADER;
	}
}
