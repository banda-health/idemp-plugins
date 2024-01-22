package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.X_BH_Stocktake_v;

/**
 * Data Loader for BH_Stocktake_v - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Stocktake_vDataLoader extends PODataLoader<X_BH_Stocktake_v> {
	public static String DATALOADER_BH_Stocktake_v_BY_ID = "BH_Stocktake_vByIdDataLoader";
	public static String DATALOADER_BH_Stocktake_v_BY_UUID = "BH_Stocktake_vByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_BH_Stocktake_v.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Stocktake_v_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Stocktake_v_BY_UUID;
	}
}
