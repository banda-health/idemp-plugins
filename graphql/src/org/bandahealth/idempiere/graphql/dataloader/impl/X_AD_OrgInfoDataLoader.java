package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrgInfo_BH;

/**
 * Data Loader for AD_OrgInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_OrgInfoDataLoader extends PODataLoader<MOrgInfo_BH> {
	public static String DATALOADER_AD_OrgInfo_BY_ID = "AD_OrgInfoByIdDataLoader";
	public static String DATALOADER_AD_OrgInfo_BY_UUID = "AD_OrgInfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrgInfo_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_OrgInfo_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_OrgInfo_BY_UUID;
	}
}
