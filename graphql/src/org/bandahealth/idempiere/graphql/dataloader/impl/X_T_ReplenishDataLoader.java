package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_Replenish;

/**
 * Data Loader for T_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_ReplenishDataLoader extends PODataLoader<X_T_Replenish> {
	public static String DATALOADER_T_Replenish_BY_ID = "T_ReplenishByIdDataLoader";
	public static String DATALOADER_T_Replenish_BY_UUID = "T_ReplenishByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_Replenish.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_Replenish_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_Replenish_BY_UUID;
	}
}
