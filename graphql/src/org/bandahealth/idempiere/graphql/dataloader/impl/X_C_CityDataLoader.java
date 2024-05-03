package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCity;

/**
 * Data Loader for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CityDataLoader extends PODataLoader<MCity> {
	public static String DATALOADER_C_City_BY_ID = "C_CityByIdDataLoader";
	public static String DATALOADER_C_City_BY_UUID = "C_CityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_City_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_City_BY_UUID;
	}
}
