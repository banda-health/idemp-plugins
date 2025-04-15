package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductionPlan;

/**
 * Data Loader for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductionPlanDataLoader extends PODataLoader<MProductionPlan> {
	public static String DATALOADER_M_ProductionPlan_BY_ID = "M_ProductionPlanByIdDataLoader";
	public static String DATALOADER_M_ProductionPlan_BY_UUID = "M_ProductionPlanByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductionPlan.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_ProductionPlan_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_ProductionPlan_BY_UUID;
	}
}
