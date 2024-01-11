package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTest;

/**
 * Data Loader for Test - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_TestDataLoader extends PODataLoader<MTest> {
	public static String Test_BY_ID_DATA_LOADER = "TestByIdDataLoader";
	public static String Test_BY_UUID_DATA_LOADER = "TestByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTest.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return Test_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return Test_BY_UUID_DATA_LOADER;
	}
}
