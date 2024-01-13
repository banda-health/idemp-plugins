package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Desktop;

/**
 * Data Loader for AD_Desktop - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_DesktopDataLoader extends PODataLoader<X_AD_Desktop> {
	public static String DATALOADER_AD_Desktop_BY_ID = "AD_DesktopByIdDataLoader";
	public static String DATALOADER_AD_Desktop_BY_UUID = "AD_DesktopByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Desktop.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Desktop_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Desktop_BY_UUID;
	}
}
