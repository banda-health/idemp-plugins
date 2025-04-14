package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Level;

/**
 * Data Loader for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_LevelDataLoader extends PODataLoader<X_ASP_Level> {
	public static String DATALOADER_ASP_Level_BY_ID = "ASP_LevelByIdDataLoader";
	public static String DATALOADER_ASP_Level_BY_UUID = "ASP_LevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Level.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Level_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Level_BY_UUID;
	}
}
