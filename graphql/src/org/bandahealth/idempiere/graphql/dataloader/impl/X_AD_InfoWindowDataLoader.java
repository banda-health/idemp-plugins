package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInfoWindow;

/**
 * Data Loader for AD_InfoWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_InfoWindowDataLoader extends PODataLoader<MInfoWindow> {
	public static String DATALOADER_AD_InfoWindow_BY_ID = "AD_InfoWindowByIdDataLoader";
	public static String DATALOADER_AD_InfoWindow_BY_UUID = "AD_InfoWindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInfoWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_InfoWindow_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_InfoWindow_BY_UUID;
	}
}
