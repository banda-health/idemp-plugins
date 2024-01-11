package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerLog;

/**
 * Data Loader for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerLogDataLoader extends PODataLoader<MSchedulerLog> {
	public static String AD_SchedulerLog_BY_ID_DATA_LOADER = "AD_SchedulerLogByIdDataLoader";
	public static String AD_SchedulerLog_BY_UUID_DATA_LOADER = "AD_SchedulerLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_SchedulerLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_SchedulerLog_BY_UUID_DATA_LOADER;
	}
}
