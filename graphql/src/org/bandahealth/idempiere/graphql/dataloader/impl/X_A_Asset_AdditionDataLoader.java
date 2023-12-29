package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetAddition;

/**
 * Data Loader for A_Asset_Addition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_AdditionDataLoader extends PODataLoader<MAssetAddition> {
	public static String A_Asset_Addition_BY_ID_DATA_LOADER = "A_Asset_AdditionByIdDataLoader";
	public static String A_Asset_Addition_BY_UUID_DATA_LOADER = "A_Asset_AdditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetAddition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Addition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Addition_BY_UUID_DATA_LOADER;
	}
}
