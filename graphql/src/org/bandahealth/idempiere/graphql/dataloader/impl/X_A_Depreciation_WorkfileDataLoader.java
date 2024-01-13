package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationWorkfile;

/**
 * Data Loader for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileDataLoader extends PODataLoader<MDepreciationWorkfile> {
	public static String DATALOADER_A_Depreciation_Workfile_BY_ID = "A_Depreciation_WorkfileByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Workfile_BY_UUID = "A_Depreciation_WorkfileByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationWorkfile.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Workfile_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Workfile_BY_UUID;
	}
}
