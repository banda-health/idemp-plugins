package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWindow;

/**
 * Data Loader for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WindowDataLoader extends PODataLoader<MWindow> {
	public static String AD_Window_BY_ID_DATA_LOADER = "AD_WindowByIdDataLoader";
	public static String AD_Window_BY_UUID_DATA_LOADER = "AD_WindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Window_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Window_BY_UUID_DATA_LOADER;
	}
}
