package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplicationStrategy;

/**
 * Data Loader for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationStrategyDataLoader extends PODataLoader<MReplicationStrategy> {
	public static String DATALOADER_AD_ReplicationStrategy_BY_ID = "AD_ReplicationStrategyByIdDataLoader";
	public static String DATALOADER_AD_ReplicationStrategy_BY_UUID = "AD_ReplicationStrategyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplicationStrategy.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReplicationStrategy_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReplicationStrategy_BY_UUID;
	}
}
