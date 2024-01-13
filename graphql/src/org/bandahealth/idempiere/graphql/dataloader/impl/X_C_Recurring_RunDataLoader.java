package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecurringRun;

/**
 * Data Loader for C_Recurring_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Recurring_RunDataLoader extends PODataLoader<MRecurringRun> {
	public static String DATALOADER_C_Recurring_Run_BY_ID = "C_Recurring_RunByIdDataLoader";
	public static String DATALOADER_C_Recurring_Run_BY_UUID = "C_Recurring_RunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecurringRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Recurring_Run_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Recurring_Run_BY_UUID;
	}
}
