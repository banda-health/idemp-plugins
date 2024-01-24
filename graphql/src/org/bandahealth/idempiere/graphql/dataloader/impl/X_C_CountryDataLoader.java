package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountry;

/**
 * Data Loader for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CountryDataLoader extends PODataLoader<MCountry> {
	public static String DATALOADER_C_Country_BY_ID = "C_CountryByIdDataLoader";
	public static String DATALOADER_C_Country_BY_UUID = "C_CountryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Country_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Country_BY_UUID;
	}
}
