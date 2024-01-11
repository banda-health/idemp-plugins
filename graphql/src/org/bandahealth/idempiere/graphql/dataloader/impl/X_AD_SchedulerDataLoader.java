package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MScheduler;

/**
 * Data Loader for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SchedulerDataLoader extends PODataLoader<MScheduler> {
	public static String AD_Scheduler_BY_ID_DATA_LOADER = "AD_SchedulerByIdDataLoader";
	public static String AD_Scheduler_BY_UUID_DATA_LOADER = "AD_SchedulerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MScheduler.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Scheduler_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Scheduler_BY_UUID_DATA_LOADER;
	}
}
