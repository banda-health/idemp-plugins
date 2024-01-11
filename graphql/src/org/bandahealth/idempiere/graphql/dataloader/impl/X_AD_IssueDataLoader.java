package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssue;

/**
 * Data Loader for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_IssueDataLoader extends PODataLoader<MIssue> {
	public static String AD_Issue_BY_ID_DATA_LOADER = "AD_IssueByIdDataLoader";
	public static String AD_Issue_BY_UUID_DATA_LOADER = "AD_IssueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Issue_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Issue_BY_UUID_DATA_LOADER;
	}
}
