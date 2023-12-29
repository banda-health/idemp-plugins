package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Workflow;

/**
 * Data Loader for AD_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WorkflowDataLoader extends PODataLoader<X_AD_Workflow> {
	public static String AD_Workflow_BY_ID_DATA_LOADER = "AD_WorkflowByIdDataLoader";
	public static String AD_Workflow_BY_UUID_DATA_LOADER = "AD_WorkflowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Workflow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Workflow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Workflow_BY_UUID_DATA_LOADER;
	}
}
