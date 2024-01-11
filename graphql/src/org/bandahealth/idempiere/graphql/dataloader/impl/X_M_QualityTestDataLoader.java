package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MQualityTest;

/**
 * Data Loader for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_QualityTestDataLoader extends PODataLoader<MQualityTest> {
	public static String M_QualityTest_BY_ID_DATA_LOADER = "M_QualityTestByIdDataLoader";
	public static String M_QualityTest_BY_UUID_DATA_LOADER = "M_QualityTestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MQualityTest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_QualityTest_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_QualityTest_BY_UUID_DATA_LOADER;
	}
}
