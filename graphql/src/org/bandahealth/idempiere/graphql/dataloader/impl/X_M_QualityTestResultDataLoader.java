package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MQualityTestResult;

/**
 * Data Loader for M_QualityTestResult - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_QualityTestResultDataLoader extends PODataLoader<MQualityTestResult> {
	public static String M_QualityTestResult_BY_ID_DATA_LOADER = "M_QualityTestResultByIdDataLoader";
	public static String M_QualityTestResult_BY_UUID_DATA_LOADER = "M_QualityTestResultByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MQualityTestResult.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_QualityTestResult_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_QualityTestResult_BY_UUID_DATA_LOADER;
	}
}
