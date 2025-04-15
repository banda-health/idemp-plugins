package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDepreciationConvention;

/**
 * Data Loader for A_Depreciation_Convention - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_ConventionDataLoader extends PODataLoader<MDepreciationConvention> {
	public static String DATALOADER_A_Depreciation_Convention_BY_ID = "A_Depreciation_ConventionByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Convention_BY_UUID = "A_Depreciation_ConventionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDepreciationConvention.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Convention_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Convention_BY_UUID;
	}
}
