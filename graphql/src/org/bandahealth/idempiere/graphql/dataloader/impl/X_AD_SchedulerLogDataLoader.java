package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedulerLog;

/**
 * Data Loader for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerLogDataLoader extends PODataLoader<MSchedulerLog> {
	public static String DATALOADER_AD_SchedulerLog_BY_ID = "AD_SchedulerLogByIdDataLoader";
	public static String DATALOADER_AD_SchedulerLog_BY_UUID = "AD_SchedulerLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedulerLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_SchedulerLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_SchedulerLog_BY_UUID;
	}
}
