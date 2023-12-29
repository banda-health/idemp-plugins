package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_PP_Order_Workflow;

/**
 * Data Loader for PP_Order_Workflow - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_WorkflowDataLoader extends PODataLoader<X_PP_Order_Workflow> {
	public static String PP_Order_Workflow_BY_ID_DATA_LOADER = "PP_Order_WorkflowByIdDataLoader";
	public static String PP_Order_Workflow_BY_UUID_DATA_LOADER = "PP_Order_WorkflowByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PP_Order_Workflow.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PP_Order_Workflow_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PP_Order_Workflow_BY_UUID_DATA_LOADER;
	}
}
