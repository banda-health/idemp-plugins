package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MOrderPaySchedule;

/**
 * Data Loader for C_OrderPaySchedule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_OrderPayScheduleDataLoader extends PODataLoader<MOrderPaySchedule> {
	public static String DATALOADER_C_OrderPaySchedule_BY_ID = "C_OrderPayScheduleByIdDataLoader";
	public static String DATALOADER_C_OrderPaySchedule_BY_UUID = "C_OrderPayScheduleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderPaySchedule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderPaySchedule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderPaySchedule_BY_UUID;
	}
}
