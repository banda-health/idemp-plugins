package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ContactActivity;

/**
 * Data Loader for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ContactActivityDataLoader extends PODataLoader<X_C_ContactActivity> {
	public static String C_ContactActivity_BY_ID_DATA_LOADER = "C_ContactActivityByIdDataLoader";
	public static String C_ContactActivity_BY_UUID_DATA_LOADER = "C_ContactActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ContactActivity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ContactActivity_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ContactActivity_BY_UUID_DATA_LOADER;
	}
}
