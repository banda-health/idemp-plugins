package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAsset;

/**
 * Data Loader for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_AssetDataLoader extends PODataLoader<MAsset> {
	public static String A_Asset_BY_ID_DATA_LOADER = "A_AssetByIdDataLoader";
	public static String A_Asset_BY_UUID_DATA_LOADER = "A_AssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAsset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_BY_UUID_DATA_LOADER;
	}
}
