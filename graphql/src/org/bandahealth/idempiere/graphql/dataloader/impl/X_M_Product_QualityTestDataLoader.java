package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Product_QualityTest;

/**
 * Data Loader for M_Product_QualityTest - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_Product_QualityTestDataLoader extends PODataLoader<X_M_Product_QualityTest> {
	public static String DATALOADER_M_Product_QualityTest_BY_ID = "M_Product_QualityTestByIdDataLoader";
	public static String DATALOADER_M_Product_QualityTest_BY_UUID = "M_Product_QualityTestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Product_QualityTest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_QualityTest_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_QualityTest_BY_UUID;
	}
}
