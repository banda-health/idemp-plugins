package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDunningLevel;

/**
 * Data Loader for C_DunningLevel - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningLevelDataLoader extends PODataLoader<MDunningLevel> {
	public static String DATALOADER_C_DunningLevel_BY_ID = "C_DunningLevelByIdDataLoader";
	public static String DATALOADER_C_DunningLevel_BY_UUID = "C_DunningLevelByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDunningLevel.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_DunningLevel_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_DunningLevel_BY_UUID;
	}
}
