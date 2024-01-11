package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Window;

/**
 * Data Loader for ASP_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_WindowDataLoader extends PODataLoader<X_ASP_Window> {
	public static String ASP_Window_BY_ID_DATA_LOADER = "ASP_WindowByIdDataLoader";
	public static String ASP_Window_BY_UUID_DATA_LOADER = "ASP_WindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Window.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Window_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Window_BY_UUID_DATA_LOADER;
	}
}
