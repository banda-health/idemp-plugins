package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInfoWindow;

/**
 * Data Loader for AD_InfoWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_InfoWindowDataLoader extends PODataLoader<MInfoWindow> {
	public static String AD_InfoWindow_BY_ID_DATA_LOADER = "AD_InfoWindowByIdDataLoader";
	public static String AD_InfoWindow_BY_UUID_DATA_LOADER = "AD_InfoWindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInfoWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_InfoWindow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_InfoWindow_BY_UUID_DATA_LOADER;
	}
}
