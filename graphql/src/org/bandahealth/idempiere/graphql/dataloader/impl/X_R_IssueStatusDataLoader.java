package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueStatus;

/**
 * Data Loader for R_IssueStatus - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueStatusDataLoader extends PODataLoader<X_R_IssueStatus> {
	public static String DATALOADER_R_IssueStatus_BY_ID = "R_IssueStatusByIdDataLoader";
	public static String DATALOADER_R_IssueStatus_BY_UUID = "R_IssueStatusByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueStatus.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueStatus_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueStatus_BY_UUID;
	}
}
