package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInfoWindowAccess;

/**
 * Data Loader for AD_InfoWindow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoWindow_AccessDataLoader extends PODataLoader<MInfoWindowAccess> {
	public static String AD_InfoWindow_Access_BY_ID_DATA_LOADER = "AD_InfoWindow_AccessByIdDataLoader";
	public static String AD_InfoWindow_Access_BY_UUID_DATA_LOADER = "AD_InfoWindow_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInfoWindowAccess.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_InfoWindow_Access_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_InfoWindow_Access_BY_UUID_DATA_LOADER;
	}
}
