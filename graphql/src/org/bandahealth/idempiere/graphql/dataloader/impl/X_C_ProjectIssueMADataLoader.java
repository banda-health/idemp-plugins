package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ProjectIssueMA;

/**
 * Data Loader for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ProjectIssueMADataLoader extends PODataLoader<X_C_ProjectIssueMA> {
	public static String C_ProjectIssueMA_BY_ID_DATA_LOADER = "C_ProjectIssueMAByIdDataLoader";
	public static String C_ProjectIssueMA_BY_UUID_DATA_LOADER = "C_ProjectIssueMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_ProjectIssueMA_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_ProjectIssueMA_BY_UUID_DATA_LOADER;
	}
}
