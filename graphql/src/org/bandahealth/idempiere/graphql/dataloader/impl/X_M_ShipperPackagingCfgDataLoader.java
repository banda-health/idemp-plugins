package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperPackagingCfg;

/**
 * Data Loader for M_ShipperPackagingCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperPackagingCfgDataLoader extends PODataLoader<X_M_ShipperPackagingCfg> {
	public static String DATALOADER_M_ShipperPackagingCfg_BY_ID = "M_ShipperPackagingCfgByIdDataLoader";
	public static String DATALOADER_M_ShipperPackagingCfg_BY_UUID = "M_ShipperPackagingCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperPackagingCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperPackagingCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperPackagingCfg_BY_UUID;
	}
}
