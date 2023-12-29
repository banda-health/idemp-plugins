package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MLocation;

/**
 * Data Loader for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LocationDataLoader extends PODataLoader<MLocation> {
	public static String C_Location_BY_ID_DATA_LOADER = "C_LocationByIdDataLoader";
	public static String C_Location_BY_UUID_DATA_LOADER = "C_LocationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MLocation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Location_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Location_BY_UUID_DATA_LOADER;
	}
}
