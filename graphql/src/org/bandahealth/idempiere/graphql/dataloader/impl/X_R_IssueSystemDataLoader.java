package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssueSystem;

/**
 * Data Loader for R_IssueSystem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueSystemDataLoader extends PODataLoader<MIssueSystem> {
	public static String R_IssueSystem_BY_ID_DATA_LOADER = "R_IssueSystemByIdDataLoader";
	public static String R_IssueSystem_BY_UUID_DATA_LOADER = "R_IssueSystemByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssueSystem.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueSystem_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueSystem_BY_UUID_DATA_LOADER;
	}
}
