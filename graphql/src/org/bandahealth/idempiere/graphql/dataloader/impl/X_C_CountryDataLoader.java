package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountry;

/**
 * Data Loader for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryDataLoader extends PODataLoader<MCountry> {
	public static String C_Country_BY_ID_DATA_LOADER = "C_CountryByIdDataLoader";
	public static String C_Country_BY_UUID_DATA_LOADER = "C_CountryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Country_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Country_BY_UUID_DATA_LOADER;
	}
}
