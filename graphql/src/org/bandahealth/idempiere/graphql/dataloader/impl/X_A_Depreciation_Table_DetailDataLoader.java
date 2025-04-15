package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_Depreciation_Table_Detail;

/**
 * Data Loader for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_Table_DetailDataLoader extends PODataLoader<X_A_Depreciation_Table_Detail> {
	public static String DATALOADER_A_Depreciation_Table_Detail_BY_ID = "A_Depreciation_Table_DetailByIdDataLoader";
	public static String DATALOADER_A_Depreciation_Table_Detail_BY_UUID = "A_Depreciation_Table_DetailByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Detail.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_Depreciation_Table_Detail_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_Depreciation_Table_Detail_BY_UUID;
	}
}
