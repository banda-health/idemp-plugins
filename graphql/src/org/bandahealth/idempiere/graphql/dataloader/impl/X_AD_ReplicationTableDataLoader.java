package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_ReplicationTable;

/**
 * Data Loader for AD_ReplicationTable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationTableDataLoader extends PODataLoader<X_AD_ReplicationTable> {
	public static String DATALOADER_AD_ReplicationTable_BY_ID = "AD_ReplicationTableByIdDataLoader";
	public static String DATALOADER_AD_ReplicationTable_BY_UUID = "AD_ReplicationTableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_ReplicationTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ReplicationTable_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ReplicationTable_BY_UUID;
	}
}
