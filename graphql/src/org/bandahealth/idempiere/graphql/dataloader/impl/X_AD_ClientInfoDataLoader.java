package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MClientInfo;

/**
 * Data Loader for AD_ClientInfo - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ClientInfoDataLoader extends PODataLoader<MClientInfo> {
	public static String AD_ClientInfo_BY_ID_DATA_LOADER = "AD_ClientInfoByIdDataLoader";
	public static String AD_ClientInfo_BY_UUID_DATA_LOADER = "AD_ClientInfoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MClientInfo.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ClientInfo_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ClientInfo_BY_UUID_DATA_LOADER;
	}
}
