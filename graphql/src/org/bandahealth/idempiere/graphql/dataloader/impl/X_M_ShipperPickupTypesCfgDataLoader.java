package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperPickupTypesCfg;

/**
 * Data Loader for M_ShipperPickupTypesCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPickupTypesCfgDataLoader extends PODataLoader<X_M_ShipperPickupTypesCfg> {
	public static String DATALOADER_M_ShipperPickupTypesCfg_BY_ID = "M_ShipperPickupTypesCfgByIdDataLoader";
	public static String DATALOADER_M_ShipperPickupTypesCfg_BY_UUID = "M_ShipperPickupTypesCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperPickupTypesCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperPickupTypesCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperPickupTypesCfg_BY_UUID;
	}
}
