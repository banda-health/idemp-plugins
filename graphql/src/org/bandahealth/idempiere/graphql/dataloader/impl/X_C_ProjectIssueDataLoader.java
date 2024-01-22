package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectIssue;

/**
 * Data Loader for C_ProjectIssue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectIssueDataLoader extends PODataLoader<MProjectIssue> {
	public static String DATALOADER_C_ProjectIssue_BY_ID = "C_ProjectIssueByIdDataLoader";
	public static String DATALOADER_C_ProjectIssue_BY_UUID = "C_ProjectIssueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectIssue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectIssue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectIssue_BY_UUID;
	}
}
