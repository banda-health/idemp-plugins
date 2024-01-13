package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MClientInfo;

/**
 * Data Loader for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientInfoDataLoader extends PODataLoader<MClientInfo> {
	public static String DATALOADER_AD_ClientInfo_BY_ID = "AD_ClientInfoByIdDataLoader";
	public static String DATALOADER_AD_ClientInfo_BY_UUID = "AD_ClientInfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClientInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ClientInfo_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ClientInfo_BY_UUID;
	}
}
