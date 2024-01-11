package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplication;

/**
 * Data Loader for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationDataLoader extends PODataLoader<MReplication> {
	public static String AD_Replication_BY_ID_DATA_LOADER = "AD_ReplicationByIdDataLoader";
	public static String AD_Replication_BY_UUID_DATA_LOADER = "AD_ReplicationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplication.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Replication_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Replication_BY_UUID_DATA_LOADER;
	}
}
