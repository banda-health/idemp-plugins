package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCurrencyAcct;

/**
 * Data Loader for C_Currency_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Currency_AcctDataLoader extends PODataLoader<MCurrencyAcct> {
	public static String C_Currency_Acct_BY_ID_DATA_LOADER = "C_Currency_AcctByIdDataLoader";
	public static String C_Currency_Acct_BY_UUID_DATA_LOADER = "C_Currency_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCurrencyAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Currency_Acct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Currency_Acct_BY_UUID_DATA_LOADER;
	}
}
