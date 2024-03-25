package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Project_Acct;

/**
 * Data Loader for C_Project_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Project_AcctDataLoader extends PODataLoader<X_C_Project_Acct> {
	public static String DATALOADER_C_Project_Acct_BY_ID = "C_Project_AcctByIdDataLoader";
	public static String DATALOADER_C_Project_Acct_BY_UUID = "C_Project_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Project_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Project_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Project_Acct_BY_UUID;
	}
}
