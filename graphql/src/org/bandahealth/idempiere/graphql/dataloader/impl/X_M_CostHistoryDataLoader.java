package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_CostHistory;

/**
 * Data Loader for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_CostHistoryDataLoader extends PODataLoader<X_M_CostHistory> {
	public static String M_CostHistory_BY_ID_DATA_LOADER = "M_CostHistoryByIdDataLoader";
	public static String M_CostHistory_BY_UUID_DATA_LOADER = "M_CostHistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_CostHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_CostHistory_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_CostHistory_BY_UUID_DATA_LOADER;
	}
}
