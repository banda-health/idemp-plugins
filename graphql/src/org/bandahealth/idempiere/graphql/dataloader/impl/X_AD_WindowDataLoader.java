package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWindow;

/**
 * Data Loader for AD_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WindowDataLoader extends PODataLoader<MWindow> {
	public static String DATALOADER_AD_Window_BY_ID = "AD_WindowByIdDataLoader";
	public static String DATALOADER_AD_Window_BY_UUID = "AD_WindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Window_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Window_BY_UUID;
	}
}
