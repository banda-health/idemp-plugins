package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAccessLog;

/**
 * Data Loader for AD_AccessLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_AccessLogDataLoader extends PODataLoader<MAccessLog> {
	public static String AD_AccessLog_BY_ID_DATA_LOADER = "AD_AccessLogByIdDataLoader";
	public static String AD_AccessLog_BY_UUID_DATA_LOADER = "AD_AccessLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAccessLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_AccessLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_AccessLog_BY_UUID_DATA_LOADER;
	}
}
