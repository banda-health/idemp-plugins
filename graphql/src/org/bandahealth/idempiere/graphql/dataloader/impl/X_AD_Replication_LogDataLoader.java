package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplicationLog;

/**
 * Data Loader for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_LogDataLoader extends PODataLoader<MReplicationLog> {
	public static String AD_Replication_Log_BY_ID_DATA_LOADER = "AD_Replication_LogByIdDataLoader";
	public static String AD_Replication_Log_BY_UUID_DATA_LOADER = "AD_Replication_LogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplicationLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Replication_Log_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Replication_Log_BY_UUID_DATA_LOADER;
	}
}
