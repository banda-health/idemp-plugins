package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRevenueRecognition;

/**
 * Data Loader for C_RevenueRecognition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_RevenueRecognitionDataLoader extends PODataLoader<MRevenueRecognition> {
	public static String DATALOADER_C_RevenueRecognition_BY_ID = "C_RevenueRecognitionByIdDataLoader";
	public static String DATALOADER_C_RevenueRecognition_BY_UUID = "C_RevenueRecognitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRevenueRecognition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_RevenueRecognition_BY_UUID;
	}
}
