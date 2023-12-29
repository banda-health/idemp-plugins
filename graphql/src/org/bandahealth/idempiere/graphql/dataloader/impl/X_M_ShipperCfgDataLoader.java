package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperCfg;

/**
 * Data Loader for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperCfgDataLoader extends PODataLoader<X_M_ShipperCfg> {
	public static String M_ShipperCfg_BY_ID_DATA_LOADER = "M_ShipperCfgByIdDataLoader";
	public static String M_ShipperCfg_BY_UUID_DATA_LOADER = "M_ShipperCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperCfg_BY_UUID_DATA_LOADER;
	}
}
