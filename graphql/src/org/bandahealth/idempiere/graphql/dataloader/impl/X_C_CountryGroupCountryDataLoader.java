package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountryGroupCountry;

/**
 * Data Loader for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CountryGroupCountryDataLoader extends PODataLoader<MCountryGroupCountry> {
	public static String DATALOADER_C_CountryGroupCountry_BY_ID = "C_CountryGroupCountryByIdDataLoader";
	public static String DATALOADER_C_CountryGroupCountry_BY_UUID = "C_CountryGroupCountryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountryGroupCountry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CountryGroupCountry_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CountryGroupCountry_BY_UUID;
	}
}
