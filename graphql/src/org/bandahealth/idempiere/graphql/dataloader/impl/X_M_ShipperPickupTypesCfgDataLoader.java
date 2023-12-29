package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperPickupTypesCfg;

/**
 * Data Loader for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesCfgDataLoader extends PODataLoader<X_M_ShipperPickupTypesCfg> {
	public static String M_ShipperPickupTypesCfg_BY_ID_DATA_LOADER = "M_ShipperPickupTypesCfgByIdDataLoader";
	public static String M_ShipperPickupTypesCfg_BY_UUID_DATA_LOADER = "M_ShipperPickupTypesCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperPickupTypesCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperPickupTypesCfg_BY_UUID_DATA_LOADER;
	}
}
