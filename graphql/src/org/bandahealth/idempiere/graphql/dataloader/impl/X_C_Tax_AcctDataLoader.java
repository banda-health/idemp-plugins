package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Tax_Acct;

/**
 * Data Loader for C_Tax_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_Tax_AcctDataLoader extends PODataLoader<X_C_Tax_Acct> {
	public static String DATALOADER_C_Tax_Acct_BY_ID = "C_Tax_AcctByIdDataLoader";
	public static String DATALOADER_C_Tax_Acct_BY_UUID = "C_Tax_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Tax_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Tax_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Tax_Acct_BY_UUID;
	}
}
