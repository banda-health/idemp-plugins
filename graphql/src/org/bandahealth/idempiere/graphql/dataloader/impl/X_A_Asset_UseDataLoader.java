package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetUse;

/**
 * Data Loader for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_UseDataLoader extends PODataLoader<MAssetUse> {
	public static String A_Asset_Use_BY_ID_DATA_LOADER = "A_Asset_UseByIdDataLoader";
	public static String A_Asset_Use_BY_UUID_DATA_LOADER = "A_Asset_UseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetUse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Use_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Use_BY_UUID_DATA_LOADER;
	}
}
