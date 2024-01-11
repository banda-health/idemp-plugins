package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountryGroupCountry;

/**
 * Data Loader for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryGroupCountryDataLoader extends PODataLoader<MCountryGroupCountry> {
	public static String C_CountryGroupCountry_BY_ID_DATA_LOADER = "C_CountryGroupCountryByIdDataLoader";
	public static String C_CountryGroupCountry_BY_UUID_DATA_LOADER = "C_CountryGroupCountryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountryGroupCountry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CountryGroupCountry_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CountryGroupCountry_BY_UUID_DATA_LOADER;
	}
}
