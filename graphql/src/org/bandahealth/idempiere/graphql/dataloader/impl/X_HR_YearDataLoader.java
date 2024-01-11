package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Year;

/**
 * Data Loader for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_YearDataLoader extends PODataLoader<X_HR_Year> {
	public static String HR_Year_BY_ID_DATA_LOADER = "HR_YearByIdDataLoader";
	public static String HR_Year_BY_UUID_DATA_LOADER = "HR_YearByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Year.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Year_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Year_BY_UUID_DATA_LOADER;
	}
}
