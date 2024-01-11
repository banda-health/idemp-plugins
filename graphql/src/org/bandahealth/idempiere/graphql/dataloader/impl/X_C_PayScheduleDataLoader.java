package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPaySchedule;

/**
 * Data Loader for C_PaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PayScheduleDataLoader extends PODataLoader<MPaySchedule> {
	public static String C_PaySchedule_BY_ID_DATA_LOADER = "C_PayScheduleByIdDataLoader";
	public static String C_PaySchedule_BY_UUID_DATA_LOADER = "C_PayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_PaySchedule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_PaySchedule_BY_UUID_DATA_LOADER;
	}
}
