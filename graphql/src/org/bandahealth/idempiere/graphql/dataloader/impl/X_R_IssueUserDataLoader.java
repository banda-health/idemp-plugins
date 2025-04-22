package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueUser;

/**
 * Data Loader for R_IssueUser - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_IssueUserDataLoader extends PODataLoader<X_R_IssueUser> {
	public static String DATALOADER_R_IssueUser_BY_ID = "R_IssueUserByIdDataLoader";
	public static String DATALOADER_R_IssueUser_BY_UUID = "R_IssueUserByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueUser.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueUser_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueUser_BY_UUID;
	}
}
