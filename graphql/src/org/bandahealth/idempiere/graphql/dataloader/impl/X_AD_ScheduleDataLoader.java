package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSchedule;

/**
 * Data Loader for AD_Schedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ScheduleDataLoader extends PODataLoader<MSchedule> {
	public static String DATALOADER_AD_Schedule_BY_ID = "AD_ScheduleByIdDataLoader";
	public static String DATALOADER_AD_Schedule_BY_UUID = "AD_ScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Schedule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Schedule_BY_UUID;
	}
}
