package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkflowProcessor;

/**
 * Data Loader for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowProcessorDataLoader extends PODataLoader<X_AD_WorkflowProcessor> {
	public static String AD_WorkflowProcessor_BY_ID_DATA_LOADER = "AD_WorkflowProcessorByIdDataLoader";
	public static String AD_WorkflowProcessor_BY_UUID_DATA_LOADER = "AD_WorkflowProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WorkflowProcessor_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WorkflowProcessor_BY_UUID_DATA_LOADER;
	}
}
