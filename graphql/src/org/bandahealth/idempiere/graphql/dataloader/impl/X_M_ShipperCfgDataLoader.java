package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperCfg;

/**
 * Data Loader for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperCfgDataLoader extends PODataLoader<X_M_ShipperCfg> {
	public static String DATALOADER_M_ShipperCfg_BY_ID = "M_ShipperCfgByIdDataLoader";
	public static String DATALOADER_M_ShipperCfg_BY_UUID = "M_ShipperCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperCfg_BY_UUID;
	}
}
