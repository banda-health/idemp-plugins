package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRevenueRecognitionRun;

/**
 * Data Loader for C_RevenueRecognition_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognition_RunDataLoader extends PODataLoader<MRevenueRecognitionRun> {
	public static String DATALOADER_C_RevenueRecognition_Run_BY_ID = "C_RevenueRecognition_RunByIdDataLoader";
	public static String DATALOADER_C_RevenueRecognition_Run_BY_UUID = "C_RevenueRecognition_RunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRevenueRecognitionRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_Run_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_Run_BY_UUID;
	}
}
