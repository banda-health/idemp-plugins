package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Workflow;

/**
 * Data Loader for ASP_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_WorkflowDataLoader extends PODataLoader<X_ASP_Workflow> {
	public static String DATALOADER_ASP_Workflow_BY_ID = "ASP_WorkflowByIdDataLoader";
	public static String DATALOADER_ASP_Workflow_BY_UUID = "ASP_WorkflowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Workflow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Workflow_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Workflow_BY_UUID;
	}
}
