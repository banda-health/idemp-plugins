package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRefTable;

/**
 * Data Loader for AD_Ref_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Ref_TableDataLoader extends PODataLoader<MRefTable> {
	public static String DATALOADER_AD_Ref_Table_BY_ID = "AD_Ref_TableByIdDataLoader";
	public static String DATALOADER_AD_Ref_Table_BY_UUID = "AD_Ref_TableByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRefTable.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Ref_Table_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Ref_Table_BY_UUID;
	}
}
