package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MScheduler;

/**
 * Data Loader for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_SchedulerDataLoader extends PODataLoader<MScheduler> {
	public static String DATALOADER_AD_Scheduler_BY_ID = "AD_SchedulerByIdDataLoader";
	public static String DATALOADER_AD_Scheduler_BY_UUID = "AD_SchedulerByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MScheduler.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Scheduler_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Scheduler_BY_UUID;
	}
}
