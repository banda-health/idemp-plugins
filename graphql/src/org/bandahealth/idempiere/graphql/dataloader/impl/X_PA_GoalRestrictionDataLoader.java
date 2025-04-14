package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGoalRestriction;

/**
 * Data Loader for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_GoalRestrictionDataLoader extends PODataLoader<MGoalRestriction> {
	public static String DATALOADER_PA_GoalRestriction_BY_ID = "PA_GoalRestrictionByIdDataLoader";
	public static String DATALOADER_PA_GoalRestriction_BY_UUID = "PA_GoalRestrictionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGoalRestriction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_GoalRestriction_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_GoalRestriction_BY_UUID;
	}
}
