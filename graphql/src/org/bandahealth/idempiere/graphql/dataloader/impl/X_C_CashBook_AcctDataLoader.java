package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_CashBook_Acct;

/**
 * Data Loader for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashBook_AcctDataLoader extends PODataLoader<X_C_CashBook_Acct> {
	public static String C_CashBook_Acct_BY_ID_DATA_LOADER = "C_CashBook_AcctByIdDataLoader";
	public static String C_CashBook_Acct_BY_UUID_DATA_LOADER = "C_CashBook_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_CashBook_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_CashBook_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_CashBook_Acct_BY_UUID_DATA_LOADER;
	}
}
