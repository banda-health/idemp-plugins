package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationBuild;

/**
 * Data Loader for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_BuildDataLoader extends PODataLoader<MDepreciationBuild> {
	public static String DATALOADER_A_Depreciation_Build_BY_ID = "A_Depreciation_BuildByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Build_BY_UUID = "A_Depreciation_BuildByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationBuild.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Build_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Build_BY_UUID;
	}
}
