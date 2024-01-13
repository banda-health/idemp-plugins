package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkflowProcessorLog;

/**
 * Data Loader for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorLogDataLoader extends PODataLoader<X_AD_WorkflowProcessorLog> {
	public static String DATALOADER_AD_WorkflowProcessorLog_BY_ID = "AD_WorkflowProcessorLogByIdDataLoader";
	public static String DATALOADER_AD_WorkflowProcessorLog_BY_UUID = "AD_WorkflowProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WorkflowProcessorLog_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WorkflowProcessorLog_BY_UUID;
	}
}
