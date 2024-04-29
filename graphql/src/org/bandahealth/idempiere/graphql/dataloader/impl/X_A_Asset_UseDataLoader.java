package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetUse;

/**
 * Data Loader for A_Asset_Use - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_UseDataLoader extends PODataLoader<MAssetUse> {
	public static String DATALOADER_A_Asset_Use_BY_ID = "A_Asset_UseByIdDataLoader";
	public static String DATALOADER_A_Asset_Use_BY_UUID = "A_Asset_UseByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetUse.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Asset_Use_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Asset_Use_BY_UUID;
	}
}
