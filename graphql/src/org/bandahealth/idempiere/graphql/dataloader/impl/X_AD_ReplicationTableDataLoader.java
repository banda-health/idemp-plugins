package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReplicationTable;

/**
 * Data Loader for AD_ReplicationTable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReplicationTableDataLoader extends PODataLoader<X_AD_ReplicationTable> {
	public static String AD_ReplicationTable_BY_ID_DATA_LOADER = "AD_ReplicationTableByIdDataLoader";
	public static String AD_ReplicationTable_BY_UUID_DATA_LOADER = "AD_ReplicationTableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReplicationTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ReplicationTable_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ReplicationTable_BY_UUID_DATA_LOADER;
	}
}
