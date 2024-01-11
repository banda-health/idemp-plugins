package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductionPlan;

/**
 * Data Loader for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionPlanDataLoader extends PODataLoader<MProductionPlan> {
	public static String M_ProductionPlan_BY_ID_DATA_LOADER = "M_ProductionPlanByIdDataLoader";
	public static String M_ProductionPlan_BY_UUID_DATA_LOADER = "M_ProductionPlanByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductionPlan.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_ProductionPlan_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_ProductionPlan_BY_UUID_DATA_LOADER;
	}
}
