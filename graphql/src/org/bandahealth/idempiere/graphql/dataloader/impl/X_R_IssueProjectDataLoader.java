package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueProject;

/**
 * Data Loader for R_IssueProject - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_R_IssueProjectDataLoader extends PODataLoader<X_R_IssueProject> {
	public static String DATALOADER_R_IssueProject_BY_ID = "R_IssueProjectByIdDataLoader";
	public static String DATALOADER_R_IssueProject_BY_UUID = "R_IssueProjectByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueProject.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueProject_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueProject_BY_UUID;
	}
}
