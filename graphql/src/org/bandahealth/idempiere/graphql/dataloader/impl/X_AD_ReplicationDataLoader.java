package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplication;

/**
 * Data Loader for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationDataLoader extends PODataLoader<MReplication> {
	public static String DATALOADER_AD_Replication_BY_ID = "AD_ReplicationByIdDataLoader";
	public static String DATALOADER_AD_Replication_BY_UUID = "AD_ReplicationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplication.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Replication_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Replication_BY_UUID;
	}
}
