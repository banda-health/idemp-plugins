package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecurringRun;

/**
 * Data Loader for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Recurring_RunDataLoader extends PODataLoader<MRecurringRun> {
	public static String C_Recurring_Run_BY_ID_DATA_LOADER = "C_Recurring_RunByIdDataLoader";
	public static String C_Recurring_Run_BY_UUID_DATA_LOADER = "C_Recurring_RunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecurringRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Recurring_Run_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Recurring_Run_BY_UUID_DATA_LOADER;
	}
}
