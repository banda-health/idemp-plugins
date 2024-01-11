package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Tab;

/**
 * Data Loader for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_TabDataLoader extends PODataLoader<X_ASP_Tab> {
	public static String ASP_Tab_BY_ID_DATA_LOADER = "ASP_TabByIdDataLoader";
	public static String ASP_Tab_BY_UUID_DATA_LOADER = "ASP_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Tab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Tab_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Tab_BY_UUID_DATA_LOADER;
	}
}
