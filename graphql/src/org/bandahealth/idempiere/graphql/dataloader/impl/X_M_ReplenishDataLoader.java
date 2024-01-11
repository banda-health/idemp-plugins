package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplenish;

/**
 * Data Loader for M_Replenish - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ReplenishDataLoader extends PODataLoader<MReplenish> {
	public static String M_Replenish_BY_ID_DATA_LOADER = "M_ReplenishByIdDataLoader";
	public static String M_Replenish_BY_UUID_DATA_LOADER = "M_ReplenishByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplenish.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Replenish_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Replenish_BY_UUID_DATA_LOADER;
	}
}
