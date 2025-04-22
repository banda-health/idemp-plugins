package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_NonBusinessDay;

/**
 * Data Loader for C_NonBusinessDay - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_NonBusinessDayDataLoader extends PODataLoader<X_C_NonBusinessDay> {
	public static String DATALOADER_C_NonBusinessDay_BY_ID = "C_NonBusinessDayByIdDataLoader";
	public static String DATALOADER_C_NonBusinessDay_BY_UUID = "C_NonBusinessDayByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_NonBusinessDay.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_NonBusinessDay_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_NonBusinessDay_BY_UUID;
	}
}
