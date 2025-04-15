package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MTable;

/**
 * Data Loader for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TableDataLoader extends PODataLoader<MTable> {
	public static String DATALOADER_AD_Table_BY_ID = "AD_TableByIdDataLoader";
	public static String DATALOADER_AD_Table_BY_UUID = "AD_TableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Table_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Table_BY_UUID;
	}
}
