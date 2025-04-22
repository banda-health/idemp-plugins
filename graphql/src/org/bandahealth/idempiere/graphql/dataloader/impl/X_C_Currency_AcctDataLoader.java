package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCurrencyAcct;

/**
 * Data Loader for C_Currency_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_Currency_AcctDataLoader extends PODataLoader<MCurrencyAcct> {
	public static String DATALOADER_C_Currency_Acct_BY_ID = "C_Currency_AcctByIdDataLoader";
	public static String DATALOADER_C_Currency_Acct_BY_UUID = "C_Currency_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCurrencyAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Currency_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Currency_Acct_BY_UUID;
	}
}
