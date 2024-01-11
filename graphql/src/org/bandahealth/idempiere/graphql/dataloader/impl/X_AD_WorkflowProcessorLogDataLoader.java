package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkflowProcessorLog;

/**
 * Data Loader for AD_WorkflowProcessorLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorLogDataLoader extends PODataLoader<X_AD_WorkflowProcessorLog> {
	public static String AD_WorkflowProcessorLog_BY_ID_DATA_LOADER = "AD_WorkflowProcessorLogByIdDataLoader";
	public static String AD_WorkflowProcessorLog_BY_UUID_DATA_LOADER = "AD_WorkflowProcessorLogByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessorLog.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WorkflowProcessorLog_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WorkflowProcessorLog_BY_UUID_DATA_LOADER;
	}
}
