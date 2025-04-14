package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplicationLog;

/**
 * Data Loader for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Replication_LogDataLoader extends PODataLoader<MReplicationLog> {
	public static String DATALOADER_AD_Replication_Log_BY_ID = "AD_Replication_LogByIdDataLoader";
	public static String DATALOADER_AD_Replication_Log_BY_UUID = "AD_Replication_LogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplicationLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Replication_Log_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Replication_Log_BY_UUID;
	}
}
