package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCountryGroup;

/**
 * Data Loader for C_CountryGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CountryGroupDataLoader extends PODataLoader<MCountryGroup> {
	public static String DATALOADER_C_CountryGroup_BY_ID = "C_CountryGroupByIdDataLoader";
	public static String DATALOADER_C_CountryGroup_BY_UUID = "C_CountryGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCountryGroup.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CountryGroup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CountryGroup_BY_UUID;
	}
}
