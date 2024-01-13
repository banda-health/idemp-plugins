package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MSysConfig_BH;

/**
 * Data Loader for AD_SysConfig - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SysConfigDataLoader extends PODataLoader<MSysConfig_BH> {
	public static String DATALOADER_AD_SysConfig_BY_ID = "AD_SysConfigByIdDataLoader";
	public static String DATALOADER_AD_SysConfig_BY_UUID = "AD_SysConfigByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSysConfig_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_SysConfig_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_SysConfig_BY_UUID;
	}
}
