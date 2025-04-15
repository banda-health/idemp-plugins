package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInfoColumn;

/**
 * Data Loader for AD_InfoColumn - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_InfoColumnDataLoader extends PODataLoader<MInfoColumn> {
	public static String DATALOADER_AD_InfoColumn_BY_ID = "AD_InfoColumnByIdDataLoader";
	public static String DATALOADER_AD_InfoColumn_BY_UUID = "AD_InfoColumnByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInfoColumn.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_InfoColumn_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_InfoColumn_BY_UUID;
	}
}
