package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_Process;

/**
 * Data Loader for AD_WF_Process - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_WF_ProcessDataLoader extends PODataLoader<X_AD_WF_Process> {
	public static String DATALOADER_AD_WF_Process_BY_ID = "AD_WF_ProcessByIdDataLoader";
	public static String DATALOADER_AD_WF_Process_BY_UUID = "AD_WF_ProcessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_Process.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WF_Process_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WF_Process_BY_UUID;
	}
}
