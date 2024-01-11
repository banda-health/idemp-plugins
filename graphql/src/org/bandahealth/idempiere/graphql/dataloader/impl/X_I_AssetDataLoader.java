package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Asset;

/**
 * Data Loader for I_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_AssetDataLoader extends PODataLoader<X_I_Asset> {
	public static String I_Asset_BY_ID_DATA_LOADER = "I_AssetByIdDataLoader";
	public static String I_Asset_BY_UUID_DATA_LOADER = "I_AssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Asset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return I_Asset_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return I_Asset_BY_UUID_DATA_LOADER;
	}
}
