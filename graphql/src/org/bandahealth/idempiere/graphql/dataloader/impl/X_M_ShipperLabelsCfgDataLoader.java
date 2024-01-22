package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_ShipperLabelsCfg;

/**
 * Data Loader for M_ShipperLabelsCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ShipperLabelsCfgDataLoader extends PODataLoader<X_M_ShipperLabelsCfg> {
	public static String DATALOADER_M_ShipperLabelsCfg_BY_ID = "M_ShipperLabelsCfgByIdDataLoader";
	public static String DATALOADER_M_ShipperLabelsCfg_BY_UUID = "M_ShipperLabelsCfgByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_ShipperLabelsCfg.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ShipperLabelsCfg_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ShipperLabelsCfg_BY_UUID;
	}
}
