package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGoal;

/**
 * Data Loader for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalDataLoader extends PODataLoader<MGoal> {
	public static String PA_Goal_BY_ID_DATA_LOADER = "PA_GoalByIdDataLoader";
	public static String PA_Goal_BY_UUID_DATA_LOADER = "PA_GoalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGoal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_Goal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_Goal_BY_UUID_DATA_LOADER;
	}
}
