package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Process;

/**
 * Data Loader for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ProcessDataLoader extends PODataLoader<X_AD_WF_Process> {
	public static String AD_WF_Process_BY_ID_DATA_LOADER = "AD_WF_ProcessByIdDataLoader";
	public static String AD_WF_Process_BY_UUID_DATA_LOADER = "AD_WF_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Process.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_Process_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_Process_BY_UUID_DATA_LOADER;
	}
}
