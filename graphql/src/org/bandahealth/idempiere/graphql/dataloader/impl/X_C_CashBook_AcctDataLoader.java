package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CashBook_Acct;

/**
 * Data Loader for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CashBook_AcctDataLoader extends PODataLoader<X_C_CashBook_Acct> {
	public static String DATALOADER_C_CashBook_Acct_BY_ID = "C_CashBook_AcctByIdDataLoader";
	public static String DATALOADER_C_CashBook_Acct_BY_UUID = "C_CashBook_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CashBook_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_CashBook_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_CashBook_Acct_BY_UUID;
	}
}
