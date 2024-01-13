package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGoal;

/**
 * Data Loader for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_GoalDataLoader extends PODataLoader<MGoal> {
	public static String DATALOADER_PA_Goal_BY_ID = "PA_GoalByIdDataLoader";
	public static String DATALOADER_PA_Goal_BY_UUID = "PA_GoalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGoal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_Goal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_Goal_BY_UUID;
	}
}
