package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashPlan;

/**
 * Data Loader for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashPlanDataLoader extends PODataLoader<MCashPlan> {
	public static String C_CashPlan_BY_ID_DATA_LOADER = "C_CashPlanByIdDataLoader";
	public static String C_CashPlan_BY_UUID_DATA_LOADER = "C_CashPlanByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashPlan.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CashPlan_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CashPlan_BY_UUID_DATA_LOADER;
	}
}
