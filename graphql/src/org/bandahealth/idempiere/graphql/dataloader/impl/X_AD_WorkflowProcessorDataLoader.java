package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WorkflowProcessor;

/**
 * Data Loader for AD_WorkflowProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_WorkflowProcessorDataLoader extends PODataLoader<X_AD_WorkflowProcessor> {
	public static String DATALOADER_AD_WorkflowProcessor_BY_ID = "AD_WorkflowProcessorByIdDataLoader";
	public static String DATALOADER_AD_WorkflowProcessor_BY_UUID = "AD_WorkflowProcessorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WorkflowProcessor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_WorkflowProcessor_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_WorkflowProcessor_BY_UUID;
	}
}
