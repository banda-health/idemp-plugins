package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueSystem;

/**
 * Data Loader for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueSystemDataLoader extends PODataLoader<X_R_IssueSystem> {
	public static String DATALOADER_R_IssueSystem_BY_ID = "R_IssueSystemByIdDataLoader";
	public static String DATALOADER_R_IssueSystem_BY_UUID = "R_IssueSystemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueSystem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueSystem_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueSystem_BY_UUID;
	}
}
