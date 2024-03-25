package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplenish;

/**
 * Data Loader for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ReplenishDataLoader extends PODataLoader<MReplenish> {
	public static String DATALOADER_M_Replenish_BY_ID = "M_ReplenishByIdDataLoader";
	public static String DATALOADER_M_Replenish_BY_UUID = "M_ReplenishByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplenish.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Replenish_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Replenish_BY_UUID;
	}
}
