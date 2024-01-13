package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkbenchWindow;

/**
 * Data Loader for AD_WorkbenchWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkbenchWindowDataLoader extends PODataLoader<X_AD_WorkbenchWindow> {
	public static String DATALOADER_AD_WorkbenchWindow_BY_ID = "AD_WorkbenchWindowByIdDataLoader";
	public static String DATALOADER_AD_WorkbenchWindow_BY_UUID = "AD_WorkbenchWindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkbenchWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WorkbenchWindow_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WorkbenchWindow_BY_UUID;
	}
}
