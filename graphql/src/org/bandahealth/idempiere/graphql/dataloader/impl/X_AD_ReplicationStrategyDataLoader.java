package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReplicationStrategy;

/**
 * Data Loader for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationStrategyDataLoader extends PODataLoader<MReplicationStrategy> {
	public static String AD_ReplicationStrategy_BY_ID_DATA_LOADER = "AD_ReplicationStrategyByIdDataLoader";
	public static String AD_ReplicationStrategy_BY_UUID_DATA_LOADER = "AD_ReplicationStrategyByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReplicationStrategy.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReplicationStrategy_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReplicationStrategy_BY_UUID_DATA_LOADER;
	}
}
