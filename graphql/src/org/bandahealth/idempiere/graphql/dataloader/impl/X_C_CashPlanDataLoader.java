package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCashPlan;

/**
 * Data Loader for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CashPlanDataLoader extends PODataLoader<MCashPlan> {
	public static String DATALOADER_C_CashPlan_BY_ID = "C_CashPlanByIdDataLoader";
	public static String DATALOADER_C_CashPlan_BY_UUID = "C_CashPlanByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCashPlan.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CashPlan_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CashPlan_BY_UUID;
	}
}
