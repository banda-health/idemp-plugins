package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Year;

/**
 * Data Loader for HR_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_HR_YearDataLoader extends PODataLoader<X_HR_Year> {
	public static String DATALOADER_HR_Year_BY_ID = "HR_YearByIdDataLoader";
	public static String DATALOADER_HR_Year_BY_UUID = "HR_YearByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Year.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Year_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Year_BY_UUID;
	}
}
