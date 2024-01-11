package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Level;

/**
 * Data Loader for ASP_Level - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_LevelDataLoader extends PODataLoader<X_ASP_Level> {
	public static String ASP_Level_BY_ID_DATA_LOADER = "ASP_LevelByIdDataLoader";
	public static String ASP_Level_BY_UUID_DATA_LOADER = "ASP_LevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Level.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Level_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Level_BY_UUID_DATA_LOADER;
	}
}
