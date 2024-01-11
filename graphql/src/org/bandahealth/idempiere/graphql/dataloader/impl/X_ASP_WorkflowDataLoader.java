package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Workflow;

/**
 * Data Loader for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_WorkflowDataLoader extends PODataLoader<X_ASP_Workflow> {
	public static String ASP_Workflow_BY_ID_DATA_LOADER = "ASP_WorkflowByIdDataLoader";
	public static String ASP_Workflow_BY_UUID_DATA_LOADER = "ASP_WorkflowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Workflow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Workflow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Workflow_BY_UUID_DATA_LOADER;
	}
}
