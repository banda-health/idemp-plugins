package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCity;

/**
 * Data Loader for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CityDataLoader extends PODataLoader<MCity> {
	public static String C_City_BY_ID_DATA_LOADER = "C_CityByIdDataLoader";
	public static String C_City_BY_UUID_DATA_LOADER = "C_CityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_City_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_City_BY_UUID_DATA_LOADER;
	}
}
