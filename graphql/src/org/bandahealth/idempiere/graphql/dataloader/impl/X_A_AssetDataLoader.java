package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAsset;

/**
 * Data Loader for A_Asset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_AssetDataLoader extends PODataLoader<MAsset> {
	public static String DATALOADER_A_Asset_BY_ID = "A_AssetByIdDataLoader";
	public static String DATALOADER_A_Asset_BY_UUID = "A_AssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAsset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_BY_UUID;
	}
}
