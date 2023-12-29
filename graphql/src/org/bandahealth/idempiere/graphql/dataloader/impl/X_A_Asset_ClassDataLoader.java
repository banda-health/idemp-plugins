package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetClass;

/**
 * Data Loader for A_Asset_Class - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ClassDataLoader extends PODataLoader<MAssetClass> {
	public static String A_Asset_Class_BY_ID_DATA_LOADER = "A_Asset_ClassByIdDataLoader";
	public static String A_Asset_Class_BY_UUID_DATA_LOADER = "A_Asset_ClassByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetClass.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Class_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Class_BY_UUID_DATA_LOADER;
	}
}
