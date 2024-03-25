package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssueSystem;

/**
 * Data Loader for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueSystemDataLoader extends PODataLoader<MIssueSystem> {
	public static String DATALOADER_R_IssueSystem_BY_ID = "R_IssueSystemByIdDataLoader";
	public static String DATALOADER_R_IssueSystem_BY_UUID = "R_IssueSystemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssueSystem.Table_Name;
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
