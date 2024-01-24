package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationEntry;

/**
 * Data Loader for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_EntryDataLoader extends PODataLoader<MDepreciationEntry> {
	public static String DATALOADER_A_Depreciation_Entry_BY_ID = "A_Depreciation_EntryByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Entry_BY_UUID = "A_Depreciation_EntryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationEntry.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Entry_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Entry_BY_UUID;
	}
}
