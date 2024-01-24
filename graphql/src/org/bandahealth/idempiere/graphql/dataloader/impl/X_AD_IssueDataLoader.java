package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MIssue;

/**
 * Data Loader for AD_Issue - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_IssueDataLoader extends PODataLoader<MIssue> {
	public static String DATALOADER_AD_Issue_BY_ID = "AD_IssueByIdDataLoader";
	public static String DATALOADER_AD_Issue_BY_UUID = "AD_IssueByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MIssue.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Issue_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Issue_BY_UUID;
	}
}
