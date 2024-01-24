package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Window;

/**
 * Data Loader for ASP_Window - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_WindowDataLoader extends PODataLoader<X_ASP_Window> {
	public static String DATALOADER_ASP_Window_BY_ID = "ASP_WindowByIdDataLoader";
	public static String DATALOADER_ASP_Window_BY_UUID = "ASP_WindowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Window.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Window_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Window_BY_UUID;
	}
}
