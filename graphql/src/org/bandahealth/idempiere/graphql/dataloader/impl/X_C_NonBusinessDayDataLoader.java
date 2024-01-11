package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_NonBusinessDay;

/**
 * Data Loader for C_NonBusinessDay - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_NonBusinessDayDataLoader extends PODataLoader<X_C_NonBusinessDay> {
	public static String C_NonBusinessDay_BY_ID_DATA_LOADER = "C_NonBusinessDayByIdDataLoader";
	public static String C_NonBusinessDay_BY_UUID_DATA_LOADER = "C_NonBusinessDayByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_NonBusinessDay.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_NonBusinessDay_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_NonBusinessDay_BY_UUID_DATA_LOADER;
	}
}
