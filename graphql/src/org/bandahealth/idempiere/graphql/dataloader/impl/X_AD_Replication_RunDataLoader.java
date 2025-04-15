package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplicationRun;

/**
 * Data Loader for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_Replication_RunDataLoader extends PODataLoader<MReplicationRun> {
	public static String DATALOADER_AD_Replication_Run_BY_ID = "AD_Replication_RunByIdDataLoader";
	public static String DATALOADER_AD_Replication_Run_BY_UUID = "AD_Replication_RunByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplicationRun.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Replication_Run_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Replication_Run_BY_UUID;
	}
}
