package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCalendar;

/**
 * Data Loader for C_Calendar - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CalendarDataLoader extends PODataLoader<MCalendar> {
	public static String C_Calendar_BY_ID_DATA_LOADER = "C_CalendarByIdDataLoader";
	public static String C_Calendar_BY_UUID_DATA_LOADER = "C_CalendarByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCalendar.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Calendar_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Calendar_BY_UUID_DATA_LOADER;
	}
}
