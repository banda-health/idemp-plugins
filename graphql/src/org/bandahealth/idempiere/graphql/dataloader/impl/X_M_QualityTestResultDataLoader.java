package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MQualityTestResult;

/**
 * Data Loader for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_QualityTestResultDataLoader extends PODataLoader<MQualityTestResult> {
	public static String DATALOADER_M_QualityTestResult_BY_ID = "M_QualityTestResultByIdDataLoader";
	public static String DATALOADER_M_QualityTestResult_BY_UUID = "M_QualityTestResultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MQualityTestResult.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_QualityTestResult_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_QualityTestResult_BY_UUID;
	}
}
