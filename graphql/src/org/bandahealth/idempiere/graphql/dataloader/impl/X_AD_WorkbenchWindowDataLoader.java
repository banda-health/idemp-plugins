package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkbenchWindow;

/**
 * Data Loader for AD_WorkbenchWindow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkbenchWindowDataLoader extends PODataLoader<X_AD_WorkbenchWindow> {
	public static String AD_WorkbenchWindow_BY_ID_DATA_LOADER = "AD_WorkbenchWindowByIdDataLoader";
	public static String AD_WorkbenchWindow_BY_UUID_DATA_LOADER = "AD_WorkbenchWindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkbenchWindow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WorkbenchWindow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WorkbenchWindow_BY_UUID_DATA_LOADER;
	}
}
