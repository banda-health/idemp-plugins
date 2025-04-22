package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_I_Asset;

/**
 * Data Loader for I_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_I_AssetDataLoader extends PODataLoader<X_I_Asset> {
	public static String DATALOADER_I_Asset_BY_ID = "I_AssetByIdDataLoader";
	public static String DATALOADER_I_Asset_BY_UUID = "I_AssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_I_Asset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_Asset_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_Asset_BY_UUID;
	}
}
