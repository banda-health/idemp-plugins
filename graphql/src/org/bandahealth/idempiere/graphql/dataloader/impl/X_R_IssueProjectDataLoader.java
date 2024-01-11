package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssueProject;

/**
 * Data Loader for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueProjectDataLoader extends PODataLoader<MIssueProject> {
	public static String R_IssueProject_BY_ID_DATA_LOADER = "R_IssueProjectByIdDataLoader";
	public static String R_IssueProject_BY_UUID_DATA_LOADER = "R_IssueProjectByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssueProject.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueProject_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueProject_BY_UUID_DATA_LOADER;
	}
}
