package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTest;

/**
 * Data Loader for Test - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_TestDataLoader extends PODataLoader<MTest> {
	public static String DATALOADER_Test_BY_ID = "TestByIdDataLoader";
	public static String DATALOADER_Test_BY_UUID = "TestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_Test_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_Test_BY_UUID;
	}
}
