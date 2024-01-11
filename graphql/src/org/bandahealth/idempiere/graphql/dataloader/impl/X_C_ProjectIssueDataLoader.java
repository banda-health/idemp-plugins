package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProjectIssue;

/**
 * Data Loader for C_ProjectIssue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectIssueDataLoader extends PODataLoader<MProjectIssue> {
	public static String C_ProjectIssue_BY_ID_DATA_LOADER = "C_ProjectIssueByIdDataLoader";
	public static String C_ProjectIssue_BY_UUID_DATA_LOADER = "C_ProjectIssueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProjectIssue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectIssue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectIssue_BY_UUID_DATA_LOADER;
	}
}
