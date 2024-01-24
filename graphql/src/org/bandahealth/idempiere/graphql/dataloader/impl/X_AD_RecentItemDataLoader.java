package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRecentItem;

/**
 * Data Loader for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_RecentItemDataLoader extends PODataLoader<MRecentItem> {
	public static String DATALOADER_AD_RecentItem_BY_ID = "AD_RecentItemByIdDataLoader";
	public static String DATALOADER_AD_RecentItem_BY_UUID = "AD_RecentItemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRecentItem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_RecentItem_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_RecentItem_BY_UUID;
	}
}
