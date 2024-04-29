package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueKnown;

/**
 * Data Loader for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_IssueKnownDataLoader extends PODataLoader<X_R_IssueKnown> {
	public static String DATALOADER_R_IssueKnown_BY_ID = "R_IssueKnownByIdDataLoader";
	public static String DATALOADER_R_IssueKnown_BY_UUID = "R_IssueKnownByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueKnown.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueKnown_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueKnown_BY_UUID;
	}
}
