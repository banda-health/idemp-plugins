package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAchievement;

/**
 * Data Loader for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_AchievementDataLoader extends PODataLoader<MAchievement> {
	public static String PA_Achievement_BY_ID_DATA_LOADER = "PA_AchievementByIdDataLoader";
	public static String PA_Achievement_BY_UUID_DATA_LOADER = "PA_AchievementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAchievement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Achievement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Achievement_BY_UUID_DATA_LOADER;
	}
}
