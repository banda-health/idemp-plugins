package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueStatus;

/**
 * Data Loader for R_IssueStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueStatusDataLoader extends PODataLoader<X_R_IssueStatus> {
	public static String R_IssueStatus_BY_ID_DATA_LOADER = "R_IssueStatusByIdDataLoader";
	public static String R_IssueStatus_BY_UUID_DATA_LOADER = "R_IssueStatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueStatus_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueStatus_BY_UUID_DATA_LOADER;
	}
}
