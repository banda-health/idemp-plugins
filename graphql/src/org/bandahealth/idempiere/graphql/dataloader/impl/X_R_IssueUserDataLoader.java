package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssueUser;

/**
 * Data Loader for R_IssueUser - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueUserDataLoader extends PODataLoader<MIssueUser> {
	public static String R_IssueUser_BY_ID_DATA_LOADER = "R_IssueUserByIdDataLoader";
	public static String R_IssueUser_BY_UUID_DATA_LOADER = "R_IssueUserByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssueUser.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueUser_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueUser_BY_UUID_DATA_LOADER;
	}
}
