package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrgInfo_BH;

/**
 * Data Loader for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInfoDataLoader extends PODataLoader<MOrgInfo_BH> {
	public static String AD_OrgInfo_BY_ID_DATA_LOADER = "AD_OrgInfoByIdDataLoader";
	public static String AD_OrgInfo_BY_UUID_DATA_LOADER = "AD_OrgInfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrgInfo_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_OrgInfo_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_OrgInfo_BY_UUID_DATA_LOADER;
	}
}
