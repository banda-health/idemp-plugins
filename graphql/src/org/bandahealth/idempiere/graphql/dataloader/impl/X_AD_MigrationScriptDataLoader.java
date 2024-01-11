package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_MigrationScript;

/**
 * Data Loader for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MigrationScriptDataLoader extends PODataLoader<X_AD_MigrationScript> {
	public static String AD_MigrationScript_BY_ID_DATA_LOADER = "AD_MigrationScriptByIdDataLoader";
	public static String AD_MigrationScript_BY_UUID_DATA_LOADER = "AD_MigrationScriptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_MigrationScript.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_MigrationScript_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_MigrationScript_BY_UUID_DATA_LOADER;
	}
}
