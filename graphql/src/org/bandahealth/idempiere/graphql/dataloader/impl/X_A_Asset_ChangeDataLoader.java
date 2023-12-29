package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAssetChange;

/**
 * Data Loader for A_Asset_Change - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_ChangeDataLoader extends PODataLoader<MAssetChange> {
	public static String A_Asset_Change_BY_ID_DATA_LOADER = "A_Asset_ChangeByIdDataLoader";
	public static String A_Asset_Change_BY_UUID_DATA_LOADER = "A_Asset_ChangeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAssetChange.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_Asset_Change_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_Asset_Change_BY_UUID_DATA_LOADER;
	}
}
