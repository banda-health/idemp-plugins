package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningLevel;

/**
 * Data Loader for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningLevelDataLoader extends PODataLoader<MDunningLevel> {
	public static String C_DunningLevel_BY_ID_DATA_LOADER = "C_DunningLevelByIdDataLoader";
	public static String C_DunningLevel_BY_UUID_DATA_LOADER = "C_DunningLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_DunningLevel_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_DunningLevel_BY_UUID_DATA_LOADER;
	}
}
