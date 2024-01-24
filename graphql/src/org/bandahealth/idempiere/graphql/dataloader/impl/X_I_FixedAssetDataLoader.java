package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIFixedAsset;

/**
 * Data Loader for I_FixedAsset - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_FixedAssetDataLoader extends PODataLoader<MIFixedAsset> {
	public static String DATALOADER_I_FixedAsset_BY_ID = "I_FixedAssetByIdDataLoader";
	public static String DATALOADER_I_FixedAsset_BY_UUID = "I_FixedAssetByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIFixedAsset.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_I_FixedAsset_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_I_FixedAsset_BY_UUID;
	}
}
