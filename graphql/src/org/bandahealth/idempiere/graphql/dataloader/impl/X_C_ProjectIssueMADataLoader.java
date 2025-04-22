package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_ProjectIssueMA;

/**
 * Data Loader for C_ProjectIssueMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ProjectIssueMADataLoader extends PODataLoader<X_C_ProjectIssueMA> {
	public static String DATALOADER_C_ProjectIssueMA_BY_ID = "C_ProjectIssueMAByIdDataLoader";
	public static String DATALOADER_C_ProjectIssueMA_BY_UUID = "C_ProjectIssueMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_ProjectIssueMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_ProjectIssueMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_ProjectIssueMA_BY_UUID;
	}
}
