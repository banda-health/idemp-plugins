package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Data Loader for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Order_WorkflowDataLoader extends PODataLoader<X_PP_Order_Workflow> {
	public static String DATALOADER_PP_Order_Workflow_BY_ID = "PP_Order_WorkflowByIdDataLoader";
	public static String DATALOADER_PP_Order_Workflow_BY_UUID = "PP_Order_WorkflowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Workflow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PP_Order_Workflow_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PP_Order_Workflow_BY_UUID;
	}
}
