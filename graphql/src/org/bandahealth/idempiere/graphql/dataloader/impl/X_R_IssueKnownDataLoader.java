package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueKnown;

/**
 * Data Loader for R_IssueKnown - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueKnownDataLoader extends PODataLoader<X_R_IssueKnown> {
	public static String R_IssueKnown_BY_ID_DATA_LOADER = "R_IssueKnownByIdDataLoader";
	public static String R_IssueKnown_BY_UUID_DATA_LOADER = "R_IssueKnownByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueKnown.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueKnown_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueKnown_BY_UUID_DATA_LOADER;
	}
}
