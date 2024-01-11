package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderPaySchedule;

/**
 * Data Loader for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_OrderPayScheduleDataLoader extends PODataLoader<MOrderPaySchedule> {
	public static String C_OrderPaySchedule_BY_ID_DATA_LOADER = "C_OrderPayScheduleByIdDataLoader";
	public static String C_OrderPaySchedule_BY_UUID_DATA_LOADER = "C_OrderPayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderPaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_OrderPaySchedule_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_OrderPaySchedule_BY_UUID_DATA_LOADER;
	}
}
