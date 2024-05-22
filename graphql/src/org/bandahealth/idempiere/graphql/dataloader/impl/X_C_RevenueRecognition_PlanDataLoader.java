package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRevenueRecognitionPlan;

/**
 * Data Loader for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecognition_PlanDataLoader extends PODataLoader<MRevenueRecognitionPlan> {
	public static String DATALOADER_C_RevenueRecognition_Plan_BY_ID = "C_RevenueRecognition_PlanByIdDataLoader";
	public static String DATALOADER_C_RevenueRecognition_Plan_BY_UUID = "C_RevenueRecognition_PlanByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRevenueRecognitionPlan.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_Plan_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_Plan_BY_UUID;
	}
}
