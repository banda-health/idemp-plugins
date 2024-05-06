package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Workflow_Access;

/**
 * Data Loader for AD_Workflow_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Workflow_AccessDataLoader extends PODataLoader<X_AD_Workflow_Access> {
	public static String DATALOADER_AD_Workflow_Access_BY_ID = "AD_Workflow_AccessByIdDataLoader";
	public static String DATALOADER_AD_Workflow_Access_BY_UUID = "AD_Workflow_AccessByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Workflow_Access.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Workflow_Access_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Workflow_Access_BY_UUID;
	}
}
