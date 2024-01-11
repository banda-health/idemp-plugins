package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Replenish;

/**
 * Data Loader for T_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_ReplenishDataLoader extends PODataLoader<X_T_Replenish> {
	public static String T_Replenish_BY_ID_DATA_LOADER = "T_ReplenishByIdDataLoader";
	public static String T_Replenish_BY_UUID_DATA_LOADER = "T_ReplenishByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Replenish.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_Replenish_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_Replenish_BY_UUID_DATA_LOADER;
	}
}
