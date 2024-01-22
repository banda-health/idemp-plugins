package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Tab;

/**
 * Data Loader for ASP_Tab - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_TabDataLoader extends PODataLoader<X_ASP_Tab> {
	public static String DATALOADER_ASP_Tab_BY_ID = "ASP_TabByIdDataLoader";
	public static String DATALOADER_ASP_Tab_BY_UUID = "ASP_TabByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Tab.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Tab_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Tab_BY_UUID;
	}
}
