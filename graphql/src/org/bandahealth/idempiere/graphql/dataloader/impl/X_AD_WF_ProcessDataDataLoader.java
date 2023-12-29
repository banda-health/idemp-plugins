package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_ProcessData;

/**
 * Data Loader for AD_WF_ProcessData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessDataDataLoader extends PODataLoader<X_AD_WF_ProcessData> {
	public static String AD_WF_ProcessData_BY_ID_DATA_LOADER = "AD_WF_ProcessDataByIdDataLoader";
	public static String AD_WF_ProcessData_BY_UUID_DATA_LOADER = "AD_WF_ProcessDataByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_ProcessData.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_ProcessData_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_ProcessData_BY_UUID_DATA_LOADER;
	}
}
