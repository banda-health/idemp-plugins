package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_MigrationScript;

/**
 * Data Loader for AD_MigrationScript - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_MigrationScriptDataLoader extends PODataLoader<X_AD_MigrationScript> {
	public static String DATALOADER_AD_MigrationScript_BY_ID = "AD_MigrationScriptByIdDataLoader";
	public static String DATALOADER_AD_MigrationScript_BY_UUID = "AD_MigrationScriptByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_MigrationScript.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_MigrationScript_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_MigrationScript_BY_UUID;
	}
}
