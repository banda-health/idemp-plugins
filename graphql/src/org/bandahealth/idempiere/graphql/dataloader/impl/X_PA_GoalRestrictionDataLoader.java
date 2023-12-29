package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGoalRestriction;

/**
 * Data Loader for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalRestrictionDataLoader extends PODataLoader<MGoalRestriction> {
	public static String PA_GoalRestriction_BY_ID_DATA_LOADER = "PA_GoalRestrictionByIdDataLoader";
	public static String PA_GoalRestriction_BY_UUID_DATA_LOADER = "PA_GoalRestrictionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGoalRestriction.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_GoalRestriction_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_GoalRestriction_BY_UUID_DATA_LOADER;
	}
}
