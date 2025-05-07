package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MSLAGoal;

/**
 * Data Loader for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_GoalDataLoader extends PODataLoader<MSLAGoal> {
	public static String DATALOADER_PA_SLA_Goal_BY_ID = "PA_SLA_GoalByIdDataLoader";
	public static String DATALOADER_PA_SLA_Goal_BY_UUID = "PA_SLA_GoalByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSLAGoal.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_SLA_Goal_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_SLA_Goal_BY_UUID;
	}
}
