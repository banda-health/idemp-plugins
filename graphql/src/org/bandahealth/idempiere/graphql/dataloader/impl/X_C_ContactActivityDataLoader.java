package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ContactActivity;

/**
 * Data Loader for C_ContactActivity - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ContactActivityDataLoader extends PODataLoader<X_C_ContactActivity> {
	public static String DATALOADER_C_ContactActivity_BY_ID = "C_ContactActivityByIdDataLoader";
	public static String DATALOADER_C_ContactActivity_BY_UUID = "C_ContactActivityByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ContactActivity.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ContactActivity_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ContactActivity_BY_UUID;
	}
}
