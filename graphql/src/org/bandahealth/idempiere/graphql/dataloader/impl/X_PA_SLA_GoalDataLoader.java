package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLAGoal;

/**
 * Data Loader for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_SLA_GoalDataLoader extends PODataLoader<MSLAGoal> {
	public static String PA_SLA_Goal_BY_ID_DATA_LOADER = "PA_SLA_GoalByIdDataLoader";
	public static String PA_SLA_Goal_BY_UUID_DATA_LOADER = "PA_SLA_GoalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLAGoal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_SLA_Goal_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_SLA_Goal_BY_UUID_DATA_LOADER;
	}
}
