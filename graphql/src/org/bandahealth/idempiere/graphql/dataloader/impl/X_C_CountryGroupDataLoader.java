package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountryGroup;

/**
 * Data Loader for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryGroupDataLoader extends PODataLoader<MCountryGroup> {
	public static String C_CountryGroup_BY_ID_DATA_LOADER = "C_CountryGroupByIdDataLoader";
	public static String C_CountryGroup_BY_UUID_DATA_LOADER = "C_CountryGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountryGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CountryGroup_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CountryGroup_BY_UUID_DATA_LOADER;
	}
}
