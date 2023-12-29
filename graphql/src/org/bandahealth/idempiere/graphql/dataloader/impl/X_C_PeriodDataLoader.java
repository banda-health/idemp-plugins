package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPeriod;

/**
 * Data Loader for C_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PeriodDataLoader extends PODataLoader<MPeriod> {
	public static String C_Period_BY_ID_DATA_LOADER = "C_PeriodByIdDataLoader";
	public static String C_Period_BY_UUID_DATA_LOADER = "C_PeriodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPeriod.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Period_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Period_BY_UUID_DATA_LOADER;
	}
}
