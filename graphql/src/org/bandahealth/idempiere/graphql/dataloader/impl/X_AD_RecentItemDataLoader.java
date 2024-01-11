package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecentItem;

/**
 * Data Loader for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_RecentItemDataLoader extends PODataLoader<MRecentItem> {
	public static String AD_RecentItem_BY_ID_DATA_LOADER = "AD_RecentItemByIdDataLoader";
	public static String AD_RecentItem_BY_UUID_DATA_LOADER = "AD_RecentItemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecentItem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_RecentItem_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_RecentItem_BY_UUID_DATA_LOADER;
	}
}
