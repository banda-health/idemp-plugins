package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Period;

/**
 * Data Loader for HR_Period - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_PeriodDataLoader extends PODataLoader<X_HR_Period> {
	public static String HR_Period_BY_ID_DATA_LOADER = "HR_PeriodByIdDataLoader";
	public static String HR_Period_BY_UUID_DATA_LOADER = "HR_PeriodByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Period.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Period_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Period_BY_UUID_DATA_LOADER;
	}
}
