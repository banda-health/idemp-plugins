package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MYear;

/**
 * Data Loader for C_Year - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_YearDataLoader extends PODataLoader<MYear> {
	public static String C_Year_BY_ID_DATA_LOADER = "C_YearByIdDataLoader";
	public static String C_Year_BY_UUID_DATA_LOADER = "C_YearByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MYear.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Year_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Year_BY_UUID_DATA_LOADER;
	}
}
