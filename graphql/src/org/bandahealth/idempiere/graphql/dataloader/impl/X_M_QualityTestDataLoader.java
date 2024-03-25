package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MQualityTest;

/**
 * Data Loader for M_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_QualityTestDataLoader extends PODataLoader<MQualityTest> {
	public static String DATALOADER_M_QualityTest_BY_ID = "M_QualityTestByIdDataLoader";
	public static String DATALOADER_M_QualityTest_BY_UUID = "M_QualityTestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MQualityTest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_QualityTest_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_QualityTest_BY_UUID;
	}
}
