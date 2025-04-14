package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySchedule;

/**
 * Data Loader for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_PayScheduleDataLoader extends PODataLoader<MPaySchedule> {
	public static String DATALOADER_C_PaySchedule_BY_ID = "C_PayScheduleByIdDataLoader";
	public static String DATALOADER_C_PaySchedule_BY_UUID = "C_PayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_PaySchedule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_PaySchedule_BY_UUID;
	}
}
