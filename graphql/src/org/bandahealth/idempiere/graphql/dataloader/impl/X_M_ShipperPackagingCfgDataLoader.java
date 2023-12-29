package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperPackagingCfg;

/**
 * Data Loader for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShipperPackagingCfgDataLoader extends PODataLoader<X_M_ShipperPackagingCfg> {
	public static String M_ShipperPackagingCfg_BY_ID_DATA_LOADER = "M_ShipperPackagingCfgByIdDataLoader";
	public static String M_ShipperPackagingCfg_BY_UUID_DATA_LOADER = "M_ShipperPackagingCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperPackagingCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ShipperPackagingCfg_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ShipperPackagingCfg_BY_UUID_DATA_LOADER;
	}
}
