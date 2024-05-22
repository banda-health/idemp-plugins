package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCalendar;

/**
 * Data Loader for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CalendarDataLoader extends PODataLoader<MCalendar> {
	public static String DATALOADER_C_Calendar_BY_ID = "C_CalendarByIdDataLoader";
	public static String DATALOADER_C_Calendar_BY_UUID = "C_CalendarByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCalendar.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Calendar_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Calendar_BY_UUID;
	}
}
