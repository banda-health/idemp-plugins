package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAccessLog;

/**
 * Data Loader for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AccessLogDataLoader extends PODataLoader<MAccessLog> {
	public static String DATALOADER_AD_AccessLog_BY_ID = "AD_AccessLogByIdDataLoader";
	public static String DATALOADER_AD_AccessLog_BY_UUID = "AD_AccessLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAccessLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_AccessLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_AccessLog_BY_UUID;
	}
}
