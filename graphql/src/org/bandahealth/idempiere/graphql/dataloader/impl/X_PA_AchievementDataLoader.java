package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAchievement;

/**
 * Data Loader for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_AchievementDataLoader extends PODataLoader<MAchievement> {
	public static String DATALOADER_PA_Achievement_BY_ID = "PA_AchievementByIdDataLoader";
	public static String DATALOADER_PA_Achievement_BY_UUID = "PA_AchievementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAchievement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Achievement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Achievement_BY_UUID;
	}
}
