package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_CostHistory;

/**
 * Data Loader for M_CostHistory - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_CostHistoryDataLoader extends PODataLoader<X_M_CostHistory> {
	public static String DATALOADER_M_CostHistory_BY_ID = "M_CostHistoryByIdDataLoader";
	public static String DATALOADER_M_CostHistory_BY_UUID = "M_CostHistoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_CostHistory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CostHistory_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CostHistory_BY_UUID;
	}
}
