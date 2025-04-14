package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciation;

/**
 * Data Loader for A_Depreciation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_DepreciationDataLoader extends PODataLoader<MDepreciation> {
	public static String DATALOADER_A_Depreciation_BY_ID = "A_DepreciationByIdDataLoader";
	public static String DATALOADER_A_Depreciation_BY_UUID = "A_DepreciationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_BY_UUID;
	}
}
